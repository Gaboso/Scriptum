package com.github.gaboso.module.impl;

import com.github.gaboso.helper.CommandHelper;
import com.github.gaboso.module.Module;
import com.github.gaboso.module.ModuleTypeEnum;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * @since 1.0
 * Bower Module
 */
public class BowerModule implements Module {

    @Override
    public boolean isProject(File[] listFiles) {
        return Arrays.stream(listFiles)
            .filter(Objects::nonNull)
            .filter(file -> !file.isDirectory())
            .map(File::getName)
            .anyMatch("bower.json"::equals);
    }

    @Override
    public void executeCommands(String projectPath) {
        String command = this.getType().getCommand();
        CommandHelper.executeCMD(projectPath, command);
    }

    @Override
    public ModuleTypeEnum getType() {
        return ModuleTypeEnum.BOWER;
    }

}
