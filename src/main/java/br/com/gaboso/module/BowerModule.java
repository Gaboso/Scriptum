package br.com.gaboso.module;

import br.com.gaboso.module.helper.CommandHelper;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * @author Gaboso
 * @since 29/04/2017
 * <p>
 * BowerModule
 */
public class BowerModule {

    private static final Logger LOGGER = Logger.getLogger(BowerModule.class);

    private BowerModule() {
    }

    public static boolean isProject(File[] listFiles) {
        for (File file : listFiles) {
            if (!file.isDirectory() && "bower.json".equals(file.getName()))
                return true;
        }

        return false;
    }

    public static void executeCommands(String projectName, String projectPath) {
        LOGGER.info("Updating Bower Project --- " + projectName);
        CommandHelper.executeCMD("cd " + projectPath + "\\ && bower install && bower update");
    }

}