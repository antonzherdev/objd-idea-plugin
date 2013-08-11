package com.antonzherdev.objd.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class ObjDFormatter implements FormattingModelBuilder {
    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(),
                new ObjDBlock(element.getNode(), Indent.getNoneIndent(), null, null, createSpaceBuilder(settings)), settings);
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile psiFile, int i, ASTNode astNode) {
        return null;
    }

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings);
    }


}