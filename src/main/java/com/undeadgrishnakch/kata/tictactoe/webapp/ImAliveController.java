package com.undeadgrishnakch.kata.tictactoe.webapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.CodeSource;
import java.security.ProtectionDomain;

@RestController
public class ImAliveController {
    private static final Logger logger = LogManager.getLogger(ImAliveController.class);

    @RequestMapping("/areYouAlive")
    public String iAmAlive() {
        String jarName = "";
        JSONObject jsonReply = new JSONObject();
        try {
            Class c = Class.forName("com.undeadgrishnakch.kata.tictactoe.webapp.ImAliveController");
            ProtectionDomain pd= c.getProtectionDomain();
            CodeSource cs= pd.getCodeSource();
            jarName = cs.getLocation().toString();
            logger.info("JAR_NAME=" + jarName);
        } catch (ClassNotFoundException e) {
            logger.error("JAR_NAME=NONE");
        }

        jsonReply.put("reply","I'm ALIVE!");
        jsonReply.put("jarName",jarName);
        return jsonReply.toJSONString();
    }

}
