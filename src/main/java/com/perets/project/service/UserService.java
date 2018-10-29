package com.perets.project.service;

import com.perets.project.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    String addUser(User user);

    Page<User> findAllUsers(String fullNameOrEmail, Pageable pageable);

    void deleteUser(String userId);

    User getUserById(String userId);
}
