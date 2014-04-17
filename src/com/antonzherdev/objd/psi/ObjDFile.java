package com.antonzherdev.objd.psi;

import com.antonzherdev.chain.B;
import com.antonzherdev.chain.Chain;
import com.antonzherdev.chain.F;
import com.antonzherdev.chain.IChain;
import com.antonzherdev.objd.ObjDFileType;
import com.antonzherdev.objd.ObjDLanguage;
import com.antonzherdev.objd.ObjDUtil;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.util.CachedValue;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.antonzherdev.chain.Chain.chain;
import static com.antonzherdev.chain.Chain.empty;

public class ObjDFile extends PsiFileBase {
    public ObjDFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ObjDLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return ObjDFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "ObjD File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

    private CachedValue<List<String>> packageCache;
    public List<String> getPackage() {
        if(packageCache == null) {
            packageCache = CachedValuesManager.getManager(getProject()).createCachedValue(new CachedValueProvider<List<String>>() {
                @Nullable
                @Override
                public Result<List<String>> compute() {
                    ASTNode[] packs = getNode().getChildren(TokenSet.create(ObjDTypes.PACK_STATEMENT));
                    if(packs.length == 0) return Result.create(Arrays.<String>asList(), ObjDFile.this);
                    ASTNode pack = packs[0];
                    final ObjDPackStatement psi = pack.getPsi(ObjDPackStatement.class);
                    return Result.create(chain(psi.getPackPartList()).map(new F<ObjDPackPart, String>() {
                        @Override
                        public String f(ObjDPackPart objDPackPart) {
                            return objDPackPart.getName();
                        }
                    }).list(), psi);
                }
            }, false);
        }
        return packageCache.getValue();
    }

    private CachedValue<List<ObjDClass>> availableClassesCache;
    public List<ObjDClass> getAvailableClasses() {
        if(availableClassesCache == null) {
            availableClassesCache = CachedValuesManager.getManager(getProject()).createCachedValue(new CachedValueProvider<List<ObjDClass>>() {
                @Nullable
                @Override
                public Result<List<ObjDClass>> compute() {
                    final List<Object> deps = new ArrayList<Object>();
                    deps.add(ObjDFile.this);
                    return Result.create(getAllImports()
                            .flatMap(new F<List<String>, Iterable<ObjDClass>>() {
                                @Override
                                public Iterable<ObjDClass> f(List<String> parts) {
                                    if (parts.size() < 2) return empty();
                                    String lastPart = parts.get(parts.size() - 1);
                                    if ("_".equals(lastPart)) {
                                        final List<String> pack = parts.subList(0, parts.size() - 1);
                                        return ObjDUtil.getAllFiles(getProject())
                                                .filter(new F<ObjDFile, Boolean>() {
                                                    @Override
                                                    public Boolean f(ObjDFile objDFile) {
                                                        return objDFile.getPackage().equals(pack);
                                                    }
                                                })
                                                .flatMap(new F<ObjDFile, Iterable<ObjDClass>>() {
                                                    @Override
                                                    public Iterable<ObjDClass> f(ObjDFile objDFile) {
                                                        deps.add(objDFile);
                                                        return objDFile.getClasses();
                                                    }
                                                });
                                    } else {
                                        return ObjDUtil.findClass(getProject(), parts.subList(0, parts.size() - 1), lastPart);
                                    }
                                }
                            })
                            .append(ObjDUtil.getKernelFiles(getProject()).flatMap(new F<ObjDFile, Iterable<ObjDClass>>() {
                                @Override
                                public Iterable<ObjDClass> f(ObjDFile objDFile) {
                                    return objDFile.getClasses();
                                }
                            })).list(), deps);
                }
            }, false);
        }
        return availableClassesCache.getValue();
    }

    private CachedValue<List<ObjDClass>> classesCache;
    public  List<ObjDClass> getClasses() {
        if(classesCache == null) {
            classesCache = CachedValuesManager.getManager(getProject()).createCachedValue(new CachedValueProvider<List<ObjDClass>>() {
                @Nullable
                @Override
                public Result<List<ObjDClass>> compute() {
                    return Result.create(Chain.chain(getNode().getChildren(TokenSet.create(ObjDTypes.CLASS_STATEMENT, ObjDTypes.TYPE_STATEMENT))).map(new F<ASTNode, ObjDClass>() {
                        @Override
                        public ObjDClass f(ASTNode astNode) {
                            return astNode.getPsi(ObjDClass.class);
                        }
                    }).list(), ObjDFile.this);
                }
            }, false);
        }
        return classesCache.getValue();
    }

