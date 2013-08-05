package com.antonzherdev.objd.tp;

import com.antonzherdev.chain.*;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;

import static com.antonzherdev.chain.Chain.chain;
import static com.antonzherdev.chain.Chain.empty;
import static com.antonzherdev.chain.Chain.unionChain;

public abstract class ObjDTp {

    public static final Unknown NO_SELF = new Unknown("No self");

    public static ObjDTp getTpForExpression(ObjDExpr expr) {
        if(expr instanceof ObjDExprCall) {
            PsiElement ref = ((ObjDExprCall) expr).getCallName().getReference().resolve();
            if(ref instanceof ObjDClassName) {
                return new Object((ObjDClassStatement) ref.getParent());
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
        PsiElement ref = dataType.getDataTypeRef().getReference().resolve();
        if(ref == null) return new Unknown("No reference for data type " + dataType);
        if(ref instanceof ObjDClassName) {
            PsiElement par = ref.getParent();
            if(par instanceof ObjDClassStatement) {
                return new Class((ObjDClassStatement) par);
            } else if(par instanceof ObjDClassGeneric) {
                return new Generic((ObjDClassGeneric) par);
            } else {
                return new Unknown("Unknown class type " + par.getClass());
            }
        } else {
            return new Unknown("Unknown data type class ref " + ref.getClass());
        }
    }

    public abstract IChain<PsiNamedElement> getRefsChain();

    public boolean isDefined() {
        return true;
    }

    public static class Unknown extends ObjDTp {
        private final String error;

        public Unknown(String error) {
            this.error = error;
        }

        @Override
        public IChain<PsiNamedElement> getRefsChain() {
            return chain();
        }

        public boolean isDefined() {
            return false;
        }
    }

    public static class Object extends ObjDTp {

        private final ObjDClassStatement classStatement;

        public Object(ObjDClassStatement classStatement) {
            this.classStatement = classStatement;
        }

        @Override
        public IChain<PsiNamedElement> getRefsChain() {
            return unionChain(
                    chain(classStatement.getClassBody().getDefStatementList()).filter(new B<ObjDDefStatement>() {
                        @Override
                        public Boolean f(ObjDDefStatement x) {
                            return x.isStatic();
                        }
                    }).map(new F<ObjDDefStatement, PsiNamedElement>() {
                        @Override
                        public PsiNamedElement f(ObjDDefStatement x) {
                            return x.getDefName();
                        }
                    }),
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
                    }));
        }
    }

    public static class Class extends ObjDTp {
        private final ObjDClassStatement classStatement;

        public Class(ObjDClassStatement classStatement) {
            this.classStatement = classStatement;
        }

        @Override
        public IChain<PsiNamedElement> getRefsChain() {
            return ObjDUtil.classFields(classStatement);
        }
    }

    public static class Generic extends ObjDTp {
        private final ObjDClassGeneric generic;

        public Generic(ObjDClassGeneric generic) {
            this.generic = generic;
        }

        @Override
        public IChain<PsiNamedElement> getRefsChain() {
            return empty();
        }

        public boolean isDefined() {
            return false;
        }
    }
}
