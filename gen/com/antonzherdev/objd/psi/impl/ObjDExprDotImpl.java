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

public class ObjDExprDotImpl extends ObjDExprImpl implements ObjDExprDot {

  public ObjDExprDotImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<ObjDExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDExpr.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitExprDot(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ObjDExpr getLeft() {
    List<ObjDExpr> p1 = getExprList();
    return p1.get(0);
  }

  @Override
  @Nullable
  public ObjDExpr getRight() {
    List<ObjDExpr> p1 = getExprList();
    return p1.size() < 2 ? null : p1.get(1);
  }

}
