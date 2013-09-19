package com.antonzherdev.objd.choose;

import com.antonzherdev.chain.B;
import com.antonzherdev.chain.F;
import com.antonzherdev.objd.ObjDUtil;
import com.antonzherdev.objd.psi.ObjDClass;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GotoClass  implements ChooseByNameContributor {
    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        List<String> list = ObjDUtil.getAllClasses(project)
                .map(new F<ObjDClass, String>() {
                    @Override
                    public String f(ObjDClass x) {
                        return x.getClassName().getName();
                    }
                })
                .list();
        return list.toArray(new String[list.size()]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(final String name, String pattern, Project project, boolean includeNonProjectItems) {
        List<NavigationItem> list = ObjDUtil.getAllClasses(project)
                .filter(new B<ObjDClass>() {
                    @Override
                    public Boolean f(ObjDClass objDClass) {
                        return objDClass.getClassName().getName().equals(name);
                    }
                })
                .map(new F<ObjDClass, NavigationItem>() {
                    @Override
                    public NavigationItem f(ObjDClass objDClass) {
                        return objDClass.getClassName();
                    }
                })
                .list();
        return list.toArray(new NavigationItem[list.size()]);
    }
}
