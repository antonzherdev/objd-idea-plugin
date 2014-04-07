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

public class ObjDImportPartImpl extends ObjDNamedElementImpl implements ObjDImportPart {

  public ObjDImportPartImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ObjDVisitor) ((ObjDVisitor)visitor).visitImportPart(this);
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

}
