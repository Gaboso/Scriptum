package com.github.gaboso.helper;

import com.github.gaboso.Scriptum;
import org.apache.log4j.Logger;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    private static final Logger LOGGER = Logger.getLogger(FileHelper.class);

    private FileHelper() {
    }

    public static String getJarDir() {
        CodeSource codeSource = Scriptum.class.getProtectionDomain().getCodeSource();

        try {
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            return jarFile.getParentFile().getPath();
        } catch (URISyntaxException | NullPointerException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return "";
    }

    public static List<File> getFoldersFromWorkspace(String path) {
        File fileInitial = new File(path);
        File[] listFiles = fileInitial.listFiles();
        List<File> folders = new ArrayList<>();

        if (listFiles != null) {
            LOGGER.info("------------- LISTA DE DIRETORIOS DO WORKSPACE -------------");
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    folders.add(file);
                    LOGGER.info(file.getName());
                }
            }
            LOGGER.info("------------------------------------------------------------");
        }

        return folders;
    }

}
