package com.antonzherdev.objd;

import com.antonzherdev.objd.tp.ObjDTp;
import com.intellij.psi.PsiElement;

public interface Dot {
    Left getLeft();
    PsiElement getRight();

    public interface Left {
        ObjDTp getTp();
    }
}
