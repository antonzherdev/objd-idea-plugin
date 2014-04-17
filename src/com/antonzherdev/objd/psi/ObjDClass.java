package com.antonzherdev.objd.psi;

import com.antonzherdev.objd.reference.ClassChildReference;
import com.antonzherdev.objd.reference.ClassParentReference;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
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

    ClassChildReference getChildReference();

    ClassParentReference getParentReference();

    String getName();
}
