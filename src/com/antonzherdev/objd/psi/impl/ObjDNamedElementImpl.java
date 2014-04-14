package com.antonzherdev.objd.psi.impl;

import com.antonzherdev.objd.psi.ObjDNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;

public abstract class ObjDNamedElementImpl extends ASTWrapperPsiElement implements ObjDNamedElement {
    private final PsiReference reference;

    public ObjDNamedElementImpl(@NotNull ASTNode node) {
        super(node);
        reference = ObjDPsiImplUtil.createReference(this);
    }


    @Override
    public PsiReference getReference() {
        return reference;
    }
}