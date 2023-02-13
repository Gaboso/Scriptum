package com.github.gaboso.module.impl;

import com.github.gaboso.helper.CommandExecutor;
import com.github.gaboso.module.Module;
import com.github.gaboso.module.ModuleTypeEnum;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * @since 1.0
 * Npm Module
 */
public class NpmModule implements Module {

    private final CommandExecutor commandExecutor;

    public NpmModule(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public boolean isProject(File[] listFiles) {
        return Arrays.stream(listFiles)
            .filter(Objects::nonNull)
            .filter(file -> !file.isDirectory())
            .map(File::getName)
            .anyMatch("package.json"::equals);
    }

    @Override
    public void executeCommands(String projectPath) {
        String command = this.getType().getCommand();
        commandExecutor.executeCMD(projectPath, command);
    }

    @Override
    public ModuleTypeEnum getType() {
        return ModuleTypeEnum.NPM;
    }

}
