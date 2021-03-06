// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.antonzherdev.objd.psi.impl.ObjDNamedElementImpl;

public interface ObjDClassStatement extends ObjDClass {

  @Nullable
  ObjDClassBody getClassBody();

  @NotNull
  List<ObjDClassConstructorField> getClassConstructorFieldList();

  @NotNull
  List<ObjDClassExtends> getClassExtendsList();

  @Nullable
  ObjDClassGenerics getClassGenerics();

  @Nullable
  ObjDClassName getClassName();

  @NotNull
  ObjDClassType getClassType();

  @Nullable
  ObjDExprCallParams getExprCallParams();

  boolean isEnum();

  String getName();

}
