package org.guyvernk.mastaweb.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.guyvernk.db.repo"})
@EntityScan(basePackages = {"org.guyvernk.db.entity"})
@ComponentScan(basePackages = {"org.guyvernk.db.service"})
public class DBConfig {

}
