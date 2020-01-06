package org.guyvernk.db.repo;

import org.guyvernk.db.RepoTest;
import org.guyvernk.db.entity.Role;
import org.guyvernk.db.entity.RolesEnum;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
class RoleRepositoryTest extends RepoTest {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    void findByName() {
        assertEquals(RolesEnum.ROLE_USER,
                roleRepository.findByName(RolesEnum.ROLE_USER).map(Role::getName).orElse(RolesEnum.NONE));
        assertEquals(RolesEnum.ROLE_MODERATOR,
                roleRepository.findByName(RolesEnum.ROLE_MODERATOR).map(Role::getName).orElse(RolesEnum.NONE));
        assertEquals(RolesEnum.ROLE_ADMIN,
                roleRepository.findByName(RolesEnum.ROLE_ADMIN).map(Role::getName).orElse(RolesEnum.NONE));
    }
}