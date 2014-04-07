// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.antonzherdev.objd.psi.ObjDTypes.*;
import com.antonzherdev.objd.psi.*;

public class ObjDDotPartSimpleImpl extends ObjDDotPartImpl implements ObjDDotPartSimple {

  public ObjDDotPartSimpleImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public ObjDDotType getDotType() {
    return findNotNullChildByClass(ObjDDotType.class);
  }

  @Override
  @NotNull
  public ObjDExpr getExpr() {
    return findNotNullChildByClass(ObjDExpr.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitDotPartSimple(this);
    else super.accept(visitor);
  }

}