    @SuppressWarnings("unchecked")
    private IChain<List<String>> getAllImports() {
        final List<String> thisPack = getPackage();
        final ArrayList<String> thisImport = new ArrayList<String>(thisPack);
        thisImport.add("_");
        return chain(getNode().getChildren(TokenSet.create(ObjDTypes.IMPORT_STATEMENT)))
                .map(new F<ASTNode, ObjDImportStatement>() {
                    @Override
                    public ObjDImportStatement f(ASTNode astNode) {
                        return astNode.getPsi(ObjDImportStatement.class);
                    }
                })
                .append(chain(ObjDUtil.packageObject(getProject(), thisPack)).flatMap(new F<ObjDClassStatement, Iterable<ObjDImportStatement>>() {
                    @Override
                    public Iterable<ObjDImportStatement> f(ObjDClassStatement objDClass) {
                        if(objDClass.getClassBody() == null) return empty();
                        return objDClass.getClassBody().getImportStatementList();
                    }
                })).map(new F<ObjDImportStatement, List<String>>() {
                    @Override
                    public List<String> f(ObjDImportStatement imp) {
                        return  chain(imp.getImportPartList())
                                .map(new F<ObjDImportPart, String>() {
                                    @Override
                                    public String f(ObjDImportPart objDImportPart) {
                                        return objDImportPart.getName();
                                    }
                                }).list();
                    }
                }).prepend(thisImport);
    }

    private CachedValue<List<ObjDDefName>> defsCache;

    public List<ObjDDefName> getDefs() {
        if(defsCache == null) {
            defsCache = CachedValuesManager.getManager(getProject()).createCachedValue(new CachedValueProvider<List<ObjDDefName>>() {
                @Nullable
                @Override
                public Result<List<ObjDDefName>> compute() {
                    final List<Object> deps = new ArrayList<Object>();
                    deps.add(ObjDFile.this);
                    return Result.create(getAllImports()
                            .flatMap(new F<List<String>, Iterable<ObjDDefName>>() {
                                @Override
                                public Iterable<ObjDDefName> f(final List<String> parts) {
                                    if (parts.size() < 2) return empty();
                                    String lastPart = parts.get(parts.size() - 1);
                                    if ("_".equals(lastPart)) {
                                        final String objName = parts.get(parts.size() - 2);
                                        final List<String> pack = parts.subList(0, parts.size() - 2);
                                        final List<String> pack2 = parts.subList(0, parts.size() - 1);
                                        return ObjDUtil.getAllFiles(getProject())
                                                .filter(new F<ObjDFile, Boolean>() {
                                                    @Override
                                                    public Boolean f(ObjDFile objDFile) {
                                                        return objDFile.getPackage().equals(pack) || objDFile.getPackage().equals(pack2);
                                                    }
                                                })
                                                .flatMap(new F<ObjDFile, Iterable<ObjDClass>>() {
                                                    @Override
                                                    public Iterable<ObjDClass> f(final ObjDFile objDFile) {
                                                        return Chain.chain(objDFile.getClasses()).filter(new B<ObjDClass>() {
                                                            @Override
                                                            public Boolean f(ObjDClass objDClass) {
                                                                final String nm = objDClass.getName();
                                                                if ((objName.equals(nm) && objDFile.getPackage().equals(pack)) ||
                                                                        (nm.isEmpty() && objDFile.getPackage().equals(pack2))) {
                                                                    deps.add(objDClass);
                                                                    return true;
                                                                }
                                                                return false;
                                                            }
                                                        }).list();
                                                    }
                                                })
                                                .flatMap(new F<ObjDClass, Iterable<ObjDDefName>>() {
                                                    @Override
                                                    public Iterable<ObjDDefName> f(ObjDClass objDClass) {
                                                        return ObjDUtil.classFields(objDClass);
                                                    }
                                                }).list();
                                    } else {
                                        return empty();
                                    }
                                }
                            }).list(), deps);
                }
            }, false);
        }
        return defsCache.getValue();
    }
}