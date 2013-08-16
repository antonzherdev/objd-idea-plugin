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

public class ObjDTypeStatementImpl extends ASTWrapperPsiElement implements ObjDTypeStatement {

  public ObjDTypeStatementImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public ObjDClassExtends getClassExtends() {
    return findNotNullChildByClass(ObjDClassExtends.class);
  }

  @Override
  @Nullable
  public ObjDClassGenerics getClassGenerics() {
    return findChildByClass(ObjDClassGenerics.class);
  }

  @Override
  @NotNull
  public ObjDClassName getClassName() {
    return findNotNullChildByClass(ObjDClassName.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitTypeStatement(this);
    else super.accept(visitor);
  }

}