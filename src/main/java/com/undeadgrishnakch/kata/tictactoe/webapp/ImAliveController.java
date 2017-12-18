package com.undeadgrishnakch.kata.tictactoe.webapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.CodeSource;
import java.security.ProtectionDomain;

@RestController
public class ImAliveController {

    @RequestMapping("/areYouAlive")
    public String iAmAlive() {

        Class c= null; // or any other way to obtain a Class object
        try {
            c = Class.forName("com.undeadgrishnakch.kata.tictactoe.webapp.ImAliveController");
            ProtectionDomain pd= c.getProtectionDomain();
            CodeSource cs= pd.getCodeSource();
            System.out.println("JAR_NAME=" + cs.getLocation());
        } catch (ClassNotFoundException e) {
            System.out.println("JAR_NAME=NONE");
        }

        return "I'm ALIVE!";
    }

}
