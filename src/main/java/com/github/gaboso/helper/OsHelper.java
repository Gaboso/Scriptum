package com.github.gaboso.helper;

public class OsHelper {

    private OsHelper() {
    }

    public static String getRunner() {
        return isWindows() ? "cmd.exe" : "/bin/bash";
    }

    public static String getOption() {
        return isWindows() ? "/c" : "-c";
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").contains("Windows");
    }

}
