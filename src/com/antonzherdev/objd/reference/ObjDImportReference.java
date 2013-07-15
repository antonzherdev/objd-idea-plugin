package com.antonzherdev.objd.reference;

import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.ObjDElementFactory;
import com.antonzherdev.objd.psi.ObjDFile;
import com.antonzherdev.objd.psi.ObjDImportOdFile;
import com.antonzherdev.objd.psi.ObjDImportStatement;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.util.ArrayUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ObjDImportReference extends PsiReferenceBase<ObjDImportOdFile> {
    public ObjDImportReference(@NotNull ObjDImportOdFile element, TextRange textRange) {
        super(element, textRange);
    }


    @Nullable
    @Override
    public PsiElement resolve() {
        return ObjDUtil.findFile(getElement().getProject(), getElement().getName()).getOrNull();
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