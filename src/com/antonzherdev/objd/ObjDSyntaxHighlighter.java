package com.antonzherdev.objd;

import com.antonzherdev.objd.psi.ObjDTypes;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.Reader;
import java.util.*;
import java.util.List;

import static com.antonzherdev.objd.psi.ObjDTypes.*;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class ObjDSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("OBJD_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey DATATYPE = createTextAttributesKey("OBJD_DATATYPE", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("OBJD_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey STRING = createTextAttributesKey("OBJD_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey OPERATION = createTextAttributesKey("OBJD_OPERATION", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey BRACE = createTextAttributesKey("OBJD_BRACE", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("OBJD_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey ADOT = createTextAttributesKey("OBJD_DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey METADATA = createTextAttributesKey("OBJD_METADATA", DefaultLanguageHighlighterColors.METADATA);

    static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("OBJD_BAD_CHARACTER",
            new TextAttributes(JBColor.RED, null, null, null, Font.BOLD));

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] DATATYPE_KEYS = new TextAttributesKey[]{DATATYPE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] OPERATION_KEYS = new TextAttributesKey[]{OPERATION};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[]{BRACE};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] DOT_KEYS = new TextAttributesKey[]{ADOT};
    private static final TextAttributesKey[] METADATA_KEYS = new TextAttributesKey[]{METADATA};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private static final List<IElementType> KEYWORDS = Arrays.asList(
            W_CLASS, W_IMPORT, W_VAL, W_VAR, W_DEF, W_EXTENDS, W_IF, W_ELSE, W_SELF, W_WEAK,
            W_PRIVATE, W_STATIC, W_NIL, W_TRUE, W_FALSE, W_STUB, W_TRAIT, W_ENUM, W_STRUCT, W_THROW,
            W_WHILE, W_DO, W_RETURN, W_BREAK, W_PACKAGE, W_TYPE, W_WITH, W_CASE, W_LAZY, W_PROTECTED, W_OBJECT,
            W_PURE, W_ENDIF, W_WHEN, W_SYNC, W_SUPER, W_FINAL, W_ABSTRACT, W_TRY, W_FINALLY, W_OVERRIDE, W_INLINE, W_VOLATILE);
    private static final List<IElementType> DATATYPES = Arrays.asList(
            TP_BOOL, TP_FLOAT, TP_INT, TP_STRING, TP_UINT, TP_VOID, TP_BYTE, TP_UBYTE,
            TP_INT4, TP_UINT4, TP_INT8, TP_UINT8, TP_FLOAT4, TP_FLOAT8, TP_ANY, TP_CHAR);
    private static final List<IElementType> OPERATIONS = Arrays.asList(
            SET, PLUS, MINUS, MUL, DIV, AND, OR, EQ, MORE, LESS, MOREEQ, LESSEQ, PLUS_PLUS, MINUS_MINUS, NOT_EQ,
            EXCLAMATION, CLONE, CLUE, EXACT_EQ, EXACT_NOT_EQ);
    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new ObjDLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS;
        } else if (DATATYPES.contains(tokenType)) {
            return DATATYPE_KEYS;
        } else if (OPERATIONS.contains(tokenType)) {
            return OPERATION_KEYS;
        } else if (tokenType.equals(ObjDTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(ObjDTypes.OPEN_BRACE) || tokenType.equals(ObjDTypes.CLOSE_BRACE)) {
            return BRACE_KEYS;
        } else if (tokenType.equals(ObjDTypes.STRING)) {
            return STRING_KEYS;
        } else if (tokenType.equals(ObjDTypes.INT) || tokenType.equals(ObjDTypes.FLOAT)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else if (tokenType.equals(ObjDTypes.DOT) || tokenType.equals(ObjDTypes.NULLDOT) ) {
            return DOT_KEYS;
        } else if (tokenType.equals(ObjDTypes.AT)) {
            return METADATA_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}