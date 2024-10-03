package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Component
public class UsersInitializer {


    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public UsersInitializer( RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    @PostConstruct
    public void init() {

        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");
        roleService.saveRole(adminRole);
        roleService.saveRole(userRole);

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminRoles.add(userRole);

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);


        User adminUser = new User("admin", "admin", "admin@admin.com",2002 , adminRoles);
        User user = new User("user", "user", "user@admin.com",1999 , userRoles);
        userService.saveUser(adminUser);
        userService.saveUser(user);
    }
}
