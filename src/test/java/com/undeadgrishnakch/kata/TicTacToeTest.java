package com.undeadgrishnakch.kata;

import com.undeadgrishnakch.kata.exception.BadPlayer;
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
    // TDD test -------------------------
    @DisplayName("jUnit Configuration Test")
    @Test
    void jUnitConfigurationTest_dummy() {
        assertTrue(true);
    }

    @DisplayName("First player in the game is X")
    @Test
    void playerOneIsX () throws BadPlayer {
        assertEquals("X", new TicTacToe().getPlayerName(0).getName());
    }

    @DisplayName("First player in the game is X")
    @Test
    void playerTwoIsO () throws BadPlayer {
        assertEquals("O", new TicTacToe().getPlayerName(1).getName());
    }
}