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

public class ObjDClassConstructorFieldImpl extends ASTWrapperPsiElement implements ObjDClassConstructorField {

  public ObjDClassConstructorFieldImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitClassConstructorField(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ObjDDataType getDataType() {
    return findNotNullChildByClass(ObjDDataType.class);
  }

  @Override
  @NotNull
  public ObjDDefName getDefName() {
    return findNotNullChildByClass(ObjDDefName.class);
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

}
