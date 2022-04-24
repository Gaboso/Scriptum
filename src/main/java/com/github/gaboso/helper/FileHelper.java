package com.github.gaboso.helper;

import com.github.gaboso.Scriptum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @since 1.3.3
 * File Helper
 */
public class FileHelper {

    private static final Logger LOGGER = LogManager.getLogger(FileHelper.class.getName());

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

        if (listFiles == null) {
            return folders;
        }

        LOGGER.info("---------------- LIST OF DIRECTORIES FOUND ----------------");
        Arrays.stream(listFiles)
              .filter(Objects::nonNull)
              .filter(File::isDirectory)
              .forEach(folder -> {
                  folders.add(folder);
                  LOGGER.info(folder.getName());
              });
        LOGGER.info("------------------------------------------------------------");

        return folders;
    }

}
