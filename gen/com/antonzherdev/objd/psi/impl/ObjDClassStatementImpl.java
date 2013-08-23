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

public class ObjDClassStatementImpl extends ASTWrapperPsiElement implements ObjDClassStatement {

  public ObjDClassStatementImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public ObjDClassBody getClassBody() {
    return findChildByClass(ObjDClassBody.class);
  }

  @Override
  @NotNull
  public List<ObjDClassConstructorField> getClassConstructorFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDClassConstructorField.class);
  }

  @Override
  @NotNull
  public List<ObjDClassExtends> getClassExtendsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjDClassExtends.class);
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

  @Override
  @NotNull
  public ObjDClassType getClassType() {
    return findNotNullChildByClass(ObjDClassType.class);
  }

  @Override
  @Nullable
  public ObjDExprCallParams getExprCallParams() {
    return findChildByClass(ObjDExprCallParams.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitClassStatement(this);
    else super.accept(visitor);
  }

  public boolean isEnum() {
    return ObjDPsiImplUtil.isEnum(this);
  }

}
