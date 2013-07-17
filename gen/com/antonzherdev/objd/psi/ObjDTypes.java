// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.antonzherdev.objd.psi.impl.*;

public interface ObjDTypes {

  IElementType CALL_NAME = new ObjDElementType("CALL_NAME");
  IElementType CLASS_BODY = new ObjDElementType("CLASS_BODY");
  IElementType CLASS_CONSTRUCTOR_FIELD = new ObjDElementType("CLASS_CONSTRUCTOR_FIELD");
  IElementType CLASS_EXTENDS = new ObjDElementType("CLASS_EXTENDS");
  IElementType CLASS_NAME = new ObjDElementType("CLASS_NAME");
  IElementType CLASS_STATEMENT = new ObjDElementType("CLASS_STATEMENT");
  IElementType DATA_TYPE = new ObjDElementType("DATA_TYPE");
  IElementType DATA_TYPE_REF = new ObjDElementType("DATA_TYPE_REF");
  IElementType DEF_NAME = new ObjDElementType("DEF_NAME");
  IElementType DEF_PARAMETER = new ObjDElementType("DEF_PARAMETER");
  IElementType DEF_STATEMENT = new ObjDElementType("DEF_STATEMENT");
  IElementType EXPR = new ObjDElementType("EXPR");
  IElementType EXPR_BRACES = new ObjDElementType("EXPR_BRACES");
  IElementType EXPR_CALL = new ObjDElementType("EXPR_CALL");
  IElementType EXPR_LAMBDA = new ObjDElementType("EXPR_LAMBDA");
  IElementType EXPR_OP = new ObjDElementType("EXPR_OP");
  IElementType EXPR_VAL = new ObjDElementType("EXPR_VAL");
  IElementType FIELD_STATEMENT = new ObjDElementType("FIELD_STATEMENT");
  IElementType IMPORT_OD_FILE = new ObjDElementType("IMPORT_OD_FILE");
  IElementType IMPORT_STATEMENT = new ObjDElementType("IMPORT_STATEMENT");
  IElementType LAMBDA_PAR = new ObjDElementType("LAMBDA_PAR");

