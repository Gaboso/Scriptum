package com.github.gaboso.module;

/**
 * @since 3.0.0
 * ModuleTypeEnum
 */
public enum ModuleTypeEnum {

    MAVEN("Maven", "mvn clean install -DskipTests=true"),
    GRUNT("Grunt", "grunt"),
    BOWER("Bower", "bower install && bower update"),
    NPM("NPM", "npm install && npm update"),
    GIT("Git", "git fetch && git pull origin");

    private final String typeName;
    private final String command;

    ModuleTypeEnum(String name, String command) {
        this.typeName = name;
        this.command = command;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getCommand() {
        return command;
    }
}
