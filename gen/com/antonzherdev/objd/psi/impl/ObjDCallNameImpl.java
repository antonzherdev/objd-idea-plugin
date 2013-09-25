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
import com.intellij.psi.PsiReference;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiNamedElement;

public class ObjDCallNameImpl extends ObjDNamedElementImpl implements ObjDCallName {

  public ObjDCallNameImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitCallName(this);
    else super.accept(visitor);
  }

  public String getName() {
    return ObjDPsiImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return ObjDPsiImplUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return ObjDPsiImplUtil.getNameIdentifier(this);
  }

  public PsiReference getReference() {
    return ObjDPsiImplUtil.getReference(this);
  }

  public ItemPresentation getPresentation() {
    return ObjDPsiImplUtil.getPresentation(this);
  }

}
