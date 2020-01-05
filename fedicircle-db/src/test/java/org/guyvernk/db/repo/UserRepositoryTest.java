package org.guyvernk.db.repo;

import org.guyvernk.db.RepoTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
class UserRepositoryTest extends RepoTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsername() {
        assertEquals("1", userRepository.findByUsername("1").get().getUsername());
        assertEquals("2", userRepository.findByUsername("2").get().getUsername());
        assertEquals("3", userRepository.findByUsername("3").get().getUsername());
    }

    @Test
    void existsByUsername() {
        assertTrue(userRepository.existsByUsername("1"));
        assertTrue(userRepository.existsByUsername("2"));
        assertTrue(userRepository.existsByUsername("3"));
    }

    @Test
    void existsByEmail() {
        assertTrue(userRepository.existsByEmail("pes1@mail.ru"));
        assertTrue(userRepository.existsByEmail("pes2@mail.ru"));
        assertTrue(userRepository.existsByEmail("pes3@mail.ru"));
    }
}