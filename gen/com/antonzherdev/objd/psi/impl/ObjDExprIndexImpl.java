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

public class ObjDExprIndexImpl extends ObjDExprImpl implements ObjDExprIndex {

  public ObjDExprIndexImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitExprIndex(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ObjDIndexOp getIndexOp() {
    return findChildByClass(ObjDIndexOp.class);
  }

  @Override
  @NotNull
  public ObjDTerm getTerm() {
    return findNotNullChildByClass(ObjDTerm.class);
  }

}
