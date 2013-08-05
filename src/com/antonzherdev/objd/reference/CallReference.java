package com.antonzherdev.objd.reference;

import com.antonzherdev.chain.B;
import com.antonzherdev.chain.Chain;
import com.antonzherdev.chain.F;
import com.antonzherdev.chain.IChain;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.*;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.util.ArrayUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.antonzherdev.chain.Chain.chain;

public class CallReference extends PsiReferenceBase<ObjDCallName> {
    public CallReference(@NotNull ObjDCallName element, TextRange textRange) {
        super(element, textRange);
    }


    @Nullable
    @Override
    public PsiElement resolve() {
        return getRefsChain(getElement())
                .find(new B<PsiNamedElement>() {
                    @Override
                    public Boolean f(PsiNamedElement className) {
                        return className.getName().equals(getElement().getName());
                    }
                }).getOrNull();
    }

    public static IChain<PsiNamedElement> getRefsChain(PsiElement element) {
        if(isAfterDot(element)) {
            return chain();
        }
        return ObjDUtil.availableClassesInFile(element.getContainingFile())
                .<PsiNamedElement>cast()
                .append(ObjDUtil.getClass(element).map(new F<ObjDClassStatement,IChain<PsiNamedElement>>() {
                    @Override
                    public IChain<PsiNamedElement> f(ObjDClassStatement x) {
                        return classFields(x);
                    }
                }).getOrElse(Chain.<PsiNamedElement>chain()))
                .append(vars(element));
    }

    public static boolean isAfterDot(PsiElement element) {
        if(element.getParent().getParent() instanceof ObjDExprDot) {
            ObjDExprDot dot = (ObjDExprDot) element.getParent().getParent();
            return dot.getRight() == element.getParent();
        }
        return false;
    }

    private static List<PsiNamedElement> vars(PsiElement element) {
        ArrayList<PsiNamedElement> items = new ArrayList<PsiNamedElement>();
        vars(items, element);
        return items;
    }

    private static void vars(ArrayList<PsiNamedElement> items, PsiElement element) {
        if(element instanceof ObjDExprVal) {
            ObjDExprVal v = (ObjDExprVal) element;
            if(v != null) items.add(v.getDefName());
        } else if(element instanceof ObjDDefStatement) {
            chain(((ObjDDefStatement) element).getDefParameterList()).map(new F<ObjDDefParameter,ObjDDefName>() {
                @Override
                public ObjDDefName f(ObjDDefParameter x) {
                    return x.getDefName();
                }
            }).addAllTo(items);
            return;
        } else if(element instanceof ObjDExprLambda) {
            chain(((ObjDExprLambda) element).getLambdaParList()).map(new F<ObjDLambdaPar,ObjDDefName>() {
                @Override
                public ObjDDefName f(ObjDLambdaPar x) {
                    return x.getDefName();
                }
            }).addAllTo(items);
            return;
        }
        else if(element instanceof ObjDFieldStatement) return;

        PsiElement p = element.getPrevSibling();
        if(p != null) {
            vars(items, p);
        } else {
            p = element.getParent();
            if(p != null) vars(items, p);
        }
    }

    private static IChain<PsiNamedElement> classFields(ObjDClassStatement stm) {
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


    @NotNull
    @Override
    public Object[] getVariants() {
        return ArrayUtil.EMPTY_OBJECT_ARRAY;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public PsiElement handleElementRename(String newName) throws IncorrectOperationException {
        getElement().setName(newName);
        return getElement();
    }
}