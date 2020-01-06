package org.guyvernk.db.service;

import org.guyvernk.db.RepoTest;
import org.guyvernk.db.entity.Role;
import org.guyvernk.db.entity.RolesEnum;
import org.guyvernk.db.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
class ReactiveUserServiceTest extends RepoTest {
    @Autowired
    private UserService userService;

    @Test
    void findByUsernameUserExist() {
        Optional<User> user = userService.findByUsername("3");
        assertTrue(user.isPresent());
    }
    @Test
    void findByUsernameUserNotExist() {
        Optional<User> user = userService.findByUsername("-1");
        assertFalse(user.isPresent());
    }
    @Test
    void findByUsernameUserFieldsExist() {
        final String passwordHash = "$2a$10$SKIAYV1lIC9dZk.y2XHPoeeKZT2n15vwZS5Tj4khCCSBV7O8LIRqG";
        Optional<User> user = userService.findByUsername("3");
        assertEquals("3", user.map(User::getUsername).orElse(""));
        assertEquals(passwordHash, user.map(User::getPassword).orElse(""));
        Set<Role> roles = user.map(User::getRoles).orElse(new HashSet<>());
        roles.stream().map(Role::getName)
              .forEach(rolesEnum -> assertEquals(RolesEnum.ROLE_USER,rolesEnum));

    }
}