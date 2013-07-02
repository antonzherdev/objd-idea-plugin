// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.antonzherdev.objd.psi.impl.*;

public interface ObjDTypes {

  IElementType CLS = new ObjDElementType("CLS");
  IElementType IMP = new ObjDElementType("IMP");

  IElementType COMMENT = new ObjDTokenType("COMMENT");
  IElementType CRLF = new ObjDTokenType("CRLF");
  IElementType IDENT = new ObjDTokenType("IDENT");
  IElementType W_CLASS = new ObjDTokenType("W_CLASS");
  IElementType W_IMPORT = new ObjDTokenType("W_IMPORT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == CLS) {
        return new ObjDClsImpl(node);
      }
      else if (type == IMP) {
        return new ObjDImpImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
