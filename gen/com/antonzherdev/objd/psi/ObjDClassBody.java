// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ObjDClassBody extends PsiElement {

  @NotNull
  List<ObjDAnnotations> getAnnotationsList();

  @NotNull
  List<ObjDDefStatement> getDefStatementList();

  @NotNull
  List<ObjDEnumItem> getEnumItemList();

  @NotNull
  List<ObjDFieldStatement> getFieldStatementList();

  @NotNull
  List<ObjDImportStatement> getImportStatementList();

}
