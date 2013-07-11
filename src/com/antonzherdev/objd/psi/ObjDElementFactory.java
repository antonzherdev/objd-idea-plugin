package com.antonzherdev.objd.psi;

import com.antonzherdev.objd.ObjDFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

public class ObjDElementFactory {
    public static ObjDImportStatement createImport(Project project, String name) {
        final ObjDFile file = createFile(project, "import " + name);
        return (ObjDImportStatement) file.getFirstChild();
    }

    public static ObjDFile createFile(Project project, String text) {
        String name = "dummy.od";
        return (ObjDFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, ObjDFileType.INSTANCE, text);
    }
}
