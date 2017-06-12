package br.com.gaboso.module;

import br.com.gaboso.module.helper.CommandHelper;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * @author Gaboso
 * @since 12/06/2017
 * <p>
 * GruntModule
 */
public class GruntModule {

    private static final Logger LOGGER = Logger.getLogger(GruntModule.class);

    private GruntModule() {
    }

    public static boolean isProject(File[] listFiles) {
        for (File file : listFiles) {
            if (!file.isDirectory() && "gruntfile.js".equals(file.getName()))
                return true;
        }

        return false;
    }

    public static void executeCommands(String projectName, String projectPath) {
        LOGGER.info("Updating GRUNT Project --- " + projectName);
        CommandHelper.executeCMD("cd " + projectPath + "\\ && grunt");
    }

}