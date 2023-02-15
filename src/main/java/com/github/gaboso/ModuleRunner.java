package com.github.gaboso;

import com.github.gaboso.helper.CommandExecutor;
import com.github.gaboso.module.GitModule;
import com.github.gaboso.module.Module;
import com.github.gaboso.module.ModuleTypeEnum;
import com.github.gaboso.module.impl.BowerModule;
import com.github.gaboso.module.impl.GruntModule;
import com.github.gaboso.module.impl.MavenModule;
import com.github.gaboso.module.impl.NpmModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @since 2.0.0
 * ModuleRunner
 */
public class ModuleRunner {

    private static final Logger LOGGER = LogManager.getLogger(ModuleRunner.class.getName());

    private final GitModule gitModule;

    private final List<Module> modules;

    public ModuleRunner() {
        CommandExecutor commandExecutor = new CommandExecutor();

        this.gitModule = new GitModule(commandExecutor);

        this.modules = Arrays.asList(
            new BowerModule(commandExecutor),
            new GruntModule(commandExecutor),
            new MavenModule(commandExecutor),
            new NpmModule(commandExecutor)
        );
    }

    public void runAll(List<File> folders) {
        folders.forEach(this::run);
    }

    public void run(File folder) {
        String path = folder.getPath();
        String folderName = folder.getName();

        if (gitModule.isProject(path)) {
            String typeName = ModuleTypeEnum.GIT.getTypeName();
            printStartMessage(typeName, folderName);
            gitModule.executeCommands(path);
            printFinishMessage(typeName, folderName);
        }

        File[] listFiles = folder.listFiles();
        if (listFiles == null) {
            return;
        }

        modules.stream()
            .filter(module -> module.isProject(listFiles))
            .forEach(module -> {
                String typeName = module.getType().getTypeName();
                printStartMessage(typeName, folderName);
                module.executeCommands(path);
                printFinishMessage(typeName, folderName);
            });
    }

    private void printStartMessage(String typeName, String folderName) {
        LOGGER.info("--------- Starting update {} --- [ {} ] ---------", typeName, folderName);
    }

    private void printFinishMessage(String typeName, String folderName) {
        LOGGER.info("--------- Finished update {} --- [ {} ] ---------", typeName, folderName);
    }

}
