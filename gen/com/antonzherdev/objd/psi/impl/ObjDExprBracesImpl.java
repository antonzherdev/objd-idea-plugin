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

public class ObjDExprBracesImpl extends ObjDExprImpl implements ObjDExprBraces {

  public ObjDExprBracesImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitExprBraces(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ObjDExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDExpr.class);
  }

}
