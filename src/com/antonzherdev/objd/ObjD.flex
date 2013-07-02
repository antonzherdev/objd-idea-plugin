package com.antonzherdev.objd;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.antonzherdev.objd.psi.ObjDTypes;
import com.intellij.psi.TokenType;

%%

%class ObjDLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WHITE_SPACE=[\ \t\f\r\n]
END_OF_LINE_COMMENT="//"[^\r\n]*
MULTI_LINE_COMMENT="/*"[^\00]*"*/"
STRING="\"".*"\""
IDENT_CHAR= [a-zA-Z0-9_]

%state WAITING_VALUE

%%

<YYINITIAL> {
    {END_OF_LINE_COMMENT} {return ObjDTypes.COMMENT; }
    {MULTI_LINE_COMMENT} {return ObjDTypes.COMMENT; }
    {STRING} {return ObjDTypes.STRING;}

    "class" {return ObjDTypes.W_CLASS; }
    "import" {return ObjDTypes.W_IMPORT; }
    "var" {return ObjDTypes.W_VAR; }
    "val" {return ObjDTypes.W_VAL; }
    "def" {return ObjDTypes.W_DEF; }
    "extends" {return ObjDTypes.W_EXTENDS; }
    "private" {return ObjDTypes.W_PRIVATE; }
    "static" {return ObjDTypes.W_STATIC; }
    "get" {return ObjDTypes.W_GET; }
    "set" {return ObjDTypes.W_SET; }
    "nil" {return ObjDTypes.W_NIL; }
    "true" {return ObjDTypes.W_TRUE; }
    "false" {return ObjDTypes.W_FALSE; }
    "if" {return ObjDTypes.W_IF; }
    "else" {return ObjDTypes.W_ELSE; }
    "stub" {return ObjDTypes.W_STUB; }
    "trait" {return ObjDTypes.W_TRAIT; }
    "struct" {return ObjDTypes.W_STRUCT; }
    "enum" {return ObjDTypes.W_ENUM; }

    "bool" {return ObjDTypes.TP_BOOL; }
    "float" {return ObjDTypes.TP_FLOAT; }
    "string" {return ObjDTypes.TP_STRING; }
    "int" {return ObjDTypes.TP_INT; }
    "uint" {return ObjDTypes.TP_UINT; }
    "void" {return ObjDTypes.TP_VOID; }

    {IDENT_CHAR}+ {return ObjDTypes.IDENT; }

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
    "==" {return ObjDTypes.EQ;}
    "=" {return ObjDTypes.SET;}
    "||" {return ObjDTypes.OR;}
    "&&" {return ObjDTypes.AND;}
    "|" {return ObjDTypes.LINE;}
    "." {return ObjDTypes.DOT;}
    "++" {return ObjDTypes.PLUS_PLUS;}
    "+" {return ObjDTypes.PLUS;}
    "--" {return ObjDTypes.MINUS_MINUS;}
    "-" {return ObjDTypes.MINUS;}
    "*" {return ObjDTypes.MUL;}
    "/" {return ObjDTypes.DIV;}
    "?" {return ObjDTypes.WHAT;}

}

{WHITE_SPACE}+ {return TokenType.WHITE_SPACE; }
. { return TokenType.BAD_CHARACTER; }