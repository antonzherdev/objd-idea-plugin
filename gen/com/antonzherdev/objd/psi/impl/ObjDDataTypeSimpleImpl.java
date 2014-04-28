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

public class ObjDDataTypeSimpleImpl extends ObjDDataTypeImpl implements ObjDDataTypeSimple {

  public ObjDDataTypeSimpleImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitDataTypeSimple(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ObjDDataTypeGenerics getDataTypeGenerics() {
    return findChildByClass(ObjDDataTypeGenerics.class);
  }

  @Override
  @Nullable
  public ObjDDataTypeRef getDataTypeRef() {
    return findChildByClass(ObjDDataTypeRef.class);
  }

}
