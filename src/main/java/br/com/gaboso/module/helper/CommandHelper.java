package br.com.gaboso.module.helper;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Gaboso
 * @since 29/04/2017
 * <p>
 * CommandHelper
 */
public class CommandHelper {

    private CommandHelper(){}

    private static final Logger LOGGER = Logger.getLogger(CommandHelper.class);

    public static void executeCMD(String cmd) {

        boolean isWindows = System.getProperty("os.name").contains("Windows");
        String runner = isWindows ? "cmd.exe" : "/bin/bash";
        String option = isWindows ? "/c" : "-c";

        ProcessBuilder builder = new ProcessBuilder(runner, option, cmd);
        builder.redirectErrorStream(true);

        try {
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while (true) {
                line = r.readLine();
                if (line == null)
                    break;

                LOGGER.info(line);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}