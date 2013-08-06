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

public class ObjDEnumItemImpl extends ASTWrapperPsiElement implements ObjDEnumItem {

  public ObjDEnumItemImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public ObjDDefName getDefName() {
    return findNotNullChildByClass(ObjDDefName.class);
  }

  @Override
  @Nullable
  public ObjDExprCallParams getExprCallParams() {
    return findChildByClass(ObjDExprCallParams.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitEnumItem(this);
    else super.accept(visitor);
  }

}
