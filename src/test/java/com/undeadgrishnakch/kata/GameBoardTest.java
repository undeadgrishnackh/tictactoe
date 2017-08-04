package com.undeadgrishnakch.kata;

import com.undeadgrishnakch.kata.exception.BadPlayer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
class GameBoardTest {
    @DisplayName("Empty Game Board Creation")
    @Test
    void createGameBoard() throws BadPlayer {
        assertEquals(" | | \n-+-+-\n | | \n-+-+-\n | | \n", new TicTacToe().showGameBoard());
    }
}