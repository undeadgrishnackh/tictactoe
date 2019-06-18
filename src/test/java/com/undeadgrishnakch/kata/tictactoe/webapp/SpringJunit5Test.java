package com.undeadgrishnakch.kata.tictactoe.webapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitPlatform.class)
public class SpringJunit5Test {
    @Test
    @DisplayName("Simple Test with JUnit5 and SpringBoot")
    void junit5SpringTest() {
        assertTrue(true);
    }

}