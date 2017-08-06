package com.undeadgrishnakch.kata.game;

import com.undeadgrishnakch.kata.TicTacToe;
import com.undeadgrishnakch.kata.exception.BadPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * UNIT Test class to build the GAME BOARD.
 *
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
class GameBoardTest {
    @DisplayName("Empty Game Board Creation")
    @Test
    void createGameBoard() throws BadPlayer {
        Assertions.assertEquals(" | | \n-+-+-\n | | \n-+-+-\n | | \n", new TicTacToe().showGameBoard());
    }
}