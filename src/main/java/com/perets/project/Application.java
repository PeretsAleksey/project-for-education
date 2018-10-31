package com.perets.project;

import com.perets.project.domain.User;
import com.perets.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private UserService userService;

    @Autowired
    public Application(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(userService.getUserById("2a5d8dae-83a8-43d8-8a6b-294026d63319"));
        System.out.println("---------------------------");
        userService.getUsers(new User()).forEach(System.out::println);
        /*userMapper.getUsers().forEach(System.out::println);
        System.out.println("---------------------------");
        System.out.println(roleMapper.getRoleById(1));
        System.out.println("---------------------------");
        roleMapper.getRoles().forEach(System.out::println);
        System.out.println("---------------------------");
        Role role = new Role();
        role.setId(4);
        role.setName("SOME_ROLE");*/

    }

}
