package com.example.userservice.api;

import com.example.userservice.model.Role;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserService userService){
        return args -> {

            //Add Roles
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            //Add Users
            userService.saveUser(new User(null, "James Kanyi", "James", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "Benja Nyakeri", "Benjamin", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "Daniel Magige", "Daniel", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "Fred Marube", "Fred", "password", new ArrayList<>()));

            //Add role to user
            userService.addRoleToUser("James","ROLE_USER");
            userService.addRoleToUser("James","ROLE_MANAGER");
            userService.addRoleToUser("James","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("Benjamin","ROLE_MANAGER");

            userService.addRoleToUser("Daniel","ROLE_ADMIN");
            userService.addRoleToUser("Fred","ROLE_SUPER_ADMIN");

        };

    }

    //Spring inversion of Control container: Is part of the core of spring framework responsible for managing all the beans,
    // perform dependency injection

    //A bean is basically an instance of a class managed by a spring container
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
