package com.github.gaboso.module;

import com.github.gaboso.format.Formatter;
import com.github.gaboso.helper.CommandHelper;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * @author Gaboso
 * @since 12/06/2017
 * <p>GruntModule</p>
 */
public class GruntModule {

    private static final Logger LOGGER = Logger.getLogger(GruntModule.class);
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