package com.perets.project.mapper;

public interface UserMapper {

    void insertUser(User user);
    User findUserById(Integer id);
    List<User> findAllUsers();

}