  IElementType AND = new ObjDTokenType("AND");
  IElementType ARROW = new ObjDTokenType("ARROW");
  IElementType CLOSE_BRACE = new ObjDTokenType("CLOSE_BRACE");
  IElementType CLOSE_BRACKET = new ObjDTokenType("CLOSE_BRACKET");
  IElementType CLOSE_SQUARE_BRACKET = new ObjDTokenType("CLOSE_SQUARE_BRACKET");
  IElementType COLON = new ObjDTokenType("COLON");
  IElementType COMMA = new ObjDTokenType("COMMA");
  IElementType COMMENT = new ObjDTokenType("COMMENT");
  IElementType DIV = new ObjDTokenType("DIV");
  IElementType DIV_SET = new ObjDTokenType("DIV_SET");
  IElementType DOT = new ObjDTokenType("DOT");
  IElementType EQ = new ObjDTokenType("EQ");
  IElementType EXCLAMATION = new ObjDTokenType("EXCLAMATION");
  IElementType FLOAT = new ObjDTokenType("FLOAT");
  IElementType IDENT = new ObjDTokenType("IDENT");
  IElementType INT = new ObjDTokenType("INT");
  IElementType LESS = new ObjDTokenType("LESS");
  IElementType LESSEQ = new ObjDTokenType("LESSEQ");
  IElementType MINUS = new ObjDTokenType("MINUS");
  IElementType MINUS_MINUS = new ObjDTokenType("MINUS_MINUS");
  IElementType MINUS_SET = new ObjDTokenType("MINUS_SET");
  IElementType MORE = new ObjDTokenType("MORE");
  IElementType MOREEQ = new ObjDTokenType("MOREEQ");
  IElementType MUL = new ObjDTokenType("MUL");
  IElementType MUL_SET = new ObjDTokenType("MUL_SET");
  IElementType NOT_EQ = new ObjDTokenType("NOT_EQ");
  IElementType OPEN_BRACE = new ObjDTokenType("OPEN_BRACE");
  IElementType OPEN_BRACKET = new ObjDTokenType("OPEN_BRACKET");
  IElementType OPEN_SQUARE_BRACKET = new ObjDTokenType("OPEN_SQUARE_BRACKET");
  IElementType OR = new ObjDTokenType("OR");
  IElementType PLUS = new ObjDTokenType("PLUS");
  IElementType PLUS_PLUS = new ObjDTokenType("PLUS_PLUS");
  IElementType PLUS_SET = new ObjDTokenType("PLUS_SET");
  IElementType SET = new ObjDTokenType("SET");
  IElementType STRING = new ObjDTokenType("STRING");
  IElementType TP_BOOL = new ObjDTokenType("TP_BOOL");
  IElementType TP_FLOAT = new ObjDTokenType("TP_FLOAT");
  IElementType TP_INT = new ObjDTokenType("TP_INT");
  IElementType TP_STRING = new ObjDTokenType("TP_STRING");
  IElementType TP_UINT = new ObjDTokenType("TP_UINT");
  IElementType TP_VOID = new ObjDTokenType("TP_VOID");
  IElementType WHAT = new ObjDTokenType("WHAT");
  IElementType W_CLASS = new ObjDTokenType("W_CLASS");
  IElementType W_DEF = new ObjDTokenType("W_DEF");
  IElementType W_ELSE = new ObjDTokenType("W_ELSE");
  IElementType W_ENUM = new ObjDTokenType("W_ENUM");
  IElementType W_EXTENDS = new ObjDTokenType("W_EXTENDS");
  IElementType W_FALSE = new ObjDTokenType("W_FALSE");
  IElementType W_IF = new ObjDTokenType("W_IF");
  IElementType W_IMPORT = new ObjDTokenType("W_IMPORT");
  IElementType W_NIL = new ObjDTokenType("W_NIL");
  IElementType W_PRIVATE = new ObjDTokenType("W_PRIVATE");
  IElementType W_SELF = new ObjDTokenType("W_SELF");
  IElementType W_STATIC = new ObjDTokenType("W_STATIC");
  IElementType W_STRUCT = new ObjDTokenType("W_STRUCT");
  IElementType W_STUB = new ObjDTokenType("W_STUB");
  IElementType W_THROW = new ObjDTokenType("W_THROW");
  IElementType W_TRAIT = new ObjDTokenType("W_TRAIT");
  IElementType W_TRUE = new ObjDTokenType("W_TRUE");
  IElementType W_VAL = new ObjDTokenType("W_VAL");
  IElementType W_VAR = new ObjDTokenType("W_VAR");
  IElementType W_WEAK = new ObjDTokenType("W_WEAK");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == CALL_NAME) {
        return new ObjDCallNameImpl(node);
      }
      else if (type == CLASS_BODY) {
        return new ObjDClassBodyImpl(node);
      }
      else if (type == CLASS_CONSTRUCTOR_FIELD) {
        return new ObjDClassConstructorFieldImpl(node);
      }
      else if (type == CLASS_EXTENDS) {
        return new ObjDClassExtendsImpl(node);
      }
      else if (type == CLASS_NAME) {
        return new ObjDClassNameImpl(node);
      }
      else if (type == CLASS_STATEMENT) {
        return new ObjDClassStatementImpl(node);
      }
      else if (type == DATA_TYPE) {
        return new ObjDDataTypeImpl(node);
      }
      else if (type == DATA_TYPE_REF) {
        return new ObjDDataTypeRefImpl(node);
      }
      else if (type == DEF_NAME) {
        return new ObjDDefNameImpl(node);
      }
      else if (type == DEF_PARAMETER) {
        return new ObjDDefParameterImpl(node);
      }
      else if (type == DEF_STATEMENT) {
        return new ObjDDefStatementImpl(node);
      }
      else if (type == EXPR) {
        return new ObjDExprImpl(node);
      }
      else if (type == EXPR_BRACES) {
        return new ObjDExprBracesImpl(node);
      }
      else if (type == EXPR_CALL) {
        return new ObjDExprCallImpl(node);
      }
      else if (type == EXPR_LAMBDA) {
        return new ObjDExprLambdaImpl(node);
      }
      else if (type == EXPR_OP) {
        return new ObjDExprOpImpl(node);
      }
      else if (type == EXPR_VAL) {
        return new ObjDExprValImpl(node);
      }
      else if (type == FIELD_STATEMENT) {
        return new ObjDFieldStatementImpl(node);
      }
      else if (type == IMPORT_OD_FILE) {
        return new ObjDImportOdFileImpl(node);
      }
      else if (type == IMPORT_STATEMENT) {
        return new ObjDImportStatementImpl(node);
      }
      else if (type == LAMBDA_PAR) {
        return new ObjDLambdaParImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
