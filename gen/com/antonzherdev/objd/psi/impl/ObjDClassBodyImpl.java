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

public class ObjDClassBodyImpl extends ASTWrapperPsiElement implements ObjDClassBody {

  public ObjDClassBodyImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<ObjDDefName> getDefNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDDefName.class);
  }

  @Override
  @NotNull
  public List<ObjDDefStatement> getDefStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDDefStatement.class);
  }

  @Override
  @NotNull
  public List<ObjDExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDExpr.class);
  }

  @Override
  @NotNull
  public List<ObjDFieldStatement> getFieldStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDFieldStatement.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitClassBody(this);
    else super.accept(visitor);
  }

}
