package com.antonzherdev.objd.reference;

import com.antonzherdev.chain.B;
import com.antonzherdev.chain.F;
import com.antonzherdev.objd.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.ArrayUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import static com.antonzherdev.chain.Chain.chain;

public class DataTypeReference extends PsiReferenceBase<ObjDDataTypeRef> {
    public DataTypeReference(@NotNull ObjDDataTypeRef element, TextRange textRange) {
        super(element, textRange);
    }


    @Nullable
    @Override
    public PsiElement resolve() {
        ObjDFile file = (ObjDFile) getElement().getContainingFile();
        return chain(file.getNode().getChildren(TokenSet.create(ObjDTypes.IMPORT_STATEMENT)))
                .map(new F<ASTNode,ObjDFile>() {
                    @Override
                    public ObjDFile f(ASTNode astNode) {
                        ObjDImportOdFile od = astNode.getPsi(ObjDImportStatement.class).getImportOdFile();
                        if(od == null) return null;
                        return (ObjDFile) od.getReference().resolve();
                    }
                })
                .prepend(file)
                .flatMap(new F<ObjDFile, List<ASTNode>>() {
                    @Override
                    public List<ASTNode> f(ObjDFile objDFile) {
                        return Arrays.asList(objDFile.getNode().getChildren(TokenSet.create(ObjDTypes.CLASS_STATEMENT)));
                    }
                })
                .map(new F<ASTNode,ObjDClassName>() {
                    @Override
                    public ObjDClassName f(ASTNode astNode) {
                        return astNode.getPsi(ObjDClassStatement.class).getClassName();
                    }
                })
                .find(new B<ObjDClassName>() {
                    @Override
                    public Boolean f(ObjDClassName className) {
                        return className.getName().equals(getElement().getName());
                    }
                }).getOrNull();
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return ArrayUtil.EMPTY_OBJECT_ARRAY;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public PsiElement handleElementRename(String newName) throws IncorrectOperationException {
        getElement().setName(newName);
        return getElement();
    }
}