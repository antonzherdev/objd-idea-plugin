package com.antonzherdev.objd.tp;

import com.antonzherdev.chain.*;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;

import java.util.List;

import static com.antonzherdev.chain.Chain.chain;
import static com.antonzherdev.chain.Chain.empty;

public abstract class ObjDTp {
    public static final F<ObjDDefStatement,PsiNamedElement> DEF_NAME = new F<ObjDDefStatement, PsiNamedElement>() {
        @Override
        public PsiNamedElement f(ObjDDefStatement x) {
            return x.getDefName();
        }
    };
    public static final Unknown NO_SELF = new Unknown("No self");
    private static Class optionClass;

    public static ObjDTp getTpForExpression(ObjDExpr expr) {
        if(expr instanceof ObjDExprCall) {
            ObjDExprCall call = (ObjDExprCall) expr;
            PsiElement ref = call.getCallName().getReference().resolve();
            if(ref instanceof ObjDClassName) {
//                ObjDExprCallParams pars = call.getExprCallParams();
                return new Class((ObjDClass) ref.getParent());
            } else if (ref instanceof ObjDDefName) {
                return getTpForDef(ref.getParent());
            } else {
                return new Unknown("Unknown ref " + ref);
            }
        } else if(expr instanceof ObjDExprSelf) {
            return ObjDUtil.getClass(expr).map(new F<ObjDClassStatement,ObjDTp>() {
                @Override
                public Class f(ObjDClassStatement x) {
                    return new Class(x);
                }
            }).getOrElse(NO_SELF);
        } else if(expr instanceof ObjDExprSuper) {
            return ObjDUtil.getClass(expr).map(new F<ObjDClassStatement, ObjDTp>() {
                @Override
                public ObjDTp f(ObjDClassStatement x) {
                    List<ObjDClassExtends> extList = x.getClassExtendsList();
                    if(extList == null || extList.isEmpty()) {
                        return new Class(ObjDUtil.findKernelClass(x.getProject(), "Object").getOrNull());
                    }
                    PsiElement resolve = extList.get(0).getDataTypeRef().getReference().resolve();
                    if (resolve == null) return new Unknown("Wrong super");
                    return new Class((ObjDClassStatement) resolve.getParent());
                }
            }).getOrElse(NO_SELF);
        } else if(expr instanceof ObjDExprDot) {
            List<ObjDDotPart> exprList = ((ObjDExprDot) expr).getDotPartList();
            if(exprList.isEmpty()) return ((ObjDExprDot) expr).getExpr().getTp();
            ObjDDotPart part = exprList.get(exprList.size() - 1);
            return ObjDUtil.getTpForDotPart(part);
        } else if(expr instanceof ObjDExprBind) {
            if(((ObjDExprBind) expr).getExprList().size() == 1) {
                return getTpForExpression(((ObjDExprBind) expr).getExprList().get(0));
            }
        }else if(expr instanceof ObjDExprSet) {
            if(((ObjDExprSet) expr).getExprList().size() == 1) {
                return getTpForExpression(((ObjDExprSet) expr).getExprList().get(0));
            }
        }

        return new Unknown("Unknown class " + expr.getClass().getName());
    }

    private static ObjDTp getTpForDef(final PsiElement def) {
        Option<ObjDDataType> tp;
        F0<ObjDTp> d;
        if(def instanceof ObjDDefStatement) {
            tp = Option.opt(((ObjDDefStatement) def).getDataType());
            d = new F0<ObjDTp>() {
                @Override
                public ObjDTp f() {
                    return ((ObjDDefStatement) def).getExpr().getTp();
                }
            };
        } else if(def instanceof ObjDDefParameter) {
            tp = Option.opt(((ObjDDefParameter) def).getDataType());
            d = null;
        } else if(def instanceof ObjDExprVal) {
            tp = Option.opt(((ObjDExprVal) def).getDataType());
            d = new F0<ObjDTp>() {
                @Override
                public ObjDTp f() {
                    return ((ObjDExprVal) def).getExpr().getTp();
                }
            };
        } else if(def instanceof ObjDFieldStatement) {
            tp = Option.opt(((ObjDFieldStatement) def).getDataType());
            d = new F0<ObjDTp>() {
                @Override
                public ObjDTp f() {
                    return ((ObjDFieldStatement) def).getExpr().getTp();
                }
            };
        } else if(def instanceof ObjDClassConstructorField) {
            tp = Option.opt(((ObjDClassConstructorField) def).getDataType());
            d = new F0<ObjDTp>() {
                @Override
                public ObjDTp f() {
                    return ((ObjDClassConstructorField) def).getExpr().getTp();
                }
            };
        } else {
            return new Unknown("Unknown def class " + def.getClass().getName());
        }

        return tp.map(new F<ObjDDataType,ObjDTp>() {
            @Override
            public ObjDTp f(ObjDDataType x) {
                return getTpForDataType(x);
            }
        }).getOrElse(d);
    }

