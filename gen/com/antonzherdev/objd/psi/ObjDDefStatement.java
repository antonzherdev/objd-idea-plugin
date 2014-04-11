// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ObjDDefStatement extends PsiElement {

  @Nullable
  ObjDClassGenerics getClassGenerics();

  @Nullable
  ObjDDataType getDataType();

  @Nullable
  ObjDDefName getDefName();

  @NotNull
  List<ObjDDefParameter> getDefParameterList();

  @Nullable
  ObjDExpr getExpr();

  @NotNull
  ObjDMods getMods();

  boolean isStatic();

}
