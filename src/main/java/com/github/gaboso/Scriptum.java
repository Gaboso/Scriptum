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

        for (File folder : folders) {
            Scriptum.analyzeFolder(folder);
        }

    }

    private static void analyzeFolder(File file) {
        File[] listFiles = file.listFiles();
        String path = file.getPath();
        String fileName = file.getName();

        if (GitModule.isProject(path)) {
            GitModule.executeCommands(fileName, path);
        }

        if (listFiles != null) {
            if (MavenModule.isProject(listFiles)) {
                MavenModule.executeCommands(fileName, path);
            }

            if (NpmModule.isProject(listFiles)) {
                NpmModule.executeCommands(fileName, path);
            }

            if (BowerModule.isProject(listFiles)) {
                BowerModule.executeCommands(fileName, path);
            }

            if (GruntModule.isProject(listFiles)) {
                GruntModule.executeCommands(fileName, path);
            }
        }
    }

}
