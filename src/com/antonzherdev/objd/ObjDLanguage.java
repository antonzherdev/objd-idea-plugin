package com.antonzherdev.objd;

import com.intellij.lang.Language;

public class ObjDLanguage extends Language {
    public static final ObjDLanguage INSTANCE = new ObjDLanguage();

    protected ObjDLanguage() {
        super("ObjD");
    }
}
