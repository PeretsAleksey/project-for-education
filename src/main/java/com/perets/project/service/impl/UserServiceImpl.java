package com.perets.project.service.impl;

import com.perets.project.constant.ErrorMessage;
import com.perets.project.domain.User;
import com.perets.project.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {

    private SqlSession session;

    @Autowired
    public UserServiceImpl(SqlSession session) {
        this.session = session;
    }

    @Override
    public User getUserById(String id) {
        User user = session.selectOne("getUserById", id);
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException(ErrorMessage.USER_WITH_SPECIFIED_ID_DOES_NOT_EXIST);
        }
        return user;
    }

    @Override
    public List<User> getUsers(User user) {
        List<User> users = session.selectList("getUsers", user);
        if (CollectionUtils.isEmpty(users)) {
            throw new IllegalArgumentException(ErrorMessage.THERE_ARE_NOT_USERS_WITH_SUCH_PARAMETERS);
        }
        return users;
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return null;
    }

    @Override
    public Integer addUser(User user) {
        return null;
    }
}
