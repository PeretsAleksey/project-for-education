package com.perets.project.domain;

import java.util.Arrays;

public enum Role {

    ADMIN(1, "Admin"), MANAGER(2, "Manager"), USER(3, "User");

    private final Integer position;
    private final String name;

    Role(Integer position, String name) {
        this.position = position;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public static Role getRole(String role) {
        return Arrays.stream(Role.values())
                .filter(complexity -> complexity.getName().equalsIgnoreCase(role))
                .findFirst()
                .orElse(null);
    }
}
