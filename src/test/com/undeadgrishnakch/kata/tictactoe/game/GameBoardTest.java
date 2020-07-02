package com.undeadgrishnakch.kata.tictactoe.game;

import com.undeadgrishnakch.kata.tictactoe.TicTacToe;
import com.undeadgrishnakch.kata.tictactoe.exception.BadPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * UNIT Test class to build the GAME BOARD.
 *
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
class GameBoardTest {
    @DisplayName("ASCII Empty Game Board Creation and Display")
    @Test
    void createAndDisplayGameBoardASCII() throws BadPlayer {
        Assertions.assertEquals(" | | \n-+-+-\n | | \n-+-+-\n | | \n", new TicTacToe().showGameBoardASCII());
    }
}