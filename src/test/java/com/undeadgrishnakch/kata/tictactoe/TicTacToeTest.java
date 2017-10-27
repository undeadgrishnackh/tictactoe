package com.undeadgrishnakch.kata.tictactoe;

import com.undeadgrishnakch.kata.tictactoe.exception.BadMove;
import com.undeadgrishnakch.kata.tictactoe.exception.BadPlayer;
import com.undeadgrishnakch.kata.tictactoe.exception.GameOver;
import com.undeadgrishnakch.kata.tictactoe.status.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * BDD Test class to check the overall game
 *
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
class TicTacToeTest {
    private TicTacToe ticTacToe = null;

    /**
     * Private test method to improve the test readability
     */
    private boolean isGameCorrectlyOver() {
        return ticTacToe.getGameResult().equals(GameStatus.DRAW) ||
                ticTacToe.getGameResult().equals(GameStatus.PLAYER_O_WON) ||
                ticTacToe.getGameResult().equals(GameStatus.PLAYER_X_WON);
    }

    @BeforeEach
    void setUp() throws BadPlayer {
        this.ticTacToe = new TicTacToe();
    }

    //------------------------------------------------------------------------------


    @DisplayName("BDD - Player X won with a vertical line")
    @Test
    void playerXWonWithVertical () throws BadPlayer, BadMove, GameOver {
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("X",1,1);
        ticTacToe.move("O",2,2);
        ticTacToe.move("X",2,1);
        ticTacToe.move("O",3,3);
        ticTacToe.move("X",3,1);
        assertEquals(GameStatus.PLAYER_X_WON, ticTacToe.getGameResult());
    }

    @DisplayName("BDD - Player O won with a vertical line")
    @Test
    void playerOWonWithVertical () throws BadPlayer, BadMove, GameOver {
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("X",1,1);
        ticTacToe.move("O",1,2);
        ticTacToe.move("X",1,3);
        ticTacToe.move("O",2,2);
        ticTacToe.move("X",3,3);
        ticTacToe.move("O",3,2);
        assertEquals(GameStatus.PLAYER_O_WON, ticTacToe.getGameResult());
    }

    @DisplayName("BDD - Player X won with a horizontal line")
    @Test
    void playerXWonWithHorizontal () throws BadPlayer, BadMove, GameOver {
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("X",1,1);
        ticTacToe.move("O",2,2);
        ticTacToe.move("X",1,2);
        ticTacToe.move("O",3,3);
        ticTacToe.move("X",1,3);
        assertEquals(GameStatus.PLAYER_X_WON, ticTacToe.getGameResult());
    }

    @DisplayName("BDD - Player O won with a horizontal line")
    @Test
    void playerOWonWithHorizontal () throws BadPlayer, BadMove, GameOver {
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("X",1,1);
        ticTacToe.move("O",2,2);
        ticTacToe.move("X",1,2);
        ticTacToe.move("O",2,3);
        ticTacToe.move("X",3,3);
        ticTacToe.move("O",2,1);
        assertEquals(GameStatus.PLAYER_O_WON, ticTacToe.getGameResult());
    }

    @DisplayName("BDD - Player X Won With Diagonal")
    @Test
    void playerXWonWithDiagonal () throws BadPlayer, BadMove, GameOver {
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("X",1,1);
        ticTacToe.move("O",1,2);
        ticTacToe.move("X",2,2);
        ticTacToe.move("O",2,3);
        ticTacToe.move("X",3,3);
        assertEquals(GameStatus.PLAYER_X_WON, ticTacToe.getGameResult());
    }

    @DisplayName("BDD - Player O Won With Diagonal")
    @Test
    void playerOWonWithDiagonal () throws BadPlayer, BadMove, GameOver {
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("X",1,1);
        ticTacToe.move("O",2,2);
        ticTacToe.move("X",1,2);
        ticTacToe.move("O",1,3);
        ticTacToe.move("X",3,3);
        ticTacToe.move("O",3,1);
        assertEquals(GameStatus.PLAYER_O_WON, ticTacToe.getGameResult());
    }

    @DisplayName("BDD - Draw")
    @Test
    void draw () throws BadPlayer, BadMove, GameOver {
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("X",1,1);
        ticTacToe.move("O",1,2);
        ticTacToe.move("X",1,3);
        ticTacToe.move("O",2,2);
        ticTacToe.move("X",2,1);
        ticTacToe.move("O",2,3);
        ticTacToe.move("X",3,2);
        ticTacToe.move("O",3,1);
        ticTacToe.move("X",3,3);
        assertEquals(GameStatus.DRAW, ticTacToe.getGameResult());
    }

    @DisplayName("BDD - BOT VS BOT Games")
    @Test
    void botVsBot () throws BadPlayer, BadMove, GameOver {
        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.playBotVsBotGame();
        assertTrue(isGameCorrectlyOver());
    }

}