package org.guyvernk.db.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.guyvernk.db.security.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
