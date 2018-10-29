package com.perets.project.service.impl;

import com.perets.project.constant.ErrorMessage;
import com.perets.project.domain.User;
import com.perets.project.persistence.UserElasticRepository;
import com.perets.project.persistence.UserMongoRepository;
import com.perets.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserMongoRepository userMongoRepository;
    private UserElasticRepository userElasticRepository;
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    public UserServiceImpl(UserMongoRepository userMongoRepository, UserElasticRepository userElasticRepository, ElasticsearchOperations elasticsearchOperations) {
        this.userMongoRepository = userMongoRepository;
        this.userElasticRepository = userElasticRepository;
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @Override
    public String addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setDateAdded(Date.from(new Date().toInstant()));
        userMongoRepository.save(user);
        return user.getId();
    }

    @Override
    public Page<User> findAllUsers(String fullNameOrEmail, Pageable pageable) {
        /*QueryBuilders.regexpQuery("fullName", fullNameOrEmail).

        if (StringUtils.isNotBlank(fullNameOrEmail)) {

        }
        return elasticsearchOperations.queryForPage(searchQuery, User.class);*/
        return new PageImpl<>(Collections.emptyList());
    }

    @Override
    public void deleteUser(String userId) {
        if (!userMongoRepository.existsById(userId)) {
            throw new IllegalArgumentException(ErrorMessage.USER_DOES_NOT_EXIST);
        }
        userMongoRepository.deleteById(userId);
    }

    @Override
    public User getUserById(String userId) {
        return userMongoRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.USER_DOES_NOT_EXIST));
    }
}
