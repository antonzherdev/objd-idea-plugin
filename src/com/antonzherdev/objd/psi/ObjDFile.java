package com.antonzherdev.objd.psi;

import com.antonzherdev.objd.ObjDFileType;
import com.antonzherdev.objd.ObjDLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

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
}