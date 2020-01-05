package org.guyvernk.mastaweb.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.guyvernk.db.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsImpl implements  UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String username;
    @Email
    private String email;

    @JsonIgnore
    private String password;
    private Collection<SimpleGrantedAuthority> authorities;

    public static UserDetailsImpl build(User user) {
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
