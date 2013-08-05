// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ObjDClassStatement extends PsiElement {

  @Nullable
  ObjDClassBody getClassBody();

  @NotNull
  List<ObjDClassConstructorField> getClassConstructorFieldList();

  @Nullable
  ObjDClassExtends getClassExtends();

  @Nullable
  ObjDClassGenerics getClassGenerics();

  @NotNull
  ObjDClassName getClassName();

}
