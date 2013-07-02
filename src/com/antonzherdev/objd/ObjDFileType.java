package com.antonzherdev.objd;

import com.intellij.icons.AllIcons;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ObjDFileType extends LanguageFileType {
    public static final ObjDFileType INSTANCE = new ObjDFileType();

    protected ObjDFileType() {
        super(ObjDLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "ObjectiveD source";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "ObjectiveD source file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "od";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Custom;
    }
}
