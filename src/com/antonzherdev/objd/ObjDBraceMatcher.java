package com.antonzherdev.objd;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.antonzherdev.objd.psi.ObjDTypes.*;

public class ObjDBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = {
            new BracePair(OPEN_BRACE, CLOSE_BRACE, false),
            new BracePair(OPEN_BRACKET, CLOSE_BRACKET, false),
            new BracePair(OPEN_SQUARE_BRACKET, CLOSE_SQUARE_BRACKET, false),
    };

    public BracePair[] getPairs() {
        return PAIRS;
    }

    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType braceType, @Nullable IElementType tokenType) {
        return true;
    }

    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}