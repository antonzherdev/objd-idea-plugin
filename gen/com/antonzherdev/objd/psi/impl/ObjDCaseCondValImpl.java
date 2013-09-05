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

public class ObjDCaseCondValImpl extends ObjDCaseCondImpl implements ObjDCaseCondVal {

  public ObjDCaseCondValImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public ObjDCaseCondTp getCaseCondTp() {
    return findChildByClass(ObjDCaseCondTp.class);
  }

  @Override
  @NotNull
  public ObjDDefName getDefName() {
    return findNotNullChildByClass(ObjDDefName.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitCaseCondVal(this);
    else super.accept(visitor);
  }

}