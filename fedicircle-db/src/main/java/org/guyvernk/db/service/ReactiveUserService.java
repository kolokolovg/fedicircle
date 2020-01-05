package org.guyvernk.db.service;

import org.guyvernk.db.entity.User;
import org.guyvernk.db.repo.RoleRepository;
import org.guyvernk.db.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ReactiveUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public Mono<User> findByUsername(String username){
       return userRepository.findByUsername(username).map(u -> Mono.just(u))
                .orElse(Mono.empty());
    }
}
