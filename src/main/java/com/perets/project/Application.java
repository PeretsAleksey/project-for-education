package com.perets.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {/*implements CommandLineRunner {

    private UserService userService;

    @Autowired
    public Application(UserService userService) {
        this.userService = userService;
    }
*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   /* @Override
    public void run(String... args) {
        System.out.println(userService.getUserById("2a5d8dae-83a8-43d8-8a6b-294026d63319"));
        System.out.println("---------------------------");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("lastName", "Peret");
        userService.getUsers(parameters).forEach(System.out::println);
    }*/
}
