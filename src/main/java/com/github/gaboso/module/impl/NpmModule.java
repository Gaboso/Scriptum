package com.github.gaboso.module.impl;

import com.github.gaboso.format.Formatter;
import com.github.gaboso.helper.CommandHelper;
import com.github.gaboso.module.Module;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * @since 1.0
 * Npm Module
 */
public class NpmModule implements Module {

    @Override
    public boolean isProject(File[] listFiles) {
        return Arrays.stream(listFiles)
                     .filter(Objects::nonNull)
                     .filter(file -> !file.isDirectory())
                     .map(File::getName)
                     .anyMatch("package.json"::equals);
    }

    @Override
    public void executeCommands(String projectName, String projectPath) {
        Formatter formatter = new Formatter("NPM", projectName);

        CommandHelper.executeCMD(projectPath, "npm install && npm update", formatter);
    }

}