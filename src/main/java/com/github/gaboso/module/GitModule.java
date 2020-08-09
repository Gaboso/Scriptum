package com.github.gaboso.module;

import com.github.gaboso.format.Formatter;
import com.github.gaboso.helper.CommandHelper;
import com.github.gaboso.helper.OsHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 1.0
 * Git Module
 */
public class GitModule {

    private static final Logger LOGGER = LogManager.getLogger(GitModule.class.getName());
    private static final String NAME = "Git";

    private GitModule() {
    }

    public static boolean isProject(String path) {
        String runner = OsHelper.getRunner();
        String option = OsHelper.getOption();

        ProcessBuilder builder = new ProcessBuilder(runner, option, "cd " + path + "/ && git rev-parse --is-inside-work-tree");
        builder.redirectErrorStream(true);

        try {
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();
            return "true".equals(line);

        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return false;
    }

    public static void executeCommands(String projectName, String projectPath) {
        Formatter formatter = new Formatter(NAME);

        LOGGER.info(formatter.getMessageStartUpdate(projectName));
        CommandHelper.executeCMD("cd " + projectPath + "/ && git fetch && git pull origin");
        LOGGER.info(formatter.getMessageFinishUpdate(projectName));
    }

}
