package com.antonzherdev.objd.psi;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.IChain;
import com.antonzherdev.objd.ObjDFileType;
import com.antonzherdev.objd.ObjDLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static com.antonzherdev.chain.Chain.chain;
import static com.antonzherdev.chain.Chain.empty;

public class ObjDFile extends PsiFileBase {
    public ObjDFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ObjDLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return ObjDFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "ObjD File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

    public IChain<String> getPackage() {
        ASTNode[] packs = getNode().getChildren(TokenSet.create(ObjDTypes.PACK_STATEMENT));
        if(packs.length == 0) return empty();
        ASTNode pack = packs[0];
        return chain(pack.getPsi(ObjDPackStatement.class).getPackPartList()).map(new F<ObjDPackPart, String>() {
            @Override
            public String f(ObjDPackPart objDPackPart) {
                return objDPackPart.getName();
            }
        });
    }
}