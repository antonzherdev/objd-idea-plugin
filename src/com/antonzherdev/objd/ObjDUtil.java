package com.antonzherdev.objd;

import com.antonzherdev.chain.B;
import com.antonzherdev.chain.F;
import com.antonzherdev.chain.IChain;
import com.antonzherdev.chain.Option;
import com.antonzherdev.objd.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.indexing.FileBasedIndex;

import java.util.Arrays;
import java.util.List;

import static com.antonzherdev.chain.Chain.chain;

public class ObjDUtil {
    public static Option<ObjDFile> findFile(Project project, final String fileName) {
        return getAllVirtualFiles(project).filter(new B<VirtualFile>() {
            @Override
            public Boolean f(VirtualFile virtualFile) {
                return virtualFile.getNameWithoutExtension().equals(fileName);
            }
        }).map(toObjDFileF(project)).first();
    }

    public static IChain<ObjDFile> getAllFiles(final Project project) {
        return getAllVirtualFiles(project).map(toObjDFileF(project));
    }

    private static F<VirtualFile, ObjDFile> toObjDFileF(final Project project) {
        return new F<VirtualFile, ObjDFile>() {
            @Override
            public ObjDFile f(VirtualFile virtualFile) {
                return (ObjDFile) PsiManager.getInstance(project).findFile(virtualFile);
            }
        };
    }

    private static IChain<VirtualFile> getAllVirtualFiles(Project project) {
        return chain(FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME,
                ObjDFileType.INSTANCE, GlobalSearchScope.allScope(project)));
    }

    public static IChain<ObjDClassName> availableClassesInFile(PsiFile file) {
        return chain(file.getNode().getChildren(TokenSet.create(ObjDTypes.IMPORT_STATEMENT)))
                .map(new F<ASTNode,ObjDFile>() {
                    @Override
                    public ObjDFile f(ASTNode astNode) {
                        ObjDImportOdFile od = astNode.getPsi(ObjDImportStatement.class).getImportOdFile();
                        if(od == null) return null;
                        return (ObjDFile) od.getReference().resolve();
                    }
                })
                .prepend((ObjDFile)file)
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
                });
    }
}
