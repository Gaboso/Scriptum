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
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", cmd);
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