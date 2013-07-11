package com.antonzherdev.objd;

import com.antonzherdev.objd.psi.ObjDFile;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;

import java.util.Collection;

public class ObjDUtil {
    public static ObjDFile findFile(Project project, String fileName) {
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME,
                ObjDFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            if(virtualFile.getNameWithoutExtension().equals(fileName)) {
                return (ObjDFile) PsiManager.getInstance(project).findFile(virtualFile);
            }
        }
        return null;
    }
}
