package com.github.gaboso;

import com.github.gaboso.helper.FileHelper;

import java.io.File;
import java.util.List;

/**
 * @since 2.0.0
 * Main
 */
public class Main {

    public static void main(String[] args) {
        String workspaceDir = args.length > 0
            ? args[0]
            : FileHelper.getJarDir();

        List<File> folders = FileHelper.getFoldersFromWorkspace(workspaceDir);

        ModuleRunner moduleRunner = new ModuleRunner();
        moduleRunner.runAll(folders);
    }

}
