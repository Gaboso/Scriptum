package com.github.gaboso.helper;

import com.github.gaboso.os.OpSystemEnum;
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

    private static final Logger LOGGER = LogManager.getLogger(CommandHelper.class.getName());

    private CommandHelper() {
    }

    public static void executeCMD(String path, String cmd) {
        OpSystemEnum currentOs = OpSystemEnum.getCurrentOs();
        String runner = currentOs.getRunner();
        String option = currentOs.getOption();

        String command = "cd " + path + "/ && " + cmd;

        ProcessBuilder builder = new ProcessBuilder(runner, option, command);
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
