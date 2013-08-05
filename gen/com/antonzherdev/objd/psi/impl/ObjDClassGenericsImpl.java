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

public class ObjDClassGenericsImpl extends ASTWrapperPsiElement implements ObjDClassGenerics {

  public ObjDClassGenericsImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<ObjDClassGeneric> getClassGenericList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDClassGeneric.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitClassGenerics(this);
    else super.accept(visitor);
  }

}