    private static ObjDTp getTpForDataType(ObjDDataType dataType) {
        if(dataType instanceof ObjDDataTypeSimple) {
            ObjDDataTypeRef dataTypeRef = ((ObjDDataTypeSimple) dataType).getDataTypeRef();
            if(dataTypeRef == null) return new Unknown("No reference for data type " + dataType);
            PsiElement ref = dataTypeRef.getReference().resolve();
            if(ref == null) return new Unknown("No reference for data type " + dataType);
            if(ref instanceof ObjDClassName) {
                PsiElement par = ref.getParent();
                if(par instanceof ObjDClass) {
                    return new Class((ObjDClass) par);
                } else if(par instanceof ObjDClassGeneric) {
                    return new Generic((ObjDClassGeneric) par);
                } else {
                    return new Unknown("Unknown class type " + par.getClass());
                }
            } else {
                return new Unknown("Unknown data type class ref " + ref.getClass());
            }
        } else if(dataType instanceof ObjDDataTypeOption) {
            ObjDTp tp = getTpForDataType(((ObjDDataTypeOption) dataType).getDataType());
            if(tp instanceof Unknown) return tp;

            if(optionClass == null) optionClass = new Class(ObjDUtil.findKernelClass(dataType.getProject(), "Option").get());
            return new Opt(optionClass, tp);
        } else if(dataType instanceof ObjDDataTypeCollection) {
            return getKernelClassTp(dataType, "ImArray");
        } else if(dataType instanceof ObjDDataTypeMap) {
            return getKernelClassTp(dataType, "ImHashMap");
        } else if(dataType instanceof ObjDDataTypeTuple) {
            return getKernelClassTp(dataType, "Tuple" + ((ObjDDataTypeTuple) dataType).getDataTypeList().size());
        } else {
            return new Unknown("Not simple type " + dataType.getClass());
        }
    }

    private static ObjDTp getKernelClassTp(ObjDDataType dataType, String name) {
        return ObjDUtil.findKernelClass(dataType.getProject(), name).map(new F<ObjDClass,ObjDTp>() {
            @Override
            public ObjDTp f(ObjDClass x) {
                return new Class(x);
            }
        }).getOrElse(new Unknown("No " + name));
    }

    public abstract IChain<PsiRef> getRefsChain();
    public abstract IChain<PsiRef> getNullSafeRefsChain();

    public boolean isDefined() {
        return true;
    }

    public static class Unknown extends ObjDTp {
        private final String error;

        public Unknown(String error) {
            this.error = error;
        }

        @Override
        public IChain<PsiRef> getRefsChain() {
            return chain();
        }

        @Override
        public IChain<PsiRef> getNullSafeRefsChain() {
            return chain();
        }

        public boolean isDefined() {
            return false;
        }
    }

    public static class Object extends ObjDTp {

        private final ObjDClass cls;

        public Object(ObjDClass cls) {
            this.cls = cls;
        }

        @Override
        public IChain<PsiRef> getRefsChain() {
            if(!(cls instanceof ObjDClassStatement)) return empty();
            ObjDClassStatement classStatement = (ObjDClassStatement) cls;
            if(classStatement.getClassBody() == null) return empty();
            return
                    Chain.<PsiRef>chain().append(
                            chain(classStatement.getClassBody().getDefStatementList()).filter(new B<ObjDDefStatement>() {
                                @Override
                                public Boolean f(ObjDDefStatement x) {
                                    return x.isStatic();
                                }
                            }).map(DEF_NAME).map(PsiRef.APPLY)
                    ).append(
                            chain(classStatement.getClassBody().getFieldStatementList()).filter(new B<ObjDFieldStatement>() {
                                @Override
                                public Boolean f(ObjDFieldStatement x) {
                                    return x.isStatic();
                                }
                            }).map(new F<ObjDFieldStatement, PsiNamedElement>() {
                                @Override
                                public PsiNamedElement f(ObjDFieldStatement x) {
                                    return x.getDefName();
                                }
                            }).map(PsiRef.APPLY)
                    ).append(
                            chain(classStatement.getClassBody().getEnumItemList()).map(new F<ObjDEnumItem, PsiNamedElement>() {
                                @Override
                                public PsiNamedElement f(ObjDEnumItem x) {
                                    return x.getDefName();
                                }
                            }).map(PsiRef.APPLY)
                    ).append(classStatement.isEnum()
                            ?
                            chain(ObjDUtil.findKernelClass(classStatement.getProject(), "ODEnum")
                            ).<ObjDClassStatement>cast().flatMap(new F<ObjDClassStatement,List<ObjDDefStatement>>() {
                                @Override
                                public List<ObjDDefStatement> f(ObjDClassStatement x) {
                                    return x.getClassBody().getDefStatementList();
                                }
                            }).filter(new B<ObjDDefStatement>() {
                                @Override
                                public Boolean f(ObjDDefStatement x) {
                                    return x.isStatic();
                                }
                            }).map(DEF_NAME).map(PsiRef.APPLY)
                            : Chain.<PsiRef>empty());
        }
        @Override
        public IChain<PsiRef> getNullSafeRefsChain() {
            return chain();
        }
    }

    public static class Class extends ObjDTp {
        private final ObjDClass classStatement;

        public Class(ObjDClass classStatement) {
            this.classStatement = classStatement;
        }

        @Override
        public IChain<PsiRef> getRefsChain() {
            return ObjDUtil.classFields(classStatement).map(PsiRef.APPLY);
        }
        @Override
        public IChain<PsiRef> getNullSafeRefsChain() {
            return chain();
        }
    }

    public static class Opt extends ObjDTp {
        private Class optionClass;
        private final ObjDTp tp;

        public Opt(Class optionClass, ObjDTp tp) {
            this.optionClass = optionClass;
            this.tp = tp;
        }

        @Override
        public IChain<PsiRef> getRefsChain() {
            return optionClass.getRefsChain().append(tp.getRefsChain());
        }

        @Override
        public IChain<PsiRef> getNullSafeRefsChain() {
            return tp.getRefsChain();
        }

        public ObjDTp getTp() {
            return tp;
        }
    }

    public static class Generic extends ObjDTp {
        private final ObjDClassGeneric generic;

        public Generic(ObjDClassGeneric generic) {
            this.generic = generic;
        }

        @Override
        public IChain<PsiRef> getRefsChain() {
            return empty();
        }
        @Override
        public IChain<PsiRef> getNullSafeRefsChain() {
            return chain();
        }

        public boolean isDefined() {
            return false;
        }
    }
}
