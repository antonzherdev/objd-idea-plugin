package com.antonzherdev.objd.reference;

import com.antonzherdev.chain.P;
import com.antonzherdev.objd.ObjDLanguage;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.ObjDFile;
import com.antonzherdev.objd.psi.ObjDImportOdFile;
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
                                               @NotNull final CompletionResultSet resultSet) {
                        PsiElement parent = parameters.getPosition().getParent();
                        if(parent instanceof ObjDImportOdFile) {
                            ObjDUtil.getAllFiles(parent.getProject()).foreach(new P<ObjDFile>() {
                                @Override
                                public void p(ObjDFile objDFile) {
                                    resultSet.addElement(LookupElementBuilder.create(objDFile.getName().substring(0, objDFile.getName().length() - 3)));
                                }
                            });
                        }
                    }
                }
        );
    }
}
