package com.github.gaboso.module;

import com.github.gaboso.helper.CommandExecutor;
import com.github.gaboso.os.OpSystemEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 1.0
 * Git Module
 */
public class GitModule {

    private static final Logger LOGGER = LogManager.getLogger(GitModule.class.getName());

    private final CommandExecutor commandExecutor;

    public GitModule(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public boolean isProject(String path) {
        OpSystemEnum currentOs = OpSystemEnum.getCurrentOs();
        String runner = currentOs.getRunner();
        String option = currentOs.getOption();

        ProcessBuilder builder = new ProcessBuilder(runner, option, "cd " + path + "/ && git rev-parse --is-inside-work-tree");
        builder.redirectErrorStream(true);

        try {
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();
            return "true".equals(line);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return false;
    }

    public void executeCommands(String projectPath) {
        String command = ModuleTypeEnum.GIT.getCommand();
        commandExecutor.executeCMD(projectPath, command);
    }

}
