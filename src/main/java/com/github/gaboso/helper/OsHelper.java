package com.github.gaboso.helper;

/**
 * @since 1.3.3
 * Operational System Helper
 */
public class OsHelper {

    private OsHelper() {
    }

    public static String getRunner() {
        return isWindows() ? "cmd.exe" : "/bin/bash";
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").contains("Windows");
    }

    public static String getOption() {
        return isWindows() ? "/c" : "-c";
    }

}