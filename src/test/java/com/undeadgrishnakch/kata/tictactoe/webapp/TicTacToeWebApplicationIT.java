package com.undeadgrishnakch.kata.tictactoe.webapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;


@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicTacToeWebApplicationIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @DisplayName("I'm ALIVE - REAL rnd port!")
    @Test
    public void iAmAlive() throws Exception {
        this.base = new URL("http://localhost:" + port + "/areYouAlive");
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        Assertions.assertEquals("I'm ALIVE!", response.getBody());
    }

    @DisplayName("Game Start - REAL rnd port!")
    @Test
    public void gameStart() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        Assertions.assertEquals(" | | \n-+-+-\n | | \n-+-+-\n | | \n", response.getBody());
    }


}