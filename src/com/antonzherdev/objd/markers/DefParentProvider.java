package com.antonzherdev.objd.markers;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.IChain;
import com.antonzherdev.chain.Option;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.*;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.ide.util.DefaultPsiElementCellRenderer;
import com.intellij.openapi.util.NotNullLazyValue;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

import static com.antonzherdev.chain.Chain.chain;

public class DefParentProvider extends RelatedItemLineMarkerProvider {
    final static DefaultPsiElementCellRenderer RENDER = new DefaultPsiElementCellRenderer() {
        @Override
        public String getElementText(PsiElement e) {
            return ObjDUtil.getClass(e).get().getClassName().getName() + "." + ((ObjDDefName) e).getName();
        }
    };

    @Override
    protected void collectNavigationMarkers(@NotNull final PsiElement element, Collection<? super RelatedItemLineMarkerInfo> result) {
        if(element instanceof ObjDDefStatement) {
            if(PsiTreeUtil.findChildOfType(element, ObjDOverrideMod.class) != null) {
                Option<ObjDDefName> d = chain(ObjDUtil.getClass(element).get().getParentReference().resolveClasses()).flatMap(new F<ObjDClass, Option<ObjDDefName>>() {
                    @Override
                    public Option<ObjDDefName> f(ObjDClass x) {
                        if (!(x instanceof ObjDClassStatement)) return Option.none();
                        ObjDClassBody classBody = ((ObjDClassStatement) x).getClassBody();
                        if(classBody == null) return Option.none();
                        return chain(classBody.getDefStatementList())
                                .find(new F<ObjDDefStatement, Boolean>() {
                                    @Override
                                    public Boolean f(ObjDDefStatement s) {
                                        return ObjDUtil.isDeclEquals((ObjDDefStatement) element, s);
                                    }
                                }).map(new F<ObjDDefStatement, ObjDDefName>() {
                                    @Override
                                    public ObjDDefName f(ObjDDefStatement d) {
                                        return d.getDefName();
                                    }
                                });
                    }
                }).first();
                if(d.isDefined()) {
                    NavigationGutterIconBuilder<PsiElement> builder =
                            NavigationGutterIconBuilder.create(AllIcons.Gutter.OverridingMethod).
                                    setTarget(d.get()).
                                    setTooltipText("Overrides method");
                    result.add(builder.createLineMarkerInfo(element));
                }
            }
            if(PsiTreeUtil.findChildOfType(element, ObjDFinalMod.class) == null && PsiTreeUtil.findChildOfType(element, ObjDStaticMod.class) == null) {
                final IChain<ObjDDefName> d = chain(ObjDUtil.getClass(element).get().getChildReference().resolveClasses()).flatMap(new F<ObjDClass, Option<ObjDDefName>>() {
                    @Override
                    public Option<ObjDDefName> f(ObjDClass x) {
                        if (!(x instanceof ObjDClassStatement)) return Option.none();
                        ObjDClassBody cb = ((ObjDClassStatement) x).getClassBody();
                        if(cb == null) return Option.none();
                        return chain(cb.getDefStatementList())
                                .find(new F<ObjDDefStatement, Boolean>() {
                                    @Override
                                    public Boolean f(ObjDDefStatement s) {
                                        return ObjDUtil.isDeclEquals((ObjDDefStatement) element, s);
                                    }
                                }).map(new F<ObjDDefStatement, ObjDDefName>() {
                                    @Override
                                    public ObjDDefName f(ObjDDefStatement d) {
                                        return d.getDefName();
                                    }
                                });
                    }
                });
                if(!d.isEmpty()) {

                    NavigationGutterIconBuilder<PsiElement> builder =
                            NavigationGutterIconBuilder.create(AllIcons.Gutter.OverridenMethod).
                                    setTargets(new NotNullLazyValue<Collection<? extends PsiElement>>() {
                                        @NotNull
                                        @Override
                                        protected Collection<? extends PsiElement> compute() {
                                            return d.list();
                                        }
                                    }).setCellRenderer(RENDER). setTooltipText("Overrides method");
                    result.add(builder.createLineMarkerInfo(element));
                }
            }
        }
    }
}
