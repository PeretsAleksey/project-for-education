package com.perets.project.controller;

import com.perets.project.constant.ErrorMessage;
import com.perets.project.constant.RegexpConstants;
import com.perets.project.constant.RestParameters;
import com.perets.project.domain.User;
import com.perets.project.dto.CreateUserDto;
import com.perets.project.dto.PageDto;
import com.perets.project.dto.UserDto;
import com.perets.project.service.ExtendedConversionService;
import com.perets.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/users")
@Validated
public class UserRest {

    private UserService userService;
    private ExtendedConversionService converter;

    @Autowired
    public UserRest(UserService userService, ExtendedConversionService converter) {
        this.userService = userService;
        this.converter = converter;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addUser(@Valid @RequestBody CreateUserDto createUserDto) {
        User user = converter.convert(createUserDto, User.class);
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDto> getUserById(
            @PathVariable
            @Pattern(regexp = RegexpConstants.UUID_ID, message = ErrorMessage.INCORRECT_USER_ID)
                    String userId) {
        return new ResponseEntity<>(converter.convert(userService.getUserById(userId), UserDto.class), HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<PageDto<UserDto>> findAllUsers(
            @RequestParam(value = RestParameters.FULL_NAME_OR_EMAIL, required = false)
            @Pattern(regexp = RegexpConstants.SEARCH_QUERY_LATIN_MAX_35_OR_EMPTY, message = ErrorMessage.INCORRECT_USER_NAME_OR_EMAIL)
                    String fullNameOrEmail,
            @SortDefault(sort = "fullName", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<User> users = userService.findAllUsers(fullNameOrEmail, pageable);
        PageDto<UserDto> usersPage = converter.convertPage(users, UserDto.class);
        return new ResponseEntity<>(usersPage, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity deleteUserById(
            @PathVariable
            @Pattern(regexp = RegexpConstants.UUID_ID, message = ErrorMessage.INCORRECT_USER_ID)
                    String userId) {
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
