package com.examserver;

import com.examserver.helper.UserFoundException;
import com.examserver.model.Role;
import com.examserver.model.User;
import com.examserver.model.UserRole;
import com.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ExamserverApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("start");

        /*  try {
            User user = new User();

            user.setFirstName("Alexandra");
            user.setLastName("Paziy");
            user.setUsername("alexandrapaziy");
            user.setPassword(this.bCryptPasswordEncoder.encode("pass"));
            user.setEmail("alexandrapaziy@gmail.com");
            user.setPhone("93 617 81 50");
            user.setProfile("default.png");

            Role role = new Role();
            role.setRoleId(44L);
            role.setRoleName("ADMIN");

            Set<UserRole> userRoleSet = new HashSet<>();

            UserRole userRole = new UserRole();
            userRole.setRole(role);
            userRole.setUser(user);

            userRoleSet.add(userRole);

            User finalUser = this.userService.createUser(user, userRoleSet);
            System.out.println(finalUser.getUsername());
        } catch (UserFoundException exception) {
            exception.printStackTrace();
        }  */
    }

}
