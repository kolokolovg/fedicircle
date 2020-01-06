package org.guyvernk.db.service;

import lombok.extern.slf4j.Slf4j;
import org.guyvernk.db.entity.User;
import org.guyvernk.db.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username){
       return userRepository.findByUsername(username);
    }
}
