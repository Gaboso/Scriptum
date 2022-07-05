package com.github.gaboso;

import com.github.gaboso.module.GitModule;
import com.github.gaboso.module.Module;
import com.github.gaboso.module.impl.BowerModule;
import com.github.gaboso.module.impl.GruntModule;
import com.github.gaboso.module.impl.MavenModule;
import com.github.gaboso.module.impl.NpmModule;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @since 2.0.0
 * ModuleRunner
 */
public class ModuleRunner {

    private final List<Module> modules;

    public ModuleRunner() {
        Module bowerModule = new BowerModule();
        Module gruntModule = new GruntModule();
        Module mavenModule = new MavenModule();
        Module npmModule = new NpmModule();
        modules = Arrays.asList(bowerModule, gruntModule, mavenModule, npmModule);
    }

    public void runAll(List<File> folders) {
        for (File folder : folders) {
            run(folder);
        }
    }

    public void run(File folder) {
        String path = folder.getPath();
        String folderName = folder.getName();

        if (GitModule.isProject(path)) {
            GitModule.executeCommands(folderName, path);
        }

        File[] listFiles = folder.listFiles();
        if (listFiles == null) {
            return;
        }

        for (Module module : modules) {
            if (module.isProject(listFiles)) {
                module.executeCommands(folderName, path);
            }
        }
    }

}
