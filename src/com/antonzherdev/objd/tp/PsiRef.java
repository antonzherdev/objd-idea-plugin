package com.antonzherdev.objd.tp;

import com.antonzherdev.chain.F;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;

public class PsiRef {
    public static final F<PsiNamedElement,PsiRef> APPLY = new F<PsiNamedElement, PsiRef>() {
        @Override
        public PsiRef f(PsiNamedElement x) {
            return new PsiRef(x);
        }
    };
    public static final F<PsiRef,PsiElement> ELEMENT_F = new F<PsiRef, PsiElement>() {
        @Override
        public PsiElement f(PsiRef psiRef) {
            return psiRef.getElement();
        }
    };
    private final String name;
    private final PsiElement element;

    public PsiRef(PsiElement element, String name) {
        this.name = name;
        this.element = element;
    }

    public PsiRef(PsiNamedElement element) {
        this.element = element;
        this.name = element.getName();
    }

    public String getName() {
        return name;
    }

    public PsiElement getElement() {
        return element;
    }
}
