package com.antonzherdev.objd;

import com.antonzherdev.chain.*;
import com.antonzherdev.objd.psi.*;
import com.antonzherdev.objd.tp.ObjDTp;
import com.antonzherdev.objd.tp.PsiRef;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.indexing.FileBasedIndex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.antonzherdev.chain.Chain.chain;
import static com.antonzherdev.chain.Chain.empty;

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

    public static IChain<ObjDClass> getAllClasses(Project project) {
        return getAllFiles(project).flatMap(new F<ObjDFile, Iterable<ObjDClass>>() {
            @Override
            public Iterable<ObjDClass> f(ObjDFile objDFile) {
                return getClassesInFile(objDFile);
            }
        });
    }

    public static Option<ObjDClass> findClass(Project project, final Iterable<String> pack, final String name) {
        return getAllFiles(project).filter(new F<ObjDFile, Boolean>() {
            @Override
            public Boolean f(ObjDFile f) {
                return f.getPackage().equals(pack);
            }
        }).flatMap(new F<ObjDFile,IChain<ObjDClass>>() {
            @Override
            public IChain<ObjDClass> f(ObjDFile objDFile) {
                return getClassesInFile(objDFile);
            }
        }).find(new F<ObjDClass, Boolean>() {
            @Override
            public Boolean f(ObjDClass objDClass) {
                return objDClass.getClassName().getName().equals(name);
            }
        });
    }

    public static Option<ObjDClass> findKernelClass(Project project, final String name) {
        return getClassesInFile(findFile(project, name).getOrNull()).find(new B<ObjDClass>() {
            @Override
            public Boolean f(ObjDClass x) {
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

    @SuppressWarnings("unchecked")
    private static Option<ObjDClassStatement> packageObject(Project project, List<String> pack) {
        List<String> parPack = pack.subList(0, pack.size() - 1);
        String name = pack.get(pack.size() - 1);
        return (Option)findClass(project, parPack, name);
    }

    public static IChain<ObjDClass> availableClassesInFile(final ObjDFile file) {
        final List<String> thisPack = file.getPackage().list();
        return getAllImports(file)
                .flatMap(new F<ObjDImportStatement, Iterable<ObjDClass>>() {
                    @Override
                    public Iterable<ObjDClass> f(ObjDImportStatement imp) {
                        final List<String> parts = chain(imp.getImportPartList())
                                .map(new F<ObjDImportPart, String>() {
                                    @Override
                                    public String f(ObjDImportPart objDImportPart) {
                                        return objDImportPart.getName();
                                    }
                                }).list();
                        if (parts.size() < 1) return empty();
                        String lastPart = parts.get(parts.size() - 1);
                        if ("_".equals(lastPart)) {
                            final List<String> pack = parts.subList(0, parts.size() - 1);
                            return getAllFiles(file.getProject())
                                    .filter(new F<ObjDFile, Boolean>() {
                                        @Override
                                        public Boolean f(ObjDFile objDFile) {
                                            return objDFile.getPackage().startsWith(pack);
                                        }
                                    })
                                    .flatMap(new F<ObjDFile, Iterable<ObjDClass>>() {
                                        @Override
                                        public Iterable<ObjDClass> f(ObjDFile objDFile) {
                                            return getClassesInFile(objDFile);
                                        }
                                    });
                        } else {
                            return findClass(file.getProject(), parts.subList(0, parts.size() - 1), lastPart);
                        }
                    }
                })
                .append(
                        getAllFiles(file.getProject()).filter(new B<ObjDFile>() {
                            @Override
                            public Boolean f(ObjDFile objDFile) {
                                return objDFile.getPackage().equals(thisPack);
                            }
                        }).flatMap(new F<ObjDFile, Iterable<ObjDClass>>() {
                            @Override
                            public Iterable<ObjDClass> f(ObjDFile objDFile) {
                                return getClassesInFile(objDFile);
                            }
                        }))
                .prepend(getKernelFiles(file.getProject()).flatMap(new F<ObjDFile, Iterable<ObjDClass>>() {
                    @Override
                    public Iterable<ObjDClass> f(ObjDFile objDFile) {
                        return getClassesInFile(objDFile);
                    }
                }));
    }

    private static IChain<ObjDImportStatement> getAllImports(ObjDFile file) {
        final List<String> thisPack = file.getPackage().list();
        return chain(file.getNode().getChildren(TokenSet.create(ObjDTypes.IMPORT_STATEMENT)))
                .map(new F<ASTNode, ObjDImportStatement>() {
                    @Override
                    public ObjDImportStatement f(ASTNode astNode) {
                        return astNode.getPsi(ObjDImportStatement.class);
                    }
                })
                .append(chain(packageObject(file.getProject(), thisPack)).flatMap(new F<ObjDClassStatement, Iterable<ObjDImportStatement>>() {
                    @Override
                    public Iterable<ObjDImportStatement> f(ObjDClassStatement objDClass) {
                        if(objDClass.getClassBody() == null) return empty();
                        return objDClass.getClassBody().getImportStatementList();
                    }
                }));
    }

    public static IChain<PsiNamedElement> availableDefsInFile(final ObjDFile file) {
        return getAllImports(file)
                .flatMap(new F<ObjDImportStatement, Iterable<PsiNamedElement>>() {
                    @Override
                    public Iterable<PsiNamedElement> f(ObjDImportStatement imp) {
                        final List<String> parts = chain(imp.getImportPartList())
                                .map(new F<ObjDImportPart, String>() {
                                    @Override
                                    public String f(ObjDImportPart objDImportPart) {
                                        return objDImportPart.getName();
                                    }
                                }).list();
                        if(parts.size() < 2) return empty();
                        String lastPart = parts.get(parts.size() - 1);
                        if ("_".equals(lastPart)) {
                            final String objName = parts.get(parts.size() - 2);
                            final List<String> pack = parts.subList(0, parts.size() - 2);
                            return getAllFiles(file.getProject())
                                    .filter(new F<ObjDFile, Boolean>() {
                                        @Override
                                        public Boolean f(ObjDFile objDFile) {
                                            return objDFile.getPackage().startsWith(pack);
                                        }
                                    })
                                    .flatMap(new F<ObjDFile, Iterable<ObjDClass>>() {
                                        @Override
                                        public Iterable<ObjDClass> f(ObjDFile objDFile) {
                                            return getClassesInFile(objDFile).filter(new B<ObjDClass>() {
                                                @Override
                                                public Boolean f(ObjDClass objDClass) {
                                                    return objDClass.getClassName().getName().equals(objName);
                                                }
                                            });
                                        }
                                    })
                                    .flatMap(new F<ObjDClass, Iterable<PsiNamedElement>>() {
                                        @Override
                                        public Iterable<PsiNamedElement> f(ObjDClass objDClass) {
                                            return classFields(objDClass);
                                        }
                                    });
                        } else {
                            return empty();
                        }
                    }
                });
    }


    private static IChain<ObjDFile> getKernelFiles(Project project) {
        return getAllFiles(project)
                .filter(new B<ObjDFile>() {
                    @Override
                    public Boolean f(ObjDFile f) {
                        return f.getPackage().head().getOrElse("").equals("core");
                    }
                });
    }


    public static IChain<ObjDClass> getClassesInFile(ObjDFile objDFile) {
        if(objDFile == null) return empty();
        return Chain.chain(objDFile.getNode().getChildren(TokenSet.create(ObjDTypes.CLASS_STATEMENT, ObjDTypes.TYPE_STATEMENT))).map(new F<ASTNode, ObjDClass>() {
            @Override
            public ObjDClass f(ASTNode astNode) {
                return astNode.getPsi(ObjDClass.class);
            }
        });
    }

    public static IChain<ObjDDefStatement> getDefsInFile(ObjDFile objDFile) {
        return Chain.chain(objDFile.getNode().getChildren(TokenSet.create(ObjDTypes.DEF_STATEMENT))).map(new F<ASTNode,ObjDDefStatement>() {
            @Override
            public ObjDDefStatement f(ASTNode astNode) {
                return astNode.getPsi(ObjDDefStatement.class);
            }
        });
    }

    public static IChain<ObjDFieldStatement> getValsInFile(ObjDFile objDFile) {
        return Chain.chain(objDFile.getNode().getChildren(TokenSet.create(ObjDTypes.FIELD_STATEMENT))).map(new F<ASTNode,ObjDFieldStatement>() {
            @Override
            public ObjDFieldStatement f(ASTNode astNode) {
                return astNode.getPsi(ObjDFieldStatement.class);
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

    public static IChain<PsiNamedElement> classFields(ObjDClass cls) {
        if(cls == null) return empty();

        if(cls instanceof ObjDClassStatement) {
            ObjDClassStatement stm = (ObjDClassStatement) cls;
            return chain(stm.getClassConstructorFieldList()).map(new F<ObjDClassConstructorField, PsiNamedElement>() {
                @Override
                public PsiNamedElement f(ObjDClassConstructorField x) {
                    return x.getDefName();
                }
            }).append(chain(stm.getClassBody() == null ? null : stm.getClassBody().getDefStatementList()).map(new F<ObjDDefStatement, PsiNamedElement>() {
                @Override
                public PsiNamedElement f(ObjDDefStatement x) {
                    return x.getDefName();
                }
            })).append(chain(stm.getClassBody() == null ? null : stm.getClassBody().getFieldStatementList()).map(new F<ObjDFieldStatement, PsiNamedElement>() {
                @Override
                public PsiNamedElement f(ObjDFieldStatement x) {
                    return x.getDefName();
                }
            })).append(chain(stm.getClassBody() == null ? null : stm.getClassBody().getEnumItemList()).map(new F<ObjDEnumItem, PsiNamedElement>() {
                @Override
                public PsiNamedElement f(ObjDEnumItem x) {
                    return x.getDefName();
                }
            }))
                    .append(enumSpecials(stm))
                    .append(parentFields(stm));
        } else {
            return parentFields(cls);
        }
    }

    private static IChain<PsiNamedElement> enumSpecials(ObjDClassStatement stm) {
        return stm.isEnum() ? classFields(findKernelClass(stm.getProject(), "Enum").getOrNull()) : null;
    }

    private static IChain<PsiNamedElement> parentFields(ObjDClass stm) {
        List<ObjDClassExtends> classExtends = stm.getClassExtendsList();
        if(classExtends == null || classExtends.isEmpty()) {
            if(stm.getClassName().getName().equals("Object")) return empty();
            else return classFields(findKernelClass(stm.getProject(), "Object").getOrNull());
        }

        return chain(classExtends).flatMap(new F<ObjDClassExtends,IChain<PsiNamedElement>>() {
            @Override
            public IChain<PsiNamedElement> f(ObjDClassExtends objDClassExtends) {
                PsiElement resolve = objDClassExtends.getDataTypeRef().getReference().resolve();
                if(resolve == null) return empty();
                return classFields((ObjDClassStatement) resolve.getParent());
            }
        });
    }

    public static boolean isAfterDot(PsiElement element) {
        return getDot(element).isDefined();
    }

    public static Option<Dot> getDot(final PsiElement element) {
        final PsiElement par = removeIndex(element.getParent());

        if(par.getParent() instanceof ObjDDotPartSimple) {
            final ObjDExprDot dot = (ObjDExprDot) par.getParent().getParent();
            if(dot.getExpr() == par) return Option.none();
            return Option.<Dot>some(new Dot() {
                @Override
                public Left getLeft() {
                    return new Left() {
                        Lazy<Tuple<ObjDTp, Boolean>> l = new Lazy<Tuple<ObjDTp, Boolean>>() {
                            @Override
                            protected Tuple<ObjDTp, Boolean> create() {
                                Iterator<ObjDDotPart> i = dot.getDotPartList().iterator();
                                ObjDExpr prev = dot.getExpr();
                                while (i.hasNext()) {
                                    ObjDDotPart n = i.next();
                                    ObjDExpr next = getExpForDotPart(n);
                                    if(next == par) return new Tuple<ObjDTp, Boolean>(prev.getTp(),
                                            n instanceof ObjDDotPartSimple && ((ObjDDotPartSimple) n).getDotType().isNullSafe());
                                    prev = next;
                                }
                                return new Tuple<ObjDTp, Boolean>(new ObjDTp.Unknown("Error in dot"), false);
                            }
                        };

                        @Override
                        public ObjDTp getTp() {
                            return l.get()._1;
                        }

                        @Override
                        public IChain<PsiRef> getRefsChain() {
                            Tuple<ObjDTp, Boolean> v = l.get();
                            return v._2 ? v._1.getNullSafeRefsChain() : v._1.getRefsChain();
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

    private static PsiElement removeIndex(PsiElement parent) {
        while(parent.getParent() instanceof ObjDExprIndex) {
            parent = parent.getParent();
        }
        return parent;
    }

    public static List<ObjDClassGeneric> getDeclaredGenerics(PsiElement element) {
        List<ObjDClassGeneric> ret = new ArrayList<ObjDClassGeneric>();
        while(element != null) {
            if(element instanceof ObjDClass) {
                ObjDClassGenerics classGenerics = ((ObjDClass) element).getClassGenerics();
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

    public static ObjDTp getTpForDotPart(ObjDDotPart part) {
        ObjDExpr e = getExpForDotPart(part);
        return e == null ? new ObjDTp.Unknown("Unknown dot part") : e.getTp();
    }

    public static ObjDExpr getExpForDotPart(ObjDDotPart part) {
        if(part instanceof ObjDDotPartSimple) {
            return ((ObjDDotPartSimple) part).getExpr();
        } else {
            return null;
        }
    }

    public static IChain<ObjDClass> getAllChildClasses(final ObjDClass cls) {
        return getAllClasses(cls.getProject())
                .filter(new F<ObjDClass, Boolean>() {
                    @Override
                    public Boolean f(ObjDClass objDClass) {
                        return getAllParentClasses(objDClass)
                                .find(new F<ObjDClass, Boolean>() {
                                    @Override
                                    public Boolean f(ObjDClass x) {
                                        return x == cls;
                                    }
                                }).isDefined();
                    }
                });
    }

    public static IChain<ObjDClass> getAllParentClasses(ObjDClass objDClass) {
        return chain(objDClass).recursive(new F<ObjDClass, Iterable<ObjDClass>>() {
            @Override
            public Iterable<ObjDClass> f(ObjDClass objDClass) {
                return chain(objDClass.getClassExtendsList()).flatMap(new F<ObjDClassExtends, Option<ObjDClass>>() {
                    @Override
                    public Option<ObjDClass> f(ObjDClassExtends objDClassExtends) {
                        ObjDClassName clsName = (ObjDClassName) objDClassExtends.getDataTypeRef().getReference().resolve();
                        return clsName == null ? Option.<ObjDClass>none() : Option.<ObjDClass>some((ObjDClass) clsName.getParent());

                    }
                });
            }
        });
    }

    public static boolean isDeclEquals(ObjDDefStatement l, ObjDDefStatement r) {
        return l.getDefName().getName().equals(r.getDefName().getName()) &&
                isDeclParametersEquals(l.getDefParameterList(), r.getDefParameterList());
    }

    private static boolean isDeclParametersEquals(List<ObjDDefParameter> l, List<ObjDDefParameter> r) {
        if(l.size() != r.size()) return false;
        for(int i = 0; i < l.size(); i++) {
            if(!l.get(i).getDefName().getName().equals(r.get(i).getDefName().getName())) return false;
        }
        return true;
    }
}
