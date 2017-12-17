package com.undeadgrishnakch.kata.tictactoe.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImAliveController {

    @RequestMapping("/areYouAlive")
    public String iAmAlive() {
        return "I'm ALIVE!";
    }

}
