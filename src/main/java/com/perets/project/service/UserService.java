package com.perets.project.service;

import com.perets.project.domain.User;

import java.util.List;

public interface UserService {

    User getUserById(String id);

    List<User> getUsers(String firstName, String lastName, String email, String status, String role);

    void deleteUserById(String id);

    User addUser(User user);

}
