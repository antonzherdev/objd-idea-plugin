// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi.impl;

import com.antonzherdev.objd.psi.ObjDAnnotations;
import com.antonzherdev.objd.psi.ObjDExprCall;
import com.antonzherdev.objd.psi.ObjDVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ObjDAnnotationsImpl extends ASTWrapperPsiElement implements ObjDAnnotations {

  public ObjDAnnotationsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitAnnotations(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ObjDExprCall> getExprCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDExprCall.class);
  }

}
