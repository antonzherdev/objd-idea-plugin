package com.antonzherdev.objd.reference;

import com.antonzherdev.chain.B;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.*;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.util.ArrayUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.antonzherdev.chain.Chain.chain;

public class DataTypeReference extends PsiReferenceBase<ObjDDataTypeRef> {
    public DataTypeReference(@NotNull ObjDDataTypeRef element, TextRange textRange) {
        super(element, textRange);
    }


    @Nullable
    @Override
    public PsiElement resolve() {
        ObjDFile file = (ObjDFile) getElement().getContainingFile();
        return ObjDUtil.availableClassesInFile(file)
                .find(new B<ObjDClassName>() {
                    @Override
                    public Boolean f(ObjDClassName className) {
                        return className.getName().equals(getElement().getName());
                    }
                }).getOrNull();
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