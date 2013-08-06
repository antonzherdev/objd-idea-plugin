package com.antonzherdev.objd;

import com.antonzherdev.chain.*;
import com.antonzherdev.objd.psi.*;
import com.antonzherdev.objd.tp.ObjDTp;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.indexing.FileBasedIndex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.antonzherdev.chain.Chain.chain;

public class ObjDUtil {
    public static Option<ObjDFile> findFile(Project project, final String fileName) {
        return getAllVirtualFiles(project).filter(new B<VirtualFile>() {
            @Override
            public Boolean f(VirtualFile virtualFile) {
                return virtualFile.getNameWithoutExtension().equals(fileName);
            }
        }).map(toObjDFileF(project)).first();
    }

    public static IChain<ObjDFile> getAllFiles(final Project project) {
        return getAllVirtualFiles(project).map(toObjDFileF(project));
    }

    public static Option<ObjDClassStatement> findKernelClass(Project project, final String name) {
        return getClassesInFile(findFile(project, name).get()).find(new B<ObjDClassStatement>() {
            @Override
            public Boolean f(ObjDClassStatement x) {
                return x.getClassName().getName().equals(name);
            }
        });
    }

    private static F<VirtualFile, ObjDFile> toObjDFileF(final Project project) {
        return new F<VirtualFile, ObjDFile>() {
            @Override
            public ObjDFile f(VirtualFile virtualFile) {
                return (ObjDFile) PsiManager.getInstance(project).findFile(virtualFile);
            }
        };
    }

    private static IChain<VirtualFile> getAllVirtualFiles(Project project) {
        return chain(FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME,
                ObjDFileType.INSTANCE, GlobalSearchScope.allScope(project)));
    }

    public static IChain<ObjDClassName> availableClassesInFile(PsiFile file) {
        return chain(file.getNode().getChildren(TokenSet.create(ObjDTypes.IMPORT_STATEMENT)))
                .map(new F<ASTNode,ObjDFile>() {
                    @Override
                    public ObjDFile f(ASTNode astNode) {
                        ObjDImportOdFile od = astNode.getPsi(ObjDImportStatement.class).getImportOdFile();
                        if(od == null) return null;
                        return (ObjDFile) od.getReference().resolve();
                    }
                })
                .prepend((ObjDFile)file)
                .flatMap(new F<ObjDFile,IChain<ObjDClassStatement>>() {
                    @Override
                    public IChain<ObjDClassStatement> f(ObjDFile objDFile) {
                        return getClassesInFile(objDFile);
                    }
                })
                .map(new F<ObjDClassStatement,ObjDClassName>() {
                    @Override
                    public ObjDClassName f(ObjDClassStatement x) {
                        return x.getClassName();
                    }
                });
    }

    private static IChain<ObjDClassStatement> getClassesInFile(ObjDFile objDFile) {
        return Chain.chain(objDFile.getNode().getChildren(TokenSet.create(ObjDTypes.CLASS_STATEMENT))).map(new F<ASTNode,ObjDClassStatement>() {
            @Override
            public ObjDClassStatement f(ASTNode astNode) {
                return astNode.getPsi(ObjDClassStatement.class);
            }
        });
    }

    public static Option<ObjDClassStatement> getClass(PsiElement element) {
        while(element != null) {
            if(element instanceof ObjDClassStatement) return Option.some((ObjDClassStatement)element);
            element = element.getParent();
        }
        return Option.none();
    }

    public static IChain<PsiNamedElement> classFields(ObjDClassStatement stm) {
        return chain(stm.getClassConstructorFieldList()).map(new F<ObjDClassConstructorField, PsiNamedElement>() {
            @Override
            public PsiNamedElement f(ObjDClassConstructorField x) {
                return x.getDefName();
            }
        }).append(chain(stm.getClassBody().getDefStatementList()).map(new F<ObjDDefStatement, PsiNamedElement>() {
            @Override
            public PsiNamedElement f(ObjDDefStatement x) {
                return x.getDefName();
            }
        })).append(chain(stm.getClassBody().getFieldStatementList()).map(new F<ObjDFieldStatement, PsiNamedElement>() {
            @Override
            public PsiNamedElement f(ObjDFieldStatement x) {
                return x.getDefName();
            }
        })).append(parentFields(stm.getClassExtends()));
    }

    private static IChain<PsiNamedElement> parentFields(ObjDClassExtends classExtends) {
        if(classExtends == null) return chain();
        PsiElement resolve = classExtends.getDataTypeRef().getReference().resolve();
        if(resolve == null) return chain();
        return classFields((ObjDClassStatement) resolve.getParent());
    }

    public static boolean isAfterDot(PsiElement element) {
        return getDot(element).isDefined();
    }

    public static Option<Dot> getDot(final PsiElement element) {
        final PsiElement par = element.getParent();
        if(par.getParent() instanceof ObjDExprDot) {
            final ObjDExprDot dot = (ObjDExprDot) par.getParent();
            if(dot.getExprList().get(0) == par) return Option.none();
            return Option.<Dot>some(new Dot() {
                @Override
                public Left getLeft() {
                    return new Left() {
                        @Override
                        public ObjDTp getTp() {
                            Iterator<ObjDExpr> i = dot.getExprList().iterator();
                            ObjDExpr prev = null;
                            while (i.hasNext()) {
                                ObjDExpr next = i.next();
                                if(next == par) return prev.getTp();
                                prev = next;
                            }
                            return new ObjDTp.Unknown("Error in dot");
                        }
                    };
                }

                @Override
                public PsiElement getRight() {
                    return element;
                }
            });
        } else {
            return Option.none();
        }
    }

    public static List<ObjDClassGeneric> getDeclaredGenerics(PsiElement element) {
        List<ObjDClassGeneric> ret = new ArrayList<ObjDClassGeneric>();
        while(element != null) {
            if(element instanceof ObjDClassStatement) {
                ObjDClassGenerics classGenerics = ((ObjDClassStatement) element).getClassGenerics();
                if(classGenerics != null) ret.addAll(classGenerics.getClassGenericList());
            }
            if(element instanceof ObjDDefStatement) {
                ObjDClassGenerics classGenerics = ((ObjDDefStatement) element).getClassGenerics();
                if(classGenerics != null) ret.addAll(classGenerics.getClassGenericList());
            }
            element = element.getParent();
        }
        return ret;
    }

}
