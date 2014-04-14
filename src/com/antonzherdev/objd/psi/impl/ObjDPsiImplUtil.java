package com.antonzherdev.objd.psi.impl;

import com.antonzherdev.objd.psi.*;
import com.antonzherdev.objd.reference.CallReference;
import com.antonzherdev.objd.reference.DataTypeReference;
import com.antonzherdev.objd.reference.ObjDImportReference;
import com.antonzherdev.objd.tp.ObjDTp;
import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class ObjDPsiImplUtil {
    public static String getName(ObjDNamedElementImpl element) {
        ASTNode keyNode = element.getNode().findChildByType(ObjDTypes.IDENT);
        return keyNode != null ? keyNode.getText() : element.getText();
    }

    public static PsiElement setName(ObjDNamedElementImpl element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(ObjDTypes.IDENT);
        if (keyNode != null) {
            ObjDPackStatement imp = ObjDElementFactory.createImport(element.getProject(), newName);
            ASTNode newKeyNode = imp.getLastChild().getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(ObjDNamedElementImpl element) {
        ASTNode keyNode = element.getNode().findChildByType(ObjDTypes.IDENT);
        return keyNode != null ? keyNode.getPsi() : null;
    }

//    public static PsiReference getReference(ObjDImportPart element) {
//        return new ObjDImportReference(element, TextRange.from(0, element.getTextLength()));
//    }
//
//    public static PsiReference getReference(ObjDDataTypeRef element) {
//        return new DataTypeReference(element, TextRange.from(0, element.getTextLength()));
//    }
//
//    public static PsiReference getReference(ObjDCallName element) {
//        return new CallReference(element, TextRange.from(0, element.getTextLength()));
//    }

    public static ObjDTp getTp(ObjDExpr expr) {
        return ObjDTp.getTpForExpression(expr);
    }

    public static boolean isStatic(ObjDDefStatement statement) {
        return statement.getMods().getNode().findChildByType(ObjDTypes.W_STATIC) != null;
    }

    public static boolean isStatic(ObjDFieldStatementImpl statement) {
        return statement.getMods().getNode().findChildByType(ObjDTypes.W_STATIC) != null;
    }

    public static boolean isEnum(ObjDClassStatement s) {
        return s.getClassType().getNode().findChildByType(ObjDTypes.W_ENUM) != null;
    }

    public static List<ObjDClassExtends> getClassExtendsList(ObjDTypeStatement stm) {
        return Arrays.asList(stm.getClassExtends());
    }

    public static ItemPresentation getPresentation(final PsiNamedElement element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return AllIcons.FileTypes.Custom;
            }
        };
    }

    public static boolean isNullSafe(final ObjDDotType dotType) {
        return dotType.getNode().findChildByType(ObjDTypes.DOT) == null;
    }

    public static PsiReference createReference(PsiElement element) {
        if(element instanceof ObjDImportPart)
            return new ObjDImportReference((ObjDImportPart) element, TextRange.from(0, element.getTextLength()));
        if(element instanceof ObjDDataTypeRef)
            return new DataTypeReference((ObjDDataTypeRef) element, TextRange.from(0, element.getTextLength()));
        if(element instanceof ObjDCallName)
            return new CallReference((ObjDCallName) element, TextRange.from(0, element.getTextLength()));
        return  null;
    }
}

