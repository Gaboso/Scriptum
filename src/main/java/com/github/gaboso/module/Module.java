package com.github.gaboso.module;

import java.io.File;

public interface Module {

    boolean isProject(File[] listFiles);

    void executeCommands(String projectName, String projectPath);

}
