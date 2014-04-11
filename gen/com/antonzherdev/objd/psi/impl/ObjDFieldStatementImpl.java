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

public class ObjDFieldStatementImpl extends ASTWrapperPsiElement implements ObjDFieldStatement {

  public ObjDFieldStatementImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public ObjDDataType getDataType() {
    return findChildByClass(ObjDDataType.class);
  }

  @Override
  @Nullable
  public ObjDDefName getDefName() {
    return findChildByClass(ObjDDefName.class);
  }

  @Override
  @Nullable
  public ObjDExpr getExpr() {
    return findChildByClass(ObjDExpr.class);
  }

  @Override
  @NotNull
  public ObjDMods getMods() {
    return findNotNullChildByClass(ObjDMods.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitFieldStatement(this);
    else super.accept(visitor);
  }

  public boolean isStatic() {
    return ObjDPsiImplUtil.isStatic(this);
  }

}
