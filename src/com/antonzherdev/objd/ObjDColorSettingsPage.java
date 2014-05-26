package com.antonzherdev.objd;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ObjDColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keyword", ObjDSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Data types", ObjDSyntaxHighlighter.DATATYPE),
            new AttributesDescriptor("Comments", ObjDSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Operations", ObjDSyntaxHighlighter.OPERATION),
            new AttributesDescriptor("Numbers", ObjDSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Annotations", ObjDSyntaxHighlighter.METADATA)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Custom;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new ObjDSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "class Test {\n" +
                "    //Comment\n" +
                "    val s : string = \"String\"\n" +
                "    \n" +
                "    @Test\n" +
                "    def f(a : int) : int = a + 20\n" +
                "}";
    }

    @Nullable
    @Override
    public java.util.Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "ObjD";
    }
}