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
class MavenModuleTest {

    @Mock
    CommandExecutor commandExecutor;

    @InjectMocks
    MavenModule mavenModule;

    @Test
    void isProject_WithValidFile_ReturnsTrue() throws NullPointerException {
        File pomXml = new File(getClass().getResource("/valid/maven/pom.xml").getFile());
        File[] listFiles = {pomXml};
        boolean result = mavenModule.isProject(listFiles);
        Assertions.assertTrue(result);
    }

    @Test
    void isProject_WithInvalidFile_ReturnsFalse() throws NullPointerException {
        File file = new File(getClass().getResource("/invalid/image.jpg").getFile());
        File[] listFiles = {file};
        boolean result = mavenModule.isProject(listFiles);
        Assertions.assertFalse(result);
    }

    @Test
    void executeCommands_ShouldCallCommandExecutor() {
        mavenModule.executeCommands("myProjectUsingMavenPath");

        Mockito.verify(commandExecutor, Mockito.times(1))
            .executeCMD("myProjectUsingMavenPath", ModuleTypeEnum.MAVEN.getCommand());
    }

    @Test
    void getType_ReturnsMaven() {
        ModuleTypeEnum type = mavenModule.getType();
        Assertions.assertEquals(ModuleTypeEnum.MAVEN, type);
    }

}