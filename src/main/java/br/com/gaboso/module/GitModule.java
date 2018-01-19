package br.com.gaboso.module;

import br.com.gaboso.format.Formatter;
import br.com.gaboso.module.helper.CommandHelper;
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
        boolean isWindows = System.getProperty("os.name").contains("Windows");
        String runner = isWindows ? "cmd.exe" : "/bin/bash";
        String option = isWindows ? "/c" : "-c";

        ProcessBuilder builder = new ProcessBuilder(runner, option, "cd " + path + "/ && git rev-parse --is-inside-work-tree");
        builder.redirectErrorStream(true);

        try {
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = r.readLine();
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