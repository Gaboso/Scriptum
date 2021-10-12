package com.github.gaboso.format;

public class Formatter {

    private final String type;
    private final String projectName;

    public Formatter(String type, String projectName) {
        this.type = type;
        this.projectName = projectName;
    }

    public String getMessageStartUpdate() {
        return String.format("Updating %s project --- [ %s ]", type, projectName);
    }

    public String getMessageFinishUpdate() {
        return String.format("Finish update %s project --- [ %s ]", type, projectName);
    }

}