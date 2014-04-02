package com.antonzherdev.objd;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.antonzherdev.objd.psi.ObjDTypes;
import com.intellij.psi.TokenType;
import java.util.Stack;

%%

%class ObjDLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
    FlexState state = new FlexState(YYINITIAL);
    Stack<FlexState> states = new Stack<FlexState>();
    void zzbegin(int state) {
        states.push(this.state);
        this.state = new FlexState(state);
        yybegin(state);
    }

    void zzpop() {
        this.state = states.pop();
        yybegin(this.state.getState());
    }
%}

WHITE_SPACE=[\ \t\f\r\n]
END_OF_LINE_COMMENT="//"[^\r\n]*
MULTI_LINE_COMMENT="/*"[^\00]*"*/"
IDENT_CHAR= [a-zA-Z0-9_]
INT_CONST = -?[0-9]+
FLOAT_CONST = -?[0-9]+[.][0-9]+
%state COMMENT_STATE
%state STRING_STATE
%state STRING_EXPR_STATE
%state STRING_EXPR_BRACKET_WAIT_STATE

%%

<YYINITIAL> {
    {END_OF_LINE_COMMENT} {return ObjDTypes.COMMENT; }
    "/*" { zzbegin(COMMENT_STATE); return ObjDTypes.COMMENT; }
}

<COMMENT_STATE> {
    "*/" {zzpop(); return ObjDTypes.COMMENT;}
    [^\ \t\f\r\n*] {return ObjDTypes.COMMENT; }
    .  {return ObjDTypes.COMMENT; }
}

