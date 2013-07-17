// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class ObjDVisitor extends PsiElementVisitor {

  public void visitCallName(@NotNull ObjDCallName o) {
    visitNamedElement(o);
  }

  public void visitClassBody(@NotNull ObjDClassBody o) {
    visitPsiElement(o);
  }

  public void visitClassConstructorField(@NotNull ObjDClassConstructorField o) {
    visitPsiElement(o);
  }

  public void visitClassExtends(@NotNull ObjDClassExtends o) {
    visitPsiElement(o);
  }

  public void visitClassName(@NotNull ObjDClassName o) {
    visitNamedElement(o);
  }

  public void visitClassStatement(@NotNull ObjDClassStatement o) {
    visitPsiElement(o);
  }

  public void visitDataType(@NotNull ObjDDataType o) {
    visitPsiElement(o);
  }

  public void visitDataTypeRef(@NotNull ObjDDataTypeRef o) {
    visitNamedElement(o);
  }

  public void visitDefName(@NotNull ObjDDefName o) {
    visitNamedElement(o);
  }

  public void visitDefParameter(@NotNull ObjDDefParameter o) {
    visitPsiElement(o);
  }

  public void visitDefStatement(@NotNull ObjDDefStatement o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull ObjDExpr o) {
    visitPsiElement(o);
  }

  public void visitExprCall(@NotNull ObjDExprCall o) {
    visitPsiElement(o);
  }

  public void visitExprOp(@NotNull ObjDExprOp o) {
    visitPsiElement(o);
  }

  public void visitExprVal(@NotNull ObjDExprVal o) {
    visitPsiElement(o);
  }

  public void visitFieldStatement(@NotNull ObjDFieldStatement o) {
    visitPsiElement(o);
  }

  public void visitImportOdFile(@NotNull ObjDImportOdFile o) {
    visitNamedElement(o);
  }

  public void visitImportStatement(@NotNull ObjDImportStatement o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull ObjDNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
