package com.antonzherdev.objd.reference;

import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.ObjDImportPart;
import com.antonzherdev.objd.psi.ObjDTypes;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import com.intellij.util.ArrayUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;

public class ObjDImportReference extends PsiReferenceBase<ObjDImportPart> {
    public ObjDImportReference(@NotNull ObjDImportPart element, TextRange textRange) {
        super(element, textRange);
    }


    @Nullable
    @Override
    public PsiElement resolve() {
        return ResolveCache.getInstance(myElement.getProject()).resolveWithCaching(this, new ResolveCache.AbstractResolver<ObjDImportReference, PsiElement>() {
            @Override
            public PsiElement resolve(@NotNull ObjDImportReference objDImportReference, boolean b) {
                return ObjDUtil.findClass(getElement().getProject(), getPackName(), getElement().getName()).getOrNull();
            }
        }, true, false);
    }

    public List<String> getPackName() {
        List<String> ret = new LinkedList<String>();
        ASTNode node = getElement().getNode();
        while(true) {
            node = node.getTreePrev();
            node = node.getTreePrev();
            if((node.getElementType() != ObjDTypes.IMPORT_PART)) break;
            ret.add(0, node.getPsi(ObjDImportPart.class).getName());
        }
        return ret;
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