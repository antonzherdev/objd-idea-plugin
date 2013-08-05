package com.antonzherdev.objd;

import com.antonzherdev.chain.B;
import com.antonzherdev.chain.F;
import com.antonzherdev.chain.IChain;
import com.antonzherdev.chain.Option;
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
import java.util.Arrays;
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
                .flatMap(new F<ObjDFile, List<ASTNode>>() {
                    @Override
                    public List<ASTNode> f(ObjDFile objDFile) {
                        return Arrays.asList(objDFile.getNode().getChildren(TokenSet.create(ObjDTypes.CLASS_STATEMENT)));
                    }
                })
                .map(new F<ASTNode,ObjDClassName>() {
                    @Override
                    public ObjDClassName f(ASTNode astNode) {
                        return astNode.getPsi(ObjDClassStatement.class).getClassName();
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
