package com.undeadgrishnakch.kata.tictactoe.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ExtendWith(SpringExtension.class)
public class TicTacToeWebApplicationIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/areYouAlive");
    }

    @DisplayName("I'm ALIVE - REAL rnd port!")
    @Test
    public void iAmAlive() {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        Assertions.assertEquals(response.getBody(), equalTo("I'm ALIVE!"));
    }
}