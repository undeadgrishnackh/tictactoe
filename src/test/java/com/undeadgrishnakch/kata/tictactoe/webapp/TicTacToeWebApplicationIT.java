package com.undeadgrishnakch.kata.tictactoe.webapp;

import org.json.simple.JSONObject;
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
import org.json.simple.parser.JSONParser;

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


    @DisplayName("Home page - IT on a random port!")
    @Test
    public void homepage() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        Assertions.assertEquals("Welcome to the TicTacToe Game.", response.getBody());
    }

    @DisplayName("I'm ALIVE - IT on a random port!")
    @Test
    public void iAmAlive() throws Exception {
        this.base = new URL("http://localhost:" + port + "/areYouAlive");
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        JSONObject jsonReply = (JSONObject) new JSONParser().parse(response.getBody());
        Assertions.assertEquals("I'm ALIVE!", jsonReply.get("reply"));
    }

    @DisplayName("getEmptyBoard - IT on a random port!")
    @Test
    public void getEmptyBoard() throws Exception {
        this.base = new URL("http://localhost:" + port + "/getEmptyBoard");
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        JSONObject jsonReply = (JSONObject) new JSONParser().parse(response.getBody());
        Assertions.assertEquals(" ", jsonReply.get("1.1"));
        Assertions.assertEquals(" ", jsonReply.get("1.2"));
        Assertions.assertEquals(" ", jsonReply.get("1.3"));
        Assertions.assertEquals(" ", jsonReply.get("2.1"));
        Assertions.assertEquals(" ", jsonReply.get("2.2"));
        Assertions.assertEquals(" ", jsonReply.get("2.3"));
        Assertions.assertEquals(" ", jsonReply.get("3.1"));
        Assertions.assertEquals(" ", jsonReply.get("3.2"));
        Assertions.assertEquals(" ", jsonReply.get("3.3"));
    }


}