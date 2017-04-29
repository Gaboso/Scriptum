package br.com.gaboso.module;

import br.com.gaboso.module.helper.CommandHelper;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Gaboso
 * @since 29/04/2017
 * <p>
 * GitModule
 */
public class GitModule {

    private static final Logger LOGGER = Logger.getLogger(GitModule.class);

    private GitModule() {
    }

    public static boolean isProject(String path) {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd " + path + "\\ && git rev-parse --is-inside-work-tree");
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
        LOGGER.info("Updating Git Project --- " + projectName);
        CommandHelper.executeCMD("cd " + projectPath + "\\ && git fetch && git pull origin");
    }

}