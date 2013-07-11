package com.antonzherdev.objd.psi.impl;

import com.antonzherdev.objd.ObjDImportReference;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.ObjDElementFactory;
import com.antonzherdev.objd.psi.ObjDImportOdFile;
import com.antonzherdev.objd.psi.ObjDImportStatement;
import com.antonzherdev.objd.psi.ObjDTypes;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public class ObjDPsiImplUtil {
    public static String getName(ObjDImportOdFile element) {
        ASTNode keyNode = element.getNode().findChildByType(ObjDTypes.IDENT);
        return keyNode != null ? keyNode.getText() : null;
    }

    public static PsiElement setName(ObjDImportOdFile element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(ObjDTypes.IDENT);
        if (keyNode != null) {
            ObjDImportStatement imp = ObjDElementFactory.createImport(element.getProject(), newName);
            ASTNode newKeyNode = imp.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(ObjDImportOdFile element) {
        ASTNode keyNode = element.getNode().findChildByType(ObjDTypes.IDENT);
        return keyNode != null ? keyNode.getPsi() : null;
    }

    public static PsiReference getReference(ObjDImportOdFile element) {
        return new ObjDImportReference(element, TextRange.from(0, element.getTextLength()));
    }
}
