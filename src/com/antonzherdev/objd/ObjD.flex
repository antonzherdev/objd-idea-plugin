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

CRLF= \n|\r|\r\n
WHITE_SPACE=[\ \t\f]
FIRST_VALUE_CHARACTER=[^ \n\r\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\r\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT="//"[^\r\n]*
IDENT_CHAR= [a-zA-Z0-9_]

%state WAITING_VALUE

%%

<YYINITIAL> {
    {END_OF_LINE_COMMENT} {return ObjDTypes.COMMENT; }
    "class" {return ObjDTypes.W_CLASS; }
    "import" {return ObjDTypes.W_IMPORT; }
    {IDENT_CHAR}+ {return ObjDTypes.IDENT; }
}

{CRLF} {return ObjDTypes.CRLF; }
{WHITE_SPACE}+ {return TokenType.WHITE_SPACE; }
. { return TokenType.BAD_CHARACTER; }