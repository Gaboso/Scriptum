package com.github.gaboso.module.impl;

import com.github.gaboso.helper.CommandExecutor;
import com.github.gaboso.module.ModuleTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

@ExtendWith(MockitoExtension.class)
class NpmModuleTest {

    @Mock
    CommandExecutor commandExecutor;

    @InjectMocks
    NpmModule npmModule;

    @Test
    void isProject_WithValidFile_ReturnsTrue() throws NullPointerException {
        File packageJson = new File(getClass().getResource("/valid/npm/package.json").getFile());
        File[] listFiles = {packageJson};
        boolean result = npmModule.isProject(listFiles);
        Assertions.assertTrue(result);
    }

    @Test
    void isProject_WithInvalidFile_ReturnsFalse() throws NullPointerException {
        File file = new File(getClass().getResource("/invalid/image.jpg").getFile());
        File[] listFiles = {file};
        boolean result = npmModule.isProject(listFiles);
        Assertions.assertFalse(result);
    }

    @Test
    void executeCommands_ShouldCallCommandExecutor() {
        npmModule.executeCommands("myProjectUsingNpmPath");

        Mockito.verify(commandExecutor, Mockito.times(1))
            .executeCMD("myProjectUsingNpmPath", ModuleTypeEnum.NPM.getCommand());
    }

    @Test
    void getType_ReturnsNpm() {
        ModuleTypeEnum type = npmModule.getType();
        Assertions.assertEquals(ModuleTypeEnum.NPM, type);
    }

}