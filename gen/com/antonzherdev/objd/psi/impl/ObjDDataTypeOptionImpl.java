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

public class ObjDDataTypeOptionImpl extends ObjDDataTypeImpl implements ObjDDataTypeOption {

  public ObjDDataTypeOptionImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public ObjDDataType getDataType() {
    return findChildByClass(ObjDDataType.class);
  }

  @Override
  @Nullable
  public ObjDDataTypeSelf getDataTypeSelf() {
    return findChildByClass(ObjDDataTypeSelf.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitDataTypeOption(this);
    else super.accept(visitor);
  }

}
