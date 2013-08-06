// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ObjDExprCall extends ObjDExpr {

  @NotNull
  ObjDCallName getCallName();

  @NotNull
  List<ObjDDataType> getDataTypeList();

  @Nullable
  ObjDExprCallParams getExprCallParams();

}
