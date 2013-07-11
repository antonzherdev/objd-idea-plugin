package com.antonzherdev.objd;

import com.antonzherdev.objd.psi.ObjDImportOdFile;
import com.antonzherdev.objd.psi.ObjDTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ObjDCompletionContributor extends CompletionContributor {
    public ObjDCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(ObjDLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement parent = parameters.getPosition().getParent();
                        if(parent instanceof ObjDImportOdFile) {
                            resultSet.addElement(LookupElementBuilder.create("Hello"));
                        }
                    }
                }
        );
    }
}
