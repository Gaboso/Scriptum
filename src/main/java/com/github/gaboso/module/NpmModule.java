package com.github.gaboso.module;

import com.github.gaboso.format.Formatter;
import com.github.gaboso.helper.CommandHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * @since 1.0
 * Npm Module
 */
public class NpmModule {

    private static final Logger LOGGER = LogManager.getLogger(NpmModule.class.getName());
    private static final String NAME = "NPM";

    private NpmModule() {
    }

    public static boolean isProject(File[] listFiles) {
        for (File file : listFiles) {
            if (!file.isDirectory() && "package.json".equals(file.getName())) {
                return true;
            }
        }

        return false;
    }

    public static void executeCommands(String projectName, String projectPath) {
        Formatter formatter = new Formatter(NAME);

        LOGGER.info(formatter.getMessageStartUpdate(projectName));
        CommandHelper.executeCMD("cd " + projectPath + "/ && npm install && npm update");
        LOGGER.info(formatter.getMessageFinishUpdate(projectName));
    }

}
