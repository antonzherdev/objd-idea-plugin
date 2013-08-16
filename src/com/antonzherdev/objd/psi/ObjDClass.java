package com.antonzherdev.objd.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ObjDClass extends PsiElement {
    @Nullable
    ObjDClassGenerics getClassGenerics();

    @NotNull
    ObjDClassName getClassName();

    @Nullable
    ObjDClassExtends getClassExtends();
}
