package com.antonzherdev.objd.reference;

import com.antonzherdev.chain.B;
import com.antonzherdev.chain.Chain;
import com.antonzherdev.chain.F;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.*;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import com.intellij.util.ArrayUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.antonzherdev.chain.Chain.chain;

public class DataTypeReference extends PsiReferenceBase<ObjDDataTypeRef> {
    public DataTypeReference(@NotNull ObjDDataTypeRef element, TextRange textRange) {
        super(element, textRange);
    }


    @Nullable
    @Override
    public PsiElement resolve() {
        if(myElement.getProject().isDisposed()) return null;
        return ResolveCache.getInstance(myElement.getProject()).resolveWithCaching(this, new ResolveCache.AbstractResolver<DataTypeReference, PsiElement>() {
            @Override
            public PsiElement resolve(@NotNull DataTypeReference dataTypeReference, boolean b) {
                ObjDFile file = (ObjDFile) getElement().getContainingFile();
                try {
                    final List<ObjDClass> availableClasses = file.getAvailableClasses();
                    return Chain.chain(availableClasses)
                            .map(new F<ObjDClass, ObjDClassName>() {
                                @Override
                                public ObjDClassName f(ObjDClass x) {
                                    return x.getClassName();
                                }
                            })
                            .append(chain(ObjDUtil.getDeclaredGenerics(getElement())).map(new F<ObjDClassGeneric, ObjDClassName>() {
                                @Override
                                public ObjDClassName f(ObjDClassGeneric x) {
                                    return x.getClassName();
                                }
                            }))
                            .find(new B<ObjDClassName>() {
                                @Override
                                public Boolean f(ObjDClassName className) {
                                    return className.getName().equals(getElement().getName());
                                }
                            }).getOrNull();
                } catch (ProcessCanceledException e) {
                    return null;
                }
            }
        }, true, false);
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