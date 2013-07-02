package com.antonzherdev.objd.psi;

import com.antonzherdev.objd.ObjDLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;

public class ObjDElementType extends IElementType {
    public ObjDElementType(@NonNls String debugName) {
        super(debugName, ObjDLanguage.INSTANCE);
    }

    public String toString() {
        return "ObjDElementType." + super.toString();
    }
}
