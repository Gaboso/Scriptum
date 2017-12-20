package br.com.gaboso.module;

import br.com.gaboso.module.helper.CommandHelper;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * @author Gaboso
 * @since 29/04/2017
 * <p>
 * MavenModule
 */
public class MavenModule {

    private static final Logger LOGGER = Logger.getLogger(MavenModule.class);

    private MavenModule() {
    }

    public static boolean isProject(File[] listFiles) {
        for (File file : listFiles) {
            if (!file.isDirectory() && "pom.xml".equals(file.getName()))
                return true;
        }

        return false;
    }

    public static void executeCommands(String projectName, String projectPath) {
        LOGGER.info("Updating Maven Project --- " + projectName);
        CommandHelper.executeCMD("cd " + projectPath + "/ && mvn clean install -DskipTests=true");
    }

}