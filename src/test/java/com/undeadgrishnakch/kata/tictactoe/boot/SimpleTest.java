package com.undeadgrishnakch.kata.tictactoe.boot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitPlatform.class)
public class SimpleTest {
    @Test
    @DisplayName("Simple JUnit Test")
    void firsTtest() {
        assertTrue(true);
    }

}