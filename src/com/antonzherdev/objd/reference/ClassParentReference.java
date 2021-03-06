package com.antonzherdev.objd.reference;


import com.antonzherdev.chain.F;
import com.antonzherdev.chain.Option;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.ObjDClass;
import com.antonzherdev.objd.psi.ObjDClassExtends;
import com.antonzherdev.objd.psi.ObjDClassName;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import static com.antonzherdev.chain.Chain.chain;

public class ClassParentReference extends PsiReferenceBase<ObjDClass> {
    private ObjDClass cls;

    public ClassParentReference(@NotNull ObjDClass element) {
        super(element);
        cls = element;
    }

    public List<ObjDClass> resolveClasses() {
        if(myElement.getProject().isDisposed()) return null;
        return ResolveCache.getInstance(myElement.getProject()).resolveWithCaching(this, new ResolveCache.AbstractResolver<ClassParentReference, List<ObjDClass>>() {
            @Override
            public List<ObjDClass> resolve(@NotNull ClassParentReference classParentReference, boolean b) {
                return chain(cls).recursive(new F<ObjDClass, Iterable<ObjDClass>>() {
                    @Override
                    public Iterable<ObjDClass> f(ObjDClass objDClass) {
                        List<ObjDClassExtends> exts = objDClass.getClassExtendsList();
                        if(exts == null || exts.isEmpty()) {
                            final ObjDClassName className = objDClass.getClassName();
                            final String name = className == null ? "" : className.getName();
                            if(name != null && objDClass.getName().equals("Object")) return Arrays.asList();
                            else return Arrays.asList(ObjDUtil.getBaseObject(objDClass.getProject()));
                        }
                        return chain(exts).flatMap(new F<ObjDClassExtends, Option<ObjDClass>>() {
                            @Override
                            public Option<ObjDClass> f(ObjDClassExtends objDClassExtends) {
                                ObjDClassName clsName = (ObjDClassName) objDClassExtends.getDataTypeRef().getReference().resolve();
                                return clsName == null ? Option.<ObjDClass>none() : Option.<ObjDClass>some((ObjDClass) clsName.getParent());

                            }
                        });
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
