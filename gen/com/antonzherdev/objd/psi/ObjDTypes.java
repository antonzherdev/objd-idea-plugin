// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.antonzherdev.objd.psi.impl.*;

public interface ObjDTypes {

  IElementType PROPERTY = new ObjDElementType("PROPERTY");

  IElementType COMMENT = new ObjDTokenType("COMMENT");
  IElementType CRLF = new ObjDTokenType("CRLF");
  IElementType KEY = new ObjDTokenType("KEY");
  IElementType SEPARATOR = new ObjDTokenType("SEPARATOR");
  IElementType VALUE = new ObjDTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new ObjDPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
