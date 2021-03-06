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

public class ObjDTermImpl extends ObjDExprImpl implements ObjDTerm {

  public ObjDTermImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitTerm(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ObjDExprCase getExprCase() {
    return findChildByClass(ObjDExprCase.class);
  }

  @Override
  @Nullable
  public ObjDExprReturn getExprReturn() {
    return findChildByClass(ObjDExprReturn.class);
  }

  @Override
  @Nullable
  public ObjDExprWeak getExprWeak() {
    return findChildByClass(ObjDExprWeak.class);
  }

}
