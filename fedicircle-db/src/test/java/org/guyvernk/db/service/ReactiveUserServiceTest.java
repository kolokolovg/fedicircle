package org.guyvernk.db.service;

import org.guyvernk.db.RepoTest;
import org.guyvernk.db.repo.RoleRepository;
import org.guyvernk.db.repo.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
class ReactiveUserServiceTest extends RepoTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ReactiveUserService reactiveUserService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByUsername() {
        reactiveUserService.findByUsername("1")
                .doOnNext(user -> {
                    assertEquals("1", user.getUsername());
                })
                .subscribe();
    }
}