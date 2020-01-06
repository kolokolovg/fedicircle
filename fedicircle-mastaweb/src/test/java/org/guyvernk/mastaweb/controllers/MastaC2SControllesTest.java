package org.guyvernk.mastaweb.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class MastaC2SControllesTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ints_basic_authorized_success() {
        String expected = "PUK";
        ResponseEntity<String> response = restTemplate
                .withBasicAuth("1", "1")
                .getForEntity("/s", String.class);
        assertEquals(expected, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());


    }
    @Test
    void ints_basic_authorized_false() {
        ResponseEntity<String> response = restTemplate
                .withBasicAuth("2", "2")
                .getForEntity("/s", String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());


    }
}