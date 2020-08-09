package com.github.gaboso.module;

import com.github.gaboso.format.Formatter;
import com.github.gaboso.helper.CommandHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * @since 1.0
 * Grunt Module
 */
public class GruntModule {

    private static final Logger LOGGER = LogManager.getLogger(GruntModule.class.getName());
    private static final String NAME = "Grunt";

    private GruntModule() {
    }

    public static boolean isProject(File[] listFiles) {
        for (File file : listFiles) {
            if (!file.isDirectory() && "gruntfile.js".equalsIgnoreCase(file.getName())) {
                return true;
            }
        }

        return false;
    }

    public static void executeCommands(String projectName, String projectPath) {
        Formatter formatter = new Formatter(NAME);

        LOGGER.info(formatter.getMessageStartUpdate(projectName));
        CommandHelper.executeCMD("cd " + projectPath + "/ && grunt");
        LOGGER.info(formatter.getMessageFinishUpdate(projectName));
    }

}
