// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.antonzherdev.objd.psi.impl.ObjDNamedElementImpl;

public interface ObjDTypeStatement extends ObjDClass {

  @Nullable
  ObjDClassExtends getClassExtends();

  @Nullable
  ObjDClassGenerics getClassGenerics();

  @Nullable
  ObjDClassName getClassName();

  List<ObjDClassExtends> getClassExtendsList();

  String getName();

}
