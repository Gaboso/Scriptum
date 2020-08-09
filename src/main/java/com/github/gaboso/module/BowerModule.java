package com.github.gaboso.module;

import com.github.gaboso.format.Formatter;
import com.github.gaboso.helper.CommandHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * @since 1.0
 * Bower Module
 */
public class BowerModule {

    private static final Logger LOGGER = LogManager.getLogger(BowerModule.class.getName());
    private static final String NAME = "Bower";

    private BowerModule() {
    }

    public static boolean isProject(File[] listFiles) {
        for (File file : listFiles) {
            if (!file.isDirectory() && "bower.json".equals(file.getName())) {
                return true;
            }
        }

        return false;
    }

    public static void executeCommands(String projectName, String projectPath) {
        Formatter formatter = new Formatter(NAME);

        LOGGER.info(formatter.getMessageStartUpdate(projectName));
        CommandHelper.executeCMD("cd " + projectPath + "/ && bower install && bower update");
        LOGGER.info(formatter.getMessageFinishUpdate(projectName));
    }

}
