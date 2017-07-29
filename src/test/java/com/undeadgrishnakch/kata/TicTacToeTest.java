package com.undeadgrishnakch.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * TDD Test class to build the tic tac toe kata.
 *
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
class TicTacToeTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    @DisplayName("jUnit Configuration Test")
    @Test
    void jUnitConfigurationTest_dummy() {
        assertTrue(true);
    }

    @DisplayName("Empty Game Board Creation")
    @Test
    void createGameBoard() {
        assertEquals(" | | \n-+-+-\n | | \n-+-+-\n | | ", new GameBoard().getGameBoard());
    }


}