package org.guyvernk.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;


@SpringBootApplication
public class DBTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DBTestApplication.class,args);
    }
}
