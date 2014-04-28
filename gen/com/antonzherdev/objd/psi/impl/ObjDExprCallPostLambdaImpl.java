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

public class ObjDExprCallPostLambdaImpl extends ASTWrapperPsiElement implements ObjDExprCallPostLambda {

  public ObjDExprCallPostLambdaImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitExprCallPostLambda(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ObjDExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDExpr.class);
  }

  @Override
  @NotNull
  public List<ObjDLambdaPar> getLambdaParList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDLambdaPar.class);
  }

}
