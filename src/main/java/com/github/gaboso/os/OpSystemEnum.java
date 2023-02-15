package com.github.gaboso.os;

/**
 * @since 3.0.0
 * OpSystemEnum
 */
public enum OpSystemEnum {

    WINDOWS("cmd.exe", "/c"),
    LINUX("/bin/bash", "-c");

    private final String runner;
    private final String option;

    OpSystemEnum(String runner, String option) {
        this.runner = runner;
        this.option = option;
    }

    public String getRunner() {
        return runner;
    }

    public String getOption() {
        return option;
    }

    public static OpSystemEnum getCurrentOs() {
        return System.getProperty("os.name").contains("Windows") ? WINDOWS : LINUX;
    }

}