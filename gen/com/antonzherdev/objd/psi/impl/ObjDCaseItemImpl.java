// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.antonzherdev.objd.psi.ObjDTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.antonzherdev.objd.psi.*;

public class ObjDCaseItemImpl extends ASTWrapperPsiElement implements ObjDCaseItem {

  public ObjDCaseItemImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public ObjDCaseCond getCaseCond() {
    return findNotNullChildByClass(ObjDCaseCond.class);
  }

  @Override
  @NotNull
  public ObjDExpr getExpr() {
    return findNotNullChildByClass(ObjDExpr.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitCaseItem(this);
    else super.accept(visitor);
  }

}
