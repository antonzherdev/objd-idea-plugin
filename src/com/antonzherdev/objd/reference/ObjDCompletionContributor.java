package com.antonzherdev.objd.reference;

import com.antonzherdev.chain.P;
import com.antonzherdev.objd.ObjDLanguage;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.*;
import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static com.intellij.codeInsight.lookup.LookupElementBuilder.create;

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
                                    resultSet.addElement(create(name.substring(0, name.length() - 3)));
                                }
                            });
                        } else if(parent instanceof ObjDDataTypeRef) {
                            ObjDUtil.availableClassesInFile(parent.getContainingFile()).foreach(new P<ObjDClassName>() {
                                @Override
                                public void p(ObjDClassName className) {
                                    resultSet.addElement(create(className.getName()));
                                }
                            });
                        } else if(parent.getParent() instanceof ObjDFile) {
                            resultSet.addElement(create("import "));
                            resultSet.addElement(create("val "));
                            resultSet.addElement(create("stub "));
                            resultSet.addElement(create("class "));
                            resultSet.addElement(create("struct "));
                            resultSet.addElement(create("enum "));
                            resultSet.addElement(create("trait "));
                        } else if(parent instanceof ObjDDefStatement || parent instanceof ObjDCallName) {
                            if(!ObjDUtil.isAfterDot(parent)) {
                                resultSet.addElement(create("val "));
                                resultSet.addElement(create("var "));
                                resultSet.addElement(create("if"));
                                resultSet.addElement(create("else "));
                                resultSet.addElement(create("throw "));
                                resultSet.addElement(create("true"));
                                resultSet.addElement(create("false"));
                                resultSet.addElement(create("self"));
                            }
                            CallReference.getRefsChain(parent).foreach(new P<PsiNamedElement>() {
                                @Override
                                public void p(PsiNamedElement x) {
                                    resultSet.addElement(create(x.getName()));
                                }
                            });
                        } else if(parent instanceof ObjDClassBody || parent.getParent() instanceof ObjDClassBody) {
                            resultSet.addElement(create("val "));
                            resultSet.addElement(create("var "));
                            resultSet.addElement(create("private "));
                            resultSet.addElement(create("def "));
                            resultSet.addElement(create("static "));
                            resultSet.addElement(create("weak "));
                        } else if(parent instanceof ObjDDefName && (parent.getParent().getPrevSibling() instanceof ObjDClassStatement
                                || (parent.getParent().getPrevSibling() != null && parent.getParent().getPrevSibling().getPrevSibling() instanceof ObjDClassStatement) ))
                        {
                            resultSet.addElement(create("extends "));
                        }
                    }
                }
        );
    }
}
