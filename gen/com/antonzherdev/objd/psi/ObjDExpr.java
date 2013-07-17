// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ObjDExpr extends PsiElement {

  @NotNull
  List<ObjDDataType> getDataTypeList();

  @NotNull
  List<ObjDExpr> getExprList();

  @Nullable
  ObjDExprBraces getExprBraces();

  @Nullable
  ObjDExprCall getExprCall();

  @Nullable
  ObjDExprOp getExprOp();

  @Nullable
  ObjDExprVal getExprVal();

}
