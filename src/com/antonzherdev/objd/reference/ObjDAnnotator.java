package com.antonzherdev.objd.reference;


import com.antonzherdev.objd.psi.ObjDCallName;
import com.antonzherdev.objd.psi.ObjDDataTypeRef;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class ObjDAnnotator  implements Annotator {
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof ObjDCallName && !CallReference.isAfterDot(element)) {
            if(!((ObjDCallName) element).getName().equals("_") && element.getReference().resolve() == null) {
                addAnotation("Unresolved reference", element, holder);
            }
        } else if(element instanceof ObjDDataTypeRef) {
            if(element.getReference().resolve() == null) {
                addAnotation("Unresolved data type", element, holder);
            }
        }
    }

    private void addAnotation(String text, PsiElement element, AnnotationHolder holder) {
        TextRange range = new TextRange(element.getTextRange().getStartOffset(),
                element.getTextRange().getEndOffset());
        holder.createErrorAnnotation(range, text);
    }
}