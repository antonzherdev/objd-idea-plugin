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

public class ObjDExprImpl extends ASTWrapperPsiElement implements ObjDExpr {

  public ObjDExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<ObjDDataType> getDataTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDDataType.class);
  }

  @Override
  @NotNull
  public List<ObjDExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDExpr.class);
  }

  @Override
  @Nullable
  public ObjDExprBraces getExprBraces() {
    return findChildByClass(ObjDExprBraces.class);
  }

  @Override
  @Nullable
  public ObjDExprCall getExprCall() {
    return findChildByClass(ObjDExprCall.class);
  }

  @Override
  @Nullable
  public ObjDExprOp getExprOp() {
    return findChildByClass(ObjDExprOp.class);
  }

  @Override
  @Nullable
  public ObjDExprVal getExprVal() {
    return findChildByClass(ObjDExprVal.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitExpr(this);
    else super.accept(visitor);
  }

}
