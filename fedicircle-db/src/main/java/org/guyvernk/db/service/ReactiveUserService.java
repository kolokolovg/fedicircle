package org.guyvernk.db.service;

import lombok.extern.slf4j.Slf4j;
import org.guyvernk.db.entity.User;
import org.guyvernk.db.repo.RoleRepository;
import org.guyvernk.db.repo.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ReactiveUserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public ReactiveUserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Mono<User> findByUsername(String username){
       return userRepository.findByUsername(username).map(Mono::just)
                .orElse(Mono.empty());
    }
}
