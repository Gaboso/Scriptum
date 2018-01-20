package br.com.gaboso.helper;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Gaboso
 * @since 29/04/2017
 * <p>
 * <p>CommandHelper</p>
 */
public class CommandHelper {

    private CommandHelper() {
    }

    private static final Logger LOGGER = Logger.getLogger(CommandHelper.class);

    public static void executeCMD(String cmd) {
        String runner = OsHelper.getRunner();
        String option = OsHelper.getOption();

        ProcessBuilder builder = new ProcessBuilder(runner, option, cmd);
        builder.redirectErrorStream(true);

        try {
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while (true) {
                String line = reader.readLine();

                if (line == null) {
                    break;
                }

                LOGGER.info(line);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}