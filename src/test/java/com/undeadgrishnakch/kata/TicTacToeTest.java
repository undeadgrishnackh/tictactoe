package com.undeadgrishnakch.kata;

import com.undeadgrishnakch.kata.exception.BadMove;
import com.undeadgrishnakch.kata.exception.BadPlayer;
import com.undeadgrishnakch.kata.status.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TDD Test class to build the tic tac toe kata.
 *
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
class TicTacToeTest {
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

    @DisplayName("Player X won with a vertical line")
    @Test
    void playerXWonWithVertical () throws BadPlayer, BadMove {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.move("X",1,1);
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("O",2,2);
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("X",2,1);
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("O",3,3);
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("X",3,1);
        assertEquals(GameStatus.PLAYER_X_WON, ticTacToe.getGameResult());
    }
}