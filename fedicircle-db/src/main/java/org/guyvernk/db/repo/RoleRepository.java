package org.guyvernk.db.repo;

import org.guyvernk.db.entity.Role;
import org.guyvernk.db.entity.RolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RolesEnum name);
}
