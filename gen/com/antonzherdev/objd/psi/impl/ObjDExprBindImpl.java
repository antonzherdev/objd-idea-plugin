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

public class ObjDExprBindImpl extends ObjDExprImpl implements ObjDExprBind {

  public ObjDExprBindImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public ObjDExprBind getExprBind() {
    return findChildByClass(ObjDExprBind.class);
  }

  @Override
  @NotNull
  public ObjDExprSet getExprSet() {
    return findNotNullChildByClass(ObjDExprSet.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitExprBind(this);
    else super.accept(visitor);
  }

}