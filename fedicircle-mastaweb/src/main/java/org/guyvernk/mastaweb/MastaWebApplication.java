package org.guyvernk.mastaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class MastaWebApplication {
    public static void main(String[] args) {
        System.setProperty("spring.cloud.bootstrap.enabled", "false");
        SpringApplication.run(MastaWebApplication.class,args);
    }
}
