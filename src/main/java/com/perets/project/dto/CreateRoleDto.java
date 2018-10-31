package com.perets.project.dto;

import javax.validation.constraints.NotNull;

public class CreateRoleDto {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
}
