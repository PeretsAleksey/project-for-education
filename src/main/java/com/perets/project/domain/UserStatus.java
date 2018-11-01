package com.perets.project.domain;

public enum UserStatus {

    ACTIVE("Active"), INACTIVE("Inactive");

    private String name;

    UserStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
