package com.antonzherdev.objd.reference;

import com.antonzherdev.chain.P;
import com.antonzherdev.objd.ObjDLanguage;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.*;
import com.antonzherdev.objd.tp.PsiRef;
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
                        PsiElement element = parameters.getPosition().getNavigationElement();
                        if(parent instanceof ObjDFile && (element.getPrevSibling() instanceof ObjDClassStatement
                                || (element.getPrevSibling() != null && element.getPrevSibling().getPrevSibling() instanceof ObjDClassStatement) ))
                        {
                            resultSet.addElement(create("extends "));
                        } else if(parent instanceof ObjDDataTypeRef) {
                            ObjDUtil.availableClassesInFile((ObjDFile) parent.getContainingFile()).foreach(new P<ObjDClass>() {
                                @Override
                                public void p(ObjDClass className) {
                                    resultSet.addElement(create(className.getClassName().getName()));
                                }
                            });
                            resultSet.addElement(create("byte"));
                            resultSet.addElement(create("ubyte"));
                            resultSet.addElement(create("float"));
                            resultSet.addElement(create("float4"));
                            resultSet.addElement(create("float8"));
                            resultSet.addElement(create("int"));
                            resultSet.addElement(create("int4"));
                            resultSet.addElement(create("int8"));
                            resultSet.addElement(create("uint"));
                            resultSet.addElement(create("uint4"));
                            resultSet.addElement(create("uint8"));
                            resultSet.addElement(create("bool"));
                        } else if(parent instanceof ObjDFile) {
                            resultSet.addElement(create("import "));
                            resultSet.addElement(create("export "));
                            resultSet.addElement(create("val "));
                            resultSet.addElement(create("stub "));
                            resultSet.addElement(create("abstract "));
                            resultSet.addElement(create("final "));
                            resultSet.addElement(create("class "));
                            resultSet.addElement(create("struct "));
                            resultSet.addElement(create("enum "));
                            resultSet.addElement(create("trait "));
                        } else if(parent instanceof ObjDDefStatement || parent instanceof ObjDCallName) {
                            if(!ObjDUtil.isAfterDot(parent)) {
                                resultSet.addElement(create("val "));
                                resultSet.addElement(create("var "));
                                resultSet.addElement(create("if"));
                                resultSet.addElement(create("while"));
                                resultSet.addElement(create("synchronized"));
                                resultSet.addElement(create("else "));
                                resultSet.addElement(create("throw "));
                                resultSet.addElement(create("true"));
                                resultSet.addElement(create("false"));
                                resultSet.addElement(create("self"));
                                resultSet.addElement(create("super"));
                            }
                            CallReference.getRefsChain(parent).foreach(new P<PsiRef>() {
                                @Override
                                public void p(PsiRef x) {
                                    resultSet.addElement(create(x.getName()));
                                }
                            });
                        } else if(parent.getParent() instanceof ObjDEnumItem
                                || (parent instanceof ObjDDefName && parent.getParent() instanceof ObjDFieldStatement)
                        ) {
                            resultSet.addElement(create("val "));
                            resultSet.addElement(create("var "));
                            resultSet.addElement(create("private "));
                            resultSet.addElement(create("protected "));
                            resultSet.addElement(create("def "));
                            resultSet.addElement(create("static "));
                            resultSet.addElement(create("weak "));
                            resultSet.addElement(create("lazy "));
                        }
                    }
                }
        );
    }
}
