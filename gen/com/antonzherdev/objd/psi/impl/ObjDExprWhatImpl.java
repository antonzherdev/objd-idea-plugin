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

public class ObjDExprWhatImpl extends ObjDExprImpl implements ObjDExprWhat {

  public ObjDExprWhatImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public ObjDExprCallPostLambda getExprCallPostLambda() {
    return findChildByClass(ObjDExprCallPostLambda.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitExprWhat(this);
    else super.accept(visitor);
  }

}
