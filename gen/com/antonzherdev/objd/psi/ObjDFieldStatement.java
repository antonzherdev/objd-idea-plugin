// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ObjDFieldStatement extends PsiElement {

  @Nullable
  ObjDDataType getDataType();

  @Nullable
  ObjDDefName getDefName();

  @Nullable
  ObjDExpr getExpr();

  @NotNull
  ObjDMods getMods();

  boolean isStatic();

}
