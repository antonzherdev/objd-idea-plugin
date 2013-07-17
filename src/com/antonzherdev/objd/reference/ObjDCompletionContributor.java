package com.antonzherdev.objd.reference;

import com.antonzherdev.chain.P;
import com.antonzherdev.objd.ObjDLanguage;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.*;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
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
                                    String name = objDFile.getName();
                                    resultSet.addElement(LookupElementBuilder.create(name.substring(0, name.length() - 3)));
                                }
                            });
                        } else if(parent instanceof ObjDDataTypeRef) {
                            ObjDUtil.availableClassesInFile(parent.getContainingFile()).foreach(new P<ObjDClassName>() {
                                @Override
                                public void p(ObjDClassName className) {
                                    resultSet.addElement(LookupElementBuilder.create(className.getName()));
                                }
                            });
                        } else if(parent.getParent() instanceof ObjDFile) {
                            resultSet.addElement(LookupElementBuilder.create("import "));
                            resultSet.addElement(LookupElementBuilder.create("val "));
                            resultSet.addElement(LookupElementBuilder.create("stub "));
                            resultSet.addElement(LookupElementBuilder.create("class "));
                            resultSet.addElement(LookupElementBuilder.create("struct "));
                            resultSet.addElement(LookupElementBuilder.create("enum "));
                            resultSet.addElement(LookupElementBuilder.create("trait "));
                        } else if(parent instanceof ObjDDefStatement || parent instanceof ObjDCallName) {
                            if(!CallReference.isAfterDot(parameters.getPosition())) {
                                resultSet.addElement(LookupElementBuilder.create("val "));
                                resultSet.addElement(LookupElementBuilder.create("var "));
                                resultSet.addElement(LookupElementBuilder.create("if"));
                                resultSet.addElement(LookupElementBuilder.create("else "));
                                resultSet.addElement(LookupElementBuilder.create("throw "));
                                resultSet.addElement(LookupElementBuilder.create("true"));
                                resultSet.addElement(LookupElementBuilder.create("false"));
                                resultSet.addElement(LookupElementBuilder.create("self"));
                                CallReference.getRefsChain(parameters.getPosition()).foreach(new P<PsiNamedElement>() {
                                    @Override
                                    public void p(PsiNamedElement x) {
                                        resultSet.addElement(LookupElementBuilder.create(x.getName()));
                                    }
                                });
                            }
                        } else if(parent instanceof ObjDClassBody || parent.getParent() instanceof ObjDClassBody) {
                            resultSet.addElement(LookupElementBuilder.create("val "));
                            resultSet.addElement(LookupElementBuilder.create("var "));
                            resultSet.addElement(LookupElementBuilder.create("private "));
                            resultSet.addElement(LookupElementBuilder.create("def "));
                            resultSet.addElement(LookupElementBuilder.create("static "));
                            resultSet.addElement(LookupElementBuilder.create("weak "));
                        }
                    }
                }
        );
    }
}
