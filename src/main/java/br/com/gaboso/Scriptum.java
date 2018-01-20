package br.com.gaboso;

import br.com.gaboso.helper.FileHelper;
import br.com.gaboso.module.BowerModule;
import br.com.gaboso.module.GitModule;
import br.com.gaboso.module.GruntModule;
import br.com.gaboso.module.MavenModule;
import br.com.gaboso.module.NpmModule;

import java.io.File;
import java.util.List;

/**
 * @author Gaboso
 * @since 19/04/2017
 * <p>Scriptum</p>
 */
public class Scriptum {

    public static void main(String[] args) {
        String workspaceDir;

        if (args.length > 0) {
            workspaceDir = args[0];
        } else {
            workspaceDir = FileHelper.getJarDir();
        }

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