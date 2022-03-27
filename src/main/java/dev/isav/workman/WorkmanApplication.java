package dev.isav.workman;

import dev.isav.workman.entity.user.Gender;
import dev.isav.workman.entity.user.RoleEntity;
import dev.isav.workman.entity.user.UserEntity;
import dev.isav.workman.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WorkmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkmanApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
          userService.saveRole(new RoleEntity("ROLE_USER"));
          userService.saveRole(new RoleEntity("ROLE_ADMIN"));
          userService.saveRole(new RoleEntity("ROLE_MODERATOR"));
          userService.saveRole(new RoleEntity("ROLE_MANAGER"));


          userService.saveUser(new UserEntity("Alex", "qwerty", "7896541236", Gender.MALE, new ArrayList<>()));
          userService.saveUser(new UserEntity("Masha", "pass123", "1231414445", Gender.FEMALE, new ArrayList<>()));
          userService.saveUser(new UserEntity("Petr", "qazwsxedc", "7896541123", Gender.MALE, new ArrayList<>()));

          userService.addRoleToUser("Alex", "ROLE_USER");
          userService.addRoleToUser("Masha", "ROLE_ADMIN");
          userService.addRoleToUser("Petr", "ROLE_MANAGER");
          userService.addRoleToUser("Petr", "ROLE_USER");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
