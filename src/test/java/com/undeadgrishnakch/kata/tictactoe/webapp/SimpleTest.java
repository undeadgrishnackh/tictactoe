package com.undeadgrishnakch.kata.tictactoe.webapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitPlatform.class)
public class SimpleTest {
    @Test
    @DisplayName("Simple JUnit Test with JUnit5 and SpringBoot")
    void firsTtest() {
        assertTrue(true);
    }

}