<STRING_STATE> {
    "\\\\" {return ObjDTypes.STRING;}
    [\\]. {return ObjDTypes.STRING;}
    "\"" {zzpop(); return ObjDTypes.STRING;}
    [$] {zzbegin(STRING_EXPR_STATE); return ObjDTypes.STRING_EXPR;}
    [^\ \t\f\r\n\"$\\]+ {return ObjDTypes.STRING; }
    .  {return ObjDTypes.STRING; }
}

<STRING_EXPR_STATE> {
    "(" {zzbegin(STRING_EXPR_BRACKET_WAIT_STATE); state.stringBracketCounter++; return ObjDTypes.OPEN_BRACKET;}
    "if" {return ObjDTypes.W_IF;}
    "else" {zzpop(); return ObjDTypes.W_ELSE;}
    "endif" {zzpop(); return ObjDTypes.W_ENDIF;}
    "when" {return ObjDTypes.W_WHEN;}
    {IDENT_CHAR}+ {
        if(state.stringIdent) {
            zzpop();
            return ObjDTypes.STRING;
        }
        state.stringIdent = true;
        return ObjDTypes.IDENT;}
    "\"" {zzpop(); zzpop(); return ObjDTypes.STRING;}
    [$] {zzpop(); zzbegin(STRING_EXPR_STATE); return ObjDTypes.STRING_EXPR;}
    . {zzpop(); return ObjDTypes.STRING;}
}

<STRING_EXPR_BRACKET_WAIT_STATE> {
    "(" {state.stringBracketCounter++; return ObjDTypes.OPEN_BRACKET;}
    ")" {state.stringBracketCounter--;
        if(state.stringBracketCounter <= 0) {
            zzpop();
            zzpop();
        }return ObjDTypes.CLOSE_BRACKET;}
}


<YYINITIAL, STRING_EXPR_STATE, STRING_EXPR_BRACKET_WAIT_STATE> {
"\"" { zzbegin(STRING_STATE); return ObjDTypes.STRING;}

{FLOAT_CONST} {return ObjDTypes.FLOAT;}
{INT_CONST} {return ObjDTypes.INT;}

"package" {return ObjDTypes.W_PACKAGE; }
"class" {return ObjDTypes.W_CLASS; }
"import" {return ObjDTypes.W_IMPORT; }
"var" {return ObjDTypes.W_VAR; }
"val" {return ObjDTypes.W_VAL; }
"def" {return ObjDTypes.W_DEF; }
"extends" {return ObjDTypes.W_EXTENDS; }
"private" {return ObjDTypes.W_PRIVATE; }
"protected" {return ObjDTypes.W_PROTECTED; }
"static" {return ObjDTypes.W_STATIC; }
"nil" {return ObjDTypes.W_NIL; }
"true" {return ObjDTypes.W_TRUE; }
"false" {return ObjDTypes.W_FALSE; }
"if" {return ObjDTypes.W_IF; }
"else" {return ObjDTypes.W_ELSE; }
"stub" {return ObjDTypes.W_STUB; }
"final" {return ObjDTypes.W_FINAL; }
"abstract" {return ObjDTypes.W_ABSTRACT; }
"trait" {return ObjDTypes.W_TRAIT; }
"struct" {return ObjDTypes.W_STRUCT; }
"enum" {return ObjDTypes.W_ENUM; }
"weak" {return ObjDTypes.W_WEAK; }
"self" {return ObjDTypes.W_SELF; }
"super" {return ObjDTypes.W_SUPER; }
"throw" {return ObjDTypes.W_THROW; }
"while" {return ObjDTypes.W_WHILE; }
"synchronized" {return ObjDTypes.W_SYNC; }
"do" {return ObjDTypes.W_DO; }
"break" {return ObjDTypes.W_BREAK; }
"return" {return ObjDTypes.W_RETURN; }
"typedef" {return ObjDTypes.W_TYPE; }
"with" {return ObjDTypes.W_WITH; }
"case" {return ObjDTypes.W_CASE; }
"lazy" {return ObjDTypes.W_LAZY; }
"pure" {return ObjDTypes.W_PURE; }
"object" {return ObjDTypes.W_OBJECT; }
"try" {return ObjDTypes.W_TRY; }
"finally" {return ObjDTypes.W_FINALLY; }

"bool" {return ObjDTypes.TP_BOOL; }
"float" {return ObjDTypes.TP_FLOAT; }
"float4" {return ObjDTypes.TP_FLOAT4; }
"float8" {return ObjDTypes.TP_FLOAT8; }
"string" {return ObjDTypes.TP_STRING; }
"byte" {return ObjDTypes.TP_BYTE; }
"int" {return ObjDTypes.TP_INT; }
"int4" {return ObjDTypes.TP_INT4; }
"int8" {return ObjDTypes.TP_INT8; }
"ubyte" {return ObjDTypes.TP_UBYTE; }
"uint" {return ObjDTypes.TP_UINT; }
"uint4" {return ObjDTypes.TP_UINT4; }
"uint8" {return ObjDTypes.TP_UINT8; }
"void" {return ObjDTypes.TP_VOID; }
"any" {return ObjDTypes.TP_ANY; }
"char" {return ObjDTypes.TP_CHAR; }

{IDENT_CHAR}+ {return ObjDTypes.IDENT; }

"**" {return ObjDTypes.CLUE;}
"*|*" {return ObjDTypes.CLONE;}
"->" {return ObjDTypes.ARROW;}
"{" {return ObjDTypes.OPEN_BRACE;}
"}" {return ObjDTypes.CLOSE_BRACE;}
"[" {return ObjDTypes.OPEN_SQUARE_BRACKET;}
"]" {return ObjDTypes.CLOSE_SQUARE_BRACKET;}
"(" {return ObjDTypes.OPEN_BRACKET;}
")" {return ObjDTypes.CLOSE_BRACKET;}
"," {return ObjDTypes.COMMA;}
":" {return ObjDTypes.COLON;}
"<=" {return ObjDTypes.LESSEQ;}
"<" {return ObjDTypes.LESS;}
">" {return ObjDTypes.MORE;}
">=" {return ObjDTypes.MOREEQ;}
"===" {return ObjDTypes.EXACT_EQ;}
"==" {return ObjDTypes.EQ;}
"=" {return ObjDTypes.SET;}
"||" {return ObjDTypes.OR;}
"&&" {return ObjDTypes.AND;}
"?." {return ObjDTypes.NULLDOT;}
"." {return ObjDTypes.DOT;}
"++" {return ObjDTypes.PLUS_PLUS;}
"+=" {return ObjDTypes.PLUS_SET;}
"+" {return ObjDTypes.PLUS;}
"--" {return ObjDTypes.MINUS_MINUS;}
"-=" {return ObjDTypes.MINUS_SET;}
"-" {return ObjDTypes.MINUS;}
"*=" {return ObjDTypes.MUL_SET;}
"*" {return ObjDTypes.MUL;}
"/=" {return ObjDTypes.DIV_SET;}
"/" {return ObjDTypes.DIV;}
"?!" {return ObjDTypes.UNSAFE;}
"?:" {return ObjDTypes.ELVIS;}
"?>" {return ObjDTypes.NULLMAP;}
"?" {return ObjDTypes.WHAT;}
"!==" {return ObjDTypes.EXACT_NOT_EQ;}
"!=" {return ObjDTypes.NOT_EQ;}
"!" {return ObjDTypes.EXCLAMATION;}
}

{WHITE_SPACE}+ {return TokenType.WHITE_SPACE; }
. { return TokenType.BAD_CHARACTER; }