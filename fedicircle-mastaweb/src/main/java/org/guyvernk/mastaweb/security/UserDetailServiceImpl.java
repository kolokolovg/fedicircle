package org.guyvernk.mastaweb.security;

import lombok.extern.java.Log;
import org.guyvernk.db.service.ReactiveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Log
@Service
public class UserDetailServiceImpl implements ReactiveUserDetailsService {
    @Autowired
    private ReactiveUserService reactiveUserService;

    @Override
    public Mono<UserDetails> findByUsername(String s) {
        Mono<UserDetails> user = reactiveUserService.findByUsername(s).cast(UserDetails.class);
        user.subscribe(u-> log.info(u.getUsername()));
        log.info("PUK");
        return reactiveUserService.findByUsername(s).cast(UserDetails.class);
    }
}
