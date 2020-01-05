package org.guyvernk.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.guyvernk.db.repo"})
@EntityScan(basePackages = {"org.guyvernk.db.entity"})
@ComponentScan(basePackages = {"org.guyvernk.db.service"})
public class DBTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DBTestApplication.class,args);
    }
}
