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

public class ObjDTypeStatementImpl extends ObjDClassImpl implements ObjDTypeStatement {

  public ObjDTypeStatementImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public ObjDClassExtends getClassExtends() {
    return findChildByClass(ObjDClassExtends.class);
  }

  @Override
  @Nullable
  public ObjDClassGenerics getClassGenerics() {
    return findChildByClass(ObjDClassGenerics.class);
  }

  @Override
  @Nullable
  public ObjDClassName getClassName() {
    return findChildByClass(ObjDClassName.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitTypeStatement(this);
    else super.accept(visitor);
  }

  public List<ObjDClassExtends> getClassExtendsList() {
    return ObjDPsiImplUtil.getClassExtendsList(this);
  }

  public String getName() {
    return ObjDPsiImplUtil.getName(this);
  }

}
