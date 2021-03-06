package com.antonzherdev.objd.reference;


import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.*;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ObjDAnnotator  implements Annotator {
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof ObjDCallName) {
            PsiReference reference = element.getReference();
            String name = ((ObjDCallName) element).getName();
            if(reference != null && name != null && !name.equals("_") && reference.resolve() == null) {
                if(!ObjDUtil.isAfterDot(element) || ObjDUtil.getDot(element).get().getLeft().getTp().isDefined()) {
                    addAnotation("Unresolved reference", element, holder);
                }
            }
        } else if(element instanceof ObjDDataTypeRef) {
            PsiReference reference = element.getReference();
            if(!((ObjDDataTypeRef) element).getName().equals("_") && reference != null && reference.resolve() == null) {
                addAnotation("Unresolved data type", element, holder);
            }
        } else if(element instanceof ObjDImportStatement) {
            List<ObjDImportPart> parts = ((ObjDImportStatement) element).getImportPartList();
            ObjDImportPart last = parts.get(parts.size() - 1);
            if(!"_".equals(last.getName())) {
                PsiReference reference = last.getReference();
                if(reference != null && reference.resolve() == null) {
                    addAnotation("Unresolved class", element, holder);
                }
            }
        }
    }

    private void addAnotation(String text, PsiElement element, AnnotationHolder holder) {
        TextRange range = new TextRange(element.getTextRange().getStartOffset(),
                element.getTextRange().getEndOffset());
        holder.createErrorAnnotation(range, text);
    }
}