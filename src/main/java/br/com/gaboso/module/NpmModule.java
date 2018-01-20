package br.com.gaboso.module;

import br.com.gaboso.format.Formatter;
import br.com.gaboso.helper.CommandHelper;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * @author Gaboso
 * @since 29/04/2017
 * <p>NpmModule</p>
 */
public class NpmModule {

    private static final Logger LOGGER = Logger.getLogger(NpmModule.class);
    private static final String NAME = "NPM";

    private NpmModule() {
    }

    public static boolean isProject(File[] listFiles) {
        for (File file : listFiles) {
            if (!file.isDirectory() && "package.json".equals(file.getName())) {
                return true;
            }
        }

        return false;
    }

    public static void executeCommands(String projectName, String projectPath) {
        Formatter formatter = new Formatter(NAME);

        LOGGER.info(formatter.getMessageStartUpdate(projectName));
        CommandHelper.executeCMD("cd " + projectPath + "/ && npm install && npm update");
        LOGGER.info(formatter.getMessageFinishUpdate(projectName));
    }

}