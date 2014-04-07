package com.antonzherdev.objd.psi.impl;


import com.antonzherdev.objd.psi.ObjDClass;
import com.antonzherdev.objd.reference.ClassChildReference;
import com.antonzherdev.objd.reference.ClassParentReference;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class ObjDClassImpl extends ASTWrapperPsiElement implements ObjDClass {
    private final ClassChildReference childReference;
    private final ClassParentReference parentReference;

    public ObjDClassImpl(@NotNull ASTNode node) {
        super(node);
        childReference = new ClassChildReference(this);
        parentReference = new ClassParentReference(this);
    }


    @Override
    public ClassChildReference getChildReference() {
        return childReference;
    }

    @Override
    public ClassParentReference getParentReference() {
        return parentReference;
    }
}
