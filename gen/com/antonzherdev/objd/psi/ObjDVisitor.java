// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class ObjDVisitor extends PsiElementVisitor {

  public void visitCallName(@NotNull ObjDCallName o) {
    visitNamedElement(o);
  }

  public void visitCaseCond(@NotNull ObjDCaseCond o) {
    visitPsiElement(o);
  }

  public void visitCaseCondConst(@NotNull ObjDCaseCondConst o) {
    visitCaseCond(o);
  }

  public void visitCaseCondTp(@NotNull ObjDCaseCondTp o) {
    visitCaseCond(o);
  }

  public void visitCaseCondUnapply(@NotNull ObjDCaseCondUnapply o) {
    visitCaseCond(o);
  }

  public void visitCaseCondVal(@NotNull ObjDCaseCondVal o) {
    visitCaseCond(o);
  }

  public void visitCaseItem(@NotNull ObjDCaseItem o) {
    visitPsiElement(o);
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

  public void visitClassMods(@NotNull ObjDClassMods o) {
    visitPsiElement(o);
  }

  public void visitClassName(@NotNull ObjDClassName o) {
    visitNamedElement(o);
  }

  public void visitClassStatement(@NotNull ObjDClassStatement o) {
    visitClass(o);
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

  public void visitExprBind(@NotNull ObjDExprBind o) {
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

  public void visitExprCallPostLambda(@NotNull ObjDExprCallPostLambda o) {
    visitPsiElement(o);
  }

  public void visitExprCase(@NotNull ObjDExprCase o) {
    visitPsiElement(o);
  }

  public void visitExprClue(@NotNull ObjDExprClue o) {
    visitExpr(o);
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

  public void visitExprStringConst(@NotNull ObjDExprStringConst o) {
    visitExpr(o);
  }

  public void visitExprSuper(@NotNull ObjDExprSuper o) {
    visitExpr(o);
  }

  public void visitExprSync(@NotNull ObjDExprSync o) {
    visitExpr(o);
  }

  public void visitExprThrow(@NotNull ObjDExprThrow o) {
    visitExpr(o);
  }

  public void visitExprVal(@NotNull ObjDExprVal o) {
    visitExpr(o);
  }

  public void visitExprWeak(@NotNull ObjDExprWeak o) {
    visitPsiElement(o);
  }

  public void visitExprWhile(@NotNull ObjDExprWhile o) {
    visitExpr(o);
  }

  public void visitFieldStatement(@NotNull ObjDFieldStatement o) {
    visitPsiElement(o);
  }

  public void visitImportPart(@NotNull ObjDImportPart o) {
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

  public void visitPackPart(@NotNull ObjDPackPart o) {
    visitNamedElement(o);
  }

  public void visitPackStatement(@NotNull ObjDPackStatement o) {
    visitPsiElement(o);
  }

  public void visitParMods(@NotNull ObjDParMods o) {
    visitPsiElement(o);
  }

  public void visitStringToken(@NotNull ObjDStringToken o) {
    visitPsiElement(o);
  }

  public void visitTerm(@NotNull ObjDTerm o) {
    visitExpr(o);
  }

  public void visitTypeStatement(@NotNull ObjDTypeStatement o) {
    visitClass(o);
  }

  public void visitClass(@NotNull ObjDClass o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull ObjDNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
