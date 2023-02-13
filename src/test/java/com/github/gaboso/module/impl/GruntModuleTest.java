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
class GruntModuleTest {

    @Mock
    CommandExecutor commandExecutor;

    @InjectMocks
    GruntModule gruntModule;

    @Test
    void isProject_WithValidFile_ReturnsTrue() throws NullPointerException {
        File gruntfileJs = new File(getClass().getResource("/valid/grunt/gruntfile.js").getFile());
        File[] listFiles = {gruntfileJs};
        boolean result = gruntModule.isProject(listFiles);
        Assertions.assertTrue(result);
    }

    @Test
    void isProject_WithInvalidFile_ReturnsFalse() throws NullPointerException {
        File file = new File(getClass().getResource("/invalid/image.jpg").getFile());
        File[] listFiles = {file};
        boolean result = gruntModule.isProject(listFiles);
        Assertions.assertFalse(result);
    }

    @Test
    void executeCommands_ShouldCallCommandExecutor() {
        gruntModule.executeCommands("myProjectUsingGruntPath");

        Mockito.verify(commandExecutor, Mockito.times(1))
            .executeCMD("myProjectUsingGruntPath", ModuleTypeEnum.GRUNT.getCommand());
    }

    @Test
    void getType_ReturnsGrunt() {
        ModuleTypeEnum type = gruntModule.getType();
        Assertions.assertEquals(ModuleTypeEnum.GRUNT, type);
    }

}