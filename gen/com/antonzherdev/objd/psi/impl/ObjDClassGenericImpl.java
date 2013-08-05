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

public class ObjDClassGenericImpl extends ASTWrapperPsiElement implements ObjDClassGeneric {

  public ObjDClassGenericImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public ObjDClassName getClassName() {
    return findNotNullChildByClass(ObjDClassName.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitClassGeneric(this);
    else super.accept(visitor);
  }

}
