package br.com.gaboso.format;

public class Formatter {

    private String type;

    public Formatter(String type) {
        this.type = type;
    }

    public String getMessageStartUpdate(String projectName) {
        return String.format("Updating %s project --- [ %s ]", type, projectName);
    }

    public String getMessageFinishUpdate(String projectName) {
        return String.format("Finish update %s project --- [ %s ]", type, projectName);
    }

}
