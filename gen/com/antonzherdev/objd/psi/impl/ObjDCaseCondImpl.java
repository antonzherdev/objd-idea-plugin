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

public class ObjDCaseCondImpl extends ASTWrapperPsiElement implements ObjDCaseCond {

  public ObjDCaseCondImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<ObjDCaseCond> getCaseCondList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDCaseCond.class);
  }

  @Override
  @Nullable
  public ObjDDataType getDataType() {
    return findChildByClass(ObjDDataType.class);
  }

  @Override
  @Nullable
  public ObjDExprStringConst getExprStringConst() {
    return findChildByClass(ObjDExprStringConst.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitCaseCond(this);
    else super.accept(visitor);
  }

}
