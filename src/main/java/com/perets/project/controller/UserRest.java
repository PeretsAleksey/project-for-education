package com.perets.project.controller;

import com.perets.project.constant.ErrorMessage;
import com.perets.project.constant.RegexpConstants;
import com.perets.project.domain.User;
import com.perets.project.dto.CreateUserDto;
import com.perets.project.dto.UserDto;
import com.perets.project.service.ExtendedConversionService;
import com.perets.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

@RestController
@Validated
@RequestMapping("/users")
public class UserRest {

    private UserService userService;
    private ExtendedConversionService conversionService;

    @Autowired
    public UserRest(UserService userService, ExtendedConversionService conversionService) {
        this.userService = userService;
        this.conversionService = conversionService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(
            @PathVariable("userId")
            @Pattern(regexp = RegexpConstants.UUID_ID, message = ErrorMessage.USER_ID)
                    String userId) {
        UserDto user = conversionService.convert(userService.getUserById(userId), UserDto.class);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserDto>> getUsers(
            @RequestParam(value = "firstName", required = false)
                    String firstName,
            @RequestParam(value = "lastName", required = false)
                    String lastName,
            @RequestParam(value = "email", required = false)
                    String email,
            @RequestParam(value = "status", required = false)
                    String status,
            @RequestParam(value = "role", required = false)
                    String role) {
        List<UserDto> users = conversionService.convertAll(userService.getUsers(firstName, lastName, email, status, role), UserDto.class);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createUser(
            @RequestBody @Valid CreateUserDto createUserDto) {
        User user = conversionService.convert(createUserDto, User.class);
        return new ResponseEntity<>(userService.addUser(user).getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(
            @PathVariable(value = "userId")
            @Pattern(regexp = RegexpConstants.UUID_ID, message = ErrorMessage.USER_ID)
                    String userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
