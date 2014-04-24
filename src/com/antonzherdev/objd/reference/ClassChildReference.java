package com.antonzherdev.objd.reference;


import com.antonzherdev.chain.F;
import com.antonzherdev.objd.psi.ObjDClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.antonzherdev.chain.Chain.chain;
import static com.antonzherdev.objd.ObjDUtil.getAllClasses;

public class ClassChildReference extends PsiReferenceBase<ObjDClass> {
    private ObjDClass cls;

    public ClassChildReference(@NotNull ObjDClass element) {
        super(element);
        cls = element;
    }

    public List<ObjDClass> resolveClasses() {
        if(myElement.getProject().isDisposed()) return null;
        return ResolveCache.getInstance(myElement.getProject()).resolveWithCaching(this, new ResolveCache.AbstractResolver<ClassChildReference, List<ObjDClass>>() {
            @Override
            public List<ObjDClass> resolve(@NotNull ClassChildReference classParentReference, boolean b) {
                return getAllClasses(cls.getProject())
                        .filter(new F<ObjDClass, Boolean>() {
                            @Override
                            public Boolean f(ObjDClass objDClass) {
                                return chain(objDClass.getParentReference().resolveClasses())
                                        .find(new F<ObjDClass, Boolean>() {
                                            @Override
                                            public Boolean f(ObjDClass x) {
                                                return x == cls;
                                            }
                                        }).isDefined();
                            }
                        }).list();
            }
        }, true, false);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        List<ObjDClass> resolveResults = resolveClasses();
        return resolveResults.size() == 1 ? resolveResults.get(0) : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return ArrayUtil.EMPTY_OBJECT_ARRAY;
    }
}
