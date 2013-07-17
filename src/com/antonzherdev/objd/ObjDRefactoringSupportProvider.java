package com.antonzherdev.objd;

import com.antonzherdev.objd.psi.ObjDClassName;
import com.antonzherdev.objd.psi.ObjDDefName;
import com.antonzherdev.objd.psi.ObjDFile;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;

public class ObjDRefactoringSupportProvider extends RefactoringSupportProvider {
    @Override
    public boolean isMemberInplaceRenameAvailable(PsiElement element, PsiElement context) {
        return element instanceof ObjDFile || element instanceof ObjDClassName || element instanceof ObjDDefName;
    }
}