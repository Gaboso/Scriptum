package com.github.gaboso.module;

import com.github.gaboso.format.Formatter;
import com.github.gaboso.helper.CommandHelper;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * @since 1.0
 * Maven Module
 */
public class MavenModule {

    private MavenModule() {
    }

    public static boolean isProject(File[] listFiles) {
        return Arrays.stream(listFiles)
                     .filter(Objects::nonNull)
                     .filter(file -> !file.isDirectory())
                     .map(File::getName)
                     .anyMatch("pom.xml"::equals);
    }

    public static void executeCommands(String projectName, String projectPath) {
        Formatter formatter = new Formatter("Maven", projectName);

        CommandHelper.executeCMD(projectPath, "mvn clean install -DskipTests=true", formatter);
    }

}
