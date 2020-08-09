package com.github.gaboso.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 1.0
 * Command Helper
 */
public class CommandHelper {

    private CommandHelper() {
    }

    private static final Logger LOGGER = LogManager.getLogger(CommandHelper.class.getName());

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
