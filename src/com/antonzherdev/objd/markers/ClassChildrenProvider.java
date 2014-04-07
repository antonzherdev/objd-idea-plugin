package com.antonzherdev.objd.markers;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.IChain;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.*;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.NotNullLazyValue;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

import static com.antonzherdev.chain.Chain.chain;

public class ClassChildrenProvider extends RelatedItemLineMarkerProvider {
    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element, Collection<? super RelatedItemLineMarkerInfo> result) {
        if(element instanceof ObjDClassStatement) {
            final IChain<ObjDClassName> chain = chain(((ObjDClass) element).getChildReference().resolveClasses()).map(new F<ObjDClass, ObjDClassName>() {
                @Override
                public ObjDClassName f(ObjDClass objDClass) {
                    return objDClass.getClassName();
                }
            });
            if(!chain.isEmpty()) {
                NavigationGutterIconBuilder<PsiElement> builder =
                        NavigationGutterIconBuilder.create(AllIcons.Gutter.ImplementedMethod).
                                setTargets(new NotNullLazyValue<Collection<? extends PsiElement>>() {
                                    @NotNull
                                    @Override
                                    protected Collection<? extends PsiElement> compute() {
                                        return chain.list();
                                    }
                                }).setTooltipText("Is subclassed by");
                result.add(builder.createLineMarkerInfo(element));
            }
        }
    }

}
