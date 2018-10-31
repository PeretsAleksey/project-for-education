package com.perets.project.service;

import com.perets.project.domain.User;

import java.util.List;

public interface UserService {

    User getUserById(String id);

    List<User> getUsers(User user);

    Integer deleteUserById(Integer id);

    Integer addUser(User user);

}
