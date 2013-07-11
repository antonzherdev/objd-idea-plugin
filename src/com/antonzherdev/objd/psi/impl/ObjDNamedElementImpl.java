package com.antonzherdev.objd.psi.impl;

import com.antonzherdev.objd.psi.ObjDNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class ObjDNamedElementImpl extends ASTWrapperPsiElement implements ObjDNamedElement {
    public ObjDNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}