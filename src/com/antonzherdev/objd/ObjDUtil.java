package com.antonzherdev.objd;

import com.antonzherdev.chain.*;
import com.antonzherdev.objd.psi.*;
import com.antonzherdev.objd.tp.ObjDTp;
import com.antonzherdev.objd.tp.PsiRef;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.CachedValue;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.util.indexing.FileBasedIndex;
import org.jetbrains.annotations.Nullable;

import java.util.*;

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
                return Chain.chain(objDFile.getClasses());
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
                return Chain.chain(objDFile.getClasses());
            }
        }).find(new F<ObjDClass, Boolean>() {
            @Override
            public Boolean f(ObjDClass objDClass) {
                final ObjDClassName className = objDClass.getClassName();
                final String nm = className == null ? "" : className.getName();
                return name.equals(nm);
            }
        });
    }

    private static Map<String, CachedValue<ObjDClass>> kernelClasses = new HashMap<String, CachedValue<ObjDClass>>();
    public static Option<ObjDClass> findKernelClass(final Project project, final String name) {
        CachedValue<ObjDClass> val = kernelClasses.get(name);
        if(val == null) {
            val = CachedValuesManager.getManager(project).createCachedValue(new CachedValueProvider<ObjDClass>() {
                @Nullable
                @Override
                public Result<ObjDClass> compute() {
                    final Option<ObjDClass> objDClasses = findFile(project, name).map(new F<ObjDFile,IChain<ObjDClass>>() {
                        @Override
                        public IChain<ObjDClass> f(ObjDFile objDFile) {
                            return Chain.chain(objDFile.getClasses());
                        }
                    }).getOrElse(Chain.<ObjDClass>empty()).find(new B<ObjDClass>() {
                        @Override
                        public Boolean f(ObjDClass x) {
                            final ObjDClassName nm = x.getClassName();
                            return name.equals(nm == null ? "" : nm.getName());
                        }
                    });
                    if(objDClasses.isEmpty()) return Result.create(null);
                    final ObjDClass cls = objDClasses.get();
                    return Result.create(objDClasses.get(), cls);
                }
            });
            kernelClasses.put(name, val);
        }
        return Option.fromNullable(val.getValue());
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
    public static Option<ObjDClassStatement> packageObject(Project project, List<String> pack) {
        return (Option)findClass(project, pack, "");
    }


    public static IChain<ObjDFile> getKernelFiles(Project project) {
        return getAllFiles(project)
                .filter(new B<ObjDFile>() {
                    @Override
                    public Boolean f(ObjDFile f) {
                        return f.getPackage().get(0).equals("objd");
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

    public static IChain<ObjDDefName> classFields(ObjDClass cls) {
        if(cls == null) return empty();

        if(cls instanceof ObjDClassStatement) {
            ObjDClassStatement stm = (ObjDClassStatement) cls;
            return chain(stm.getClassConstructorFieldList()).map(new F<ObjDClassConstructorField, ObjDDefName>() {
                @Override
                public ObjDDefName f(ObjDClassConstructorField x) {
                    return x.getDefName();
                }
            }).append(chain(stm.getClassBody() == null ? null : stm.getClassBody().getDefStatementList()).map(new F<ObjDDefStatement, ObjDDefName>() {
                @Override
                public ObjDDefName f(ObjDDefStatement x) {
                    return x.getDefName();
                }
            })).append(chain(stm.getClassBody() == null ? null : stm.getClassBody().getFieldStatementList()).map(new F<ObjDFieldStatement, ObjDDefName>() {
                @Override
                public ObjDDefName f(ObjDFieldStatement x) {
                    return x.getDefName();
                }
            })).append(chain(stm.getClassBody() == null ? null : stm.getClassBody().getEnumItemList()).map(new F<ObjDEnumItem, ObjDDefName>() {
                @Override
                public ObjDDefName f(ObjDEnumItem x) {
                    return x.getDefName();
                }
            }))
                    .append(enumSpecials(stm))
                    .append(parentFields(stm));
        } else {
            return parentFields(cls);
        }
    }

    private static IChain<ObjDDefName> enumSpecials(ObjDClassStatement stm) {
        return stm.isEnum() ? classFields(findKernelClass(stm.getProject(), "Enum").getOrNull()) : null;
    }

    private static IChain<ObjDDefName> parentFields(ObjDClass stm) {
        List<ObjDClassExtends> classExtends = stm.getClassExtendsList();
        if(classExtends == null || classExtends.isEmpty()) {
            if(stm.getName().equals("Object")) return empty();
            else return classFields(getBaseObject(stm.getProject()));
        }

        return chain(classExtends).flatMap(new F<ObjDClassExtends,IChain<ObjDDefName>>() {
            @Override
            public IChain<ObjDDefName> f(ObjDClassExtends objDClassExtends) {
                PsiElement resolve = objDClassExtends.getDataTypeRef().getReference().resolve();
                if(resolve == null) return empty();
                return classFields((ObjDClassStatement) resolve.getParent());
            }
        });
    }

    private static ObjDClass base;
    public static ObjDClass getBaseObject(Project p) {
        if(base == null) base = findKernelClass(p, "Object").getOrNull();
        return base;
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
                                    if(next == par) {
                                        if(prev == null) break;
                                        final boolean b = n instanceof ObjDDotPartSimple
                                                && ((ObjDDotPartSimple) n).getDotType() != null
                                                && ((ObjDDotPartSimple) n).getDotType().isNullSafe();
                                        return new Tuple<ObjDTp, Boolean>(prev.getTp(), b);
                                    }
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


    public static boolean isDeclEquals(ObjDDefStatement l, ObjDDefStatement r) {
        return l.getDefName().getName().equals(r.getDefName().getName()) &&
                isDeclParametersEquals(l.getDefParameterList(), r.getDefParameterList());
    }

    private static boolean isDeclParametersEquals(List<ObjDDefParameter> l, List<ObjDDefParameter> r) {
        if(l.size() != r.size()) return false;
        for(int i = 0; i < l.size(); i++) {
            ObjDDefName ldn = l.get(i).getDefName();
            ObjDDefName rdn = r.get(i).getDefName();
            if(ldn == null || rdn == null) if(ldn == rdn) continue; else break;
            if(!ldn.getName().equals(rdn.getName())) return false;
        }
        return true;
    }
}
