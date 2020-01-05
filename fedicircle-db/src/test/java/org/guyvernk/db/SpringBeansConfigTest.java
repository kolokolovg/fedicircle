package org.guyvernk.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TestConfiguration
@EnableJpaRepositories(basePackages = {"org.guyvernk.db.repo"})
@EntityScan(basePackages = {"org.guyvernk.db.entity"})
@ComponentScan(basePackages = {"org.guyvernk.db.service"})
public class SpringBeansConfigTest {
}
