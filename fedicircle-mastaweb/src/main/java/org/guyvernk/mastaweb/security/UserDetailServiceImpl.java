package org.guyvernk.mastaweb.security;

import lombok.extern.slf4j.Slf4j;
import org.guyvernk.db.entity.User;
import org.guyvernk.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user "+username+" dont exist"));
        if (user.getRoles().isEmpty()) {
            throw new UsernameNotFoundException("user " + user.getUsername() + " dont have roles");
        }
        return UserDetailsImpl.build(user);
    }
}
