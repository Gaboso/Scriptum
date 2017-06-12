package br.com.gaboso;

import br.com.gaboso.module.BowerModule;
import br.com.gaboso.module.GitModule;
import br.com.gaboso.module.GruntModule;
import br.com.gaboso.module.MavenModule;
import br.com.gaboso.module.NpmModule;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gaboso
 * @since 19/04/2017
 * <p>
 * Scriptum
 */
public class Scriptum {

    private static final Logger LOGGER = Logger.getLogger(Scriptum.class);

    public static void main(String[] args) {
        if (args.length > 0) {
            Scriptum scriptum = new Scriptum();
            List<File> folders = scriptum.getFoldersFromWorkspace(args[0]);

            for (File file : folders) {
                scriptum.analyzeFolders(file);
            }
        }
    }

    private List<File> getFoldersFromWorkspace(String path) {
        File fileInitial = new File(path);
        File[] listFiles = fileInitial.listFiles();
        List<File> folders = new ArrayList<>();

        if (listFiles != null) {
            LOGGER.info("------------- LISTA DE DIRETORIOS DO WORKSPACE -------------");
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    folders.add(file);
                    LOGGER.info(file.getName());
                }
            }
            LOGGER.info("------------------------------------------------------------");
        }

        return folders;
    }

    private void analyzeFolders(File file) {
        File[] listFiles = file.listFiles();

        //Is Git Project
        if (GitModule.isProject(file.getPath())) {
            GitModule.executeCommands(file.getName(), file.getPath());
        }

        if (listFiles != null) {

            //Is Maven Project
            if (MavenModule.isProject(listFiles)) {
                MavenModule.executeCommands(file.getName(), file.getPath());
            }

            //Is npm Project
            if (NpmModule.isProject(listFiles)) {
                NpmModule.executeCommands(file.getName(), file.getPath());
            }

            //Is Bower Project
            if (BowerModule.isProject(listFiles)) {
                BowerModule.executeCommands(file.getName(), file.getPath());
            }

            //Is Grunt Project
            if (GruntModule.isProject(listFiles)) {
                GruntModule.executeCommands(file.getName(), file.getPath());
            }
        }
    }

}