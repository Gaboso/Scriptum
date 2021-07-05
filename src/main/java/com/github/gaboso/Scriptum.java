package com.github.gaboso;

import com.github.gaboso.helper.FileHelper;
import com.github.gaboso.module.BowerModule;
import com.github.gaboso.module.GitModule;
import com.github.gaboso.module.GruntModule;
import com.github.gaboso.module.MavenModule;
import com.github.gaboso.module.NpmModule;

import java.io.File;
import java.util.List;

/**
 * @since 1.0
 * Scriptum
 */
public class Scriptum {

    public static void main(String[] args) {
        String workspaceDir = args.length > 0
            ? args[0]
            : FileHelper.getJarDir();

        List<File> folders = FileHelper.getFoldersFromWorkspace(workspaceDir);

        for (File file : folders) {
            Scriptum.analyzeFolders(file);
        }

    }

    private static void analyzeFolders(File file) {
        File[] listFiles = file.listFiles();

        if (GitModule.isProject(file.getPath())) {
            GitModule.executeCommands(file.getName(), file.getPath());
        }

        if (listFiles != null) {

            if (MavenModule.isProject(listFiles)) {
                MavenModule.executeCommands(file.getName(), file.getPath());
            }

            if (NpmModule.isProject(listFiles)) {
                NpmModule.executeCommands(file.getName(), file.getPath());
            }

            if (BowerModule.isProject(listFiles)) {
                BowerModule.executeCommands(file.getName(), file.getPath());
            }

            if (GruntModule.isProject(listFiles)) {
                GruntModule.executeCommands(file.getName(), file.getPath());
            }
        }
    }

}
