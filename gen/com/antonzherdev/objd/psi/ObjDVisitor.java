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

  public void visitClassGeneric(@NotNull ObjDClassGeneric o) {
    visitPsiElement(o);
  }

  public void visitClassGenerics(@NotNull ObjDClassGenerics o) {
    visitPsiElement(o);
  }

  public void visitClassName(@NotNull ObjDClassName o) {
    visitNamedElement(o);
  }

  public void visitClassStatement(@NotNull ObjDClassStatement o) {
    visitPsiElement(o);
  }

  public void visitClassType(@NotNull ObjDClassType o) {
    visitPsiElement(o);
  }

  public void visitDataType(@NotNull ObjDDataType o) {
    visitPsiElement(o);
  }

  public void visitDataTypeCollection(@NotNull ObjDDataTypeCollection o) {
    visitDataType(o);
  }

  public void visitDataTypeGenerics(@NotNull ObjDDataTypeGenerics o) {
    visitPsiElement(o);
  }

  public void visitDataTypeLambda(@NotNull ObjDDataTypeLambda o) {
    visitDataType(o);
  }

  public void visitDataTypeMap(@NotNull ObjDDataTypeMap o) {
    visitDataType(o);
  }

  public void visitDataTypeOption(@NotNull ObjDDataTypeOption o) {
    visitDataType(o);
  }

  public void visitDataTypeRef(@NotNull ObjDDataTypeRef o) {
    visitNamedElement(o);
  }

  public void visitDataTypeSelf(@NotNull ObjDDataTypeSelf o) {
    visitPsiElement(o);
  }

  public void visitDataTypeSimple(@NotNull ObjDDataTypeSimple o) {
    visitDataType(o);
  }

  public void visitDataTypeTuple(@NotNull ObjDDataTypeTuple o) {
    visitDataType(o);
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

  public void visitEnumItem(@NotNull ObjDEnumItem o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull ObjDExpr o) {
    visitPsiElement(o);
  }

  public void visitExprArr(@NotNull ObjDExprArr o) {
    visitExpr(o);
  }

  public void visitExprBool(@NotNull ObjDExprBool o) {
    visitExpr(o);
  }

  public void visitExprBraces(@NotNull ObjDExprBraces o) {
    visitExpr(o);
  }

  public void visitExprBrackets(@NotNull ObjDExprBrackets o) {
    visitExpr(o);
  }

  public void visitExprCall(@NotNull ObjDExprCall o) {
    visitExpr(o);
  }

  public void visitExprCallParam(@NotNull ObjDExprCallParam o) {
    visitPsiElement(o);
  }

  public void visitExprCallParams(@NotNull ObjDExprCallParams o) {
    visitPsiElement(o);
  }

  public void visitExprComp(@NotNull ObjDExprComp o) {
    visitExpr(o);
  }

  public void visitExprDo(@NotNull ObjDExprDo o) {
    visitExpr(o);
  }

  public void visitExprDot(@NotNull ObjDExprDot o) {
    visitExpr(o);
  }

  public void visitExprIf(@NotNull ObjDExprIf o) {
    visitExpr(o);
  }

  public void visitExprIndex(@NotNull ObjDExprIndex o) {
    visitExpr(o);
  }

  public void visitExprLambda(@NotNull ObjDExprLambda o) {
    visitExpr(o);
  }

  public void visitExprMd(@NotNull ObjDExprMd o) {
    visitExpr(o);
  }

  public void visitExprMinus(@NotNull ObjDExprMinus o) {
    visitExpr(o);
  }

  public void visitExprNot(@NotNull ObjDExprNot o) {
    visitExpr(o);
  }

  public void visitExprPm(@NotNull ObjDExprPm o) {
    visitExpr(o);
  }

  public void visitExprReturn(@NotNull ObjDExprReturn o) {
    visitPsiElement(o);
  }

  public void visitExprSelf(@NotNull ObjDExprSelf o) {
    visitExpr(o);
  }

  public void visitExprSet(@NotNull ObjDExprSet o) {
    visitExpr(o);
  }

  public void visitExprThrow(@NotNull ObjDExprThrow o) {
    visitExpr(o);
  }

  public void visitExprVal(@NotNull ObjDExprVal o) {
    visitExpr(o);
  }

  public void visitExprWhile(@NotNull ObjDExprWhile o) {
    visitExpr(o);
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

  public void visitIndexOp(@NotNull ObjDIndexOp o) {
    visitPsiElement(o);
  }

  public void visitLambdaPar(@NotNull ObjDLambdaPar o) {
    visitPsiElement(o);
  }

  public void visitMods(@NotNull ObjDMods o) {
    visitPsiElement(o);
  }

  public void visitTerm(@NotNull ObjDTerm o) {
    visitExpr(o);
  }

  public void visitNamedElement(@NotNull ObjDNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
