package com.antonzherdev.objd.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ObjDClass extends PsiElement {
    @Nullable
    ObjDClassGenerics getClassGenerics();

    @NotNull
    ObjDClassName getClassName();

    @Nullable
    List<ObjDClassExtends> getClassExtendsList();
}
