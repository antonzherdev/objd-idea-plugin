package com.antonzherdev.objd.reference;

import com.antonzherdev.objd.psi.*;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class ObjDReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(psiElement(ObjDImportPart.class), new PsiReferenceProvider() {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext processingContext) {
                return new PsiReference[]{new ObjDImportReference((ObjDImportPart)element, TextRange.from(0, element.getTextLength()))};
            }
        });
        registrar.registerReferenceProvider(psiElement(ObjDDataTypeRef.class), new PsiReferenceProvider() {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext processingContext) {
                return new PsiReference[]{new DataTypeReference((ObjDDataTypeRef)element, TextRange.from(0, element.getTextLength()))};
            }
        });
        registrar.registerReferenceProvider(psiElement(ObjDCallName.class), new PsiReferenceProvider() {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext processingContext) {
                return new PsiReference[]{new CallReference((ObjDNamedElement)element, TextRange.from(0, element.getTextLength()))};
            }
        });
    }
}
