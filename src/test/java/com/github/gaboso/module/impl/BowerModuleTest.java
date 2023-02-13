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
class BowerModuleTest {

    @Mock
    CommandExecutor commandExecutor;

    @InjectMocks
    BowerModule bowerModule;

    @Test
    void isProject_WithValidFile_ReturnsTrue() throws NullPointerException {
        File bowerJson = new File(getClass().getResource("/valid/bower/bower.json").getFile());
        File[] listFiles = {bowerJson};
        boolean result = bowerModule.isProject(listFiles);
        Assertions.assertTrue(result);
    }

    @Test
    void isProject_WithInvalidFile_ReturnsFalse() throws NullPointerException {
        File file = new File(getClass().getResource("/invalid/image.jpg").getFile());
        File[] listFiles = {file};
        boolean result = bowerModule.isProject(listFiles);
        Assertions.assertFalse(result);
    }

    @Test
    void executeCommands_ShouldCallCommandExecutor() {
        bowerModule.executeCommands("myProjectUsingBowerPath");

        Mockito.verify(commandExecutor, Mockito.times(1))
            .executeCMD("myProjectUsingBowerPath", ModuleTypeEnum.BOWER.getCommand());
    }

    @Test
    void getType_ReturnsBower() {
        ModuleTypeEnum result = bowerModule.getType();
        Assertions.assertEquals(ModuleTypeEnum.BOWER, result);
    }

}