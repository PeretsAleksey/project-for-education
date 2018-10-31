package com.perets.project.mapper;

import com.perets.project.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserById(@Param("id") String id);

    List<User> getUsers(User user);

    void deleteUserById(@Param("id") Integer id);

    void addUser(User user);

}
