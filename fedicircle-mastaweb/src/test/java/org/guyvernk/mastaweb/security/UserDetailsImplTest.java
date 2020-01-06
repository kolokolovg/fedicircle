package org.guyvernk.mastaweb.security;

import org.guyvernk.db.entity.Role;
import org.guyvernk.db.entity.RolesEnum;
import org.guyvernk.db.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
class UserDetailsImplTest {
    private User testUser;
    private UserDetailsImpl testUserDetails;

    @BeforeEach
    void setUp() {
        Role userRole = new Role(1, RolesEnum.ROLE_USER);
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        testUser = new User(1L,"user1","email@mail.ru","password", roles);
        testUserDetails = UserDetailsImpl.build(testUser);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void build() {
        assertEquals(testUserDetails, UserDetailsImpl.build(testUser));
    }

    @Test
    void isAccountNonExpired() {
        assertTrue(testUserDetails.isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked() {
        assertTrue(testUserDetails.isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired() {
        assertTrue(testUserDetails.isCredentialsNonExpired());
    }

    @Test
    void isEnabled() {
        assertTrue(testUserDetails.isEnabled());
    }

    @Test
    void getId() {
        assertEquals(1L, testUserDetails.getId());
    }

    @Test
    void getUsername() {
        assertEquals("user1", testUserDetails.getUsername());
    }

    @Test
    void getEmail() {
        assertEquals("email@mail.ru", testUserDetails.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("password", testUserDetails.getPassword());
    }

    @Test
    void getAuthorities() {
        testUserDetails.getAuthorities().forEach(
                        a-> assertEquals("ROLE_USER",a.getAuthority())
        );
    }
}