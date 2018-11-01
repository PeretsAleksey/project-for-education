package com.perets.project.mapper;

import com.perets.project.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    User getUserById(@Param("id") String id);

    List<User> getUsers(Map<String, Object> parameters);

    void deleteUserById(@Param("id") Integer id);

    void addUser(User user);

}
