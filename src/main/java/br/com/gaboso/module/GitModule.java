package br.com.gaboso.module;

import br.com.gaboso.format.Formatter;
import br.com.gaboso.module.helper.CommandHelper;
import br.com.gaboso.module.helper.OsHelper;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Gaboso
 * @since 29/04/2017
 * <p>GitModule</p>
 */
public class GitModule {

    private static final Logger LOGGER = Logger.getLogger(GitModule.class);
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