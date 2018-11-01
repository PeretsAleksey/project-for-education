package com.perets.project.service.impl;

import com.perets.project.constant.ErrorMessage;
import com.perets.project.domain.Role;
import com.perets.project.domain.User;
import com.perets.project.domain.UserStatus;
import com.perets.project.service.UserService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    private SqlSessionTemplate session;

    @Autowired
    public UserServiceImpl(SqlSessionTemplate session) {
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
    public List<User> getUsers(String firstName, String lastName, String email, String status, String role) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("firstName", firstName);
        parameters.put("lastName", lastName);
        parameters.put("email", email);
        parameters.put("status", status);
        parameters.put("role", Role.getRole(role));
        List<User> users = session.selectList("getUsers", parameters);
        if (CollectionUtils.isEmpty(users)) {
            throw new IllegalArgumentException(ErrorMessage.THERE_ARE_NOT_USERS_WITH_SUCH_PARAMETERS);
        }
        return users;
    }

    @Transactional
    @Override
    public User addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setStatus(UserStatus.ACTIVE);
        user.setDateAdded(Date.from(ZonedDateTime.now().toInstant()));
        session.insert("addUser", user);
        return user;
    }

    @Transactional
    @Override
    public void deleteUserById(String id) {
        session.delete("deleteUserById", id);
    }

}
