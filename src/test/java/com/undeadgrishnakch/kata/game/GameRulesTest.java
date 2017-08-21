package com.undeadgrishnakch.kata.game;

import com.undeadgrishnakch.kata.TicTacToe;
import com.undeadgrishnakch.kata.exception.BadMove;
import com.undeadgrishnakch.kata.exception.BadPlayer;
import com.undeadgrishnakch.kata.exception.GameOver;
import com.undeadgrishnakch.kata.status.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UNIT Test class to build the game rules logic.
 *
 * Created by michele.brissoni@ibm.com on 06/08/2017.
 */
class GameRulesTest {
    private TicTacToe ticTacToe = null;

    /**
     * method to improve the readability of the tests. The method process the move from the player and compare the
     * message of the exception with the expected. If no exception is raised, the final assert raise a failure!
     */
    private void ticTacToeCheckBadMoveException(String player, int row, int column, Throwable exceptionExpected) throws BadPlayer {
        try {
            this.ticTacToe.move(player,row,column);
        } catch (BadMove | GameOver exception) {
            assertEquals(exceptionExpected.getMessage(),exception.getMessage());
            return;
        }
        assertEquals("Expected the exception: " + exceptionExpected.getMessage(),"No Exception was trapped!");
    }

    @BeforeEach
    void setUp() throws BadPlayer {
        this.ticTacToe = new TicTacToe();
    }


    @DisplayName("playerX Move on a Bad Round")
    @Test
    void playerXMoveBadRound() throws BadMove, BadPlayer, GameOver {
        Throwable exceptionExpected = assertThrows(BadMove.class, () -> {
            throw new BadMove("Isn't your round player X");
        });

        this.ticTacToe.move("X",1,1);
        ticTacToeCheckBadMoveException("X",1,2, exceptionExpected);
    }

    @DisplayName("playerO Move on a Bad Round")
    @Test
    void playerOMoveBadRound() throws BadMove, BadPlayer, GameOver {
        Throwable exceptionExpected = assertThrows(BadMove.class, () -> {
            throw new BadMove("Isn't your round player O");
        });

        this.ticTacToe.move("X",1,1);
        this.ticTacToe.move("O",2,1);
        ticTacToeCheckBadMoveException("O",1,2,exceptionExpected);
    }

    @DisplayName("Player Move outside the game board")
    @Test
    void playerMoveOutOfGameBoard() throws BadPlayer, BadMove, GameOver {
        Throwable exceptionExpected = assertThrows(BadMove.class, () -> {
            throw new BadMove("You tried to move outside the game board!");
        });

        ticTacToeCheckBadMoveException("X",4,4,exceptionExpected);
        assertAll("Player move outside the game board",
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",4,4)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",0,0)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",0,4)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",4,0)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",-1,-1)));
        this.ticTacToe.move("X",1,1);
        ticTacToeCheckBadMoveException("O",4,4,exceptionExpected);
        assertAll("Player move outside the game board",
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("O",4,4)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("O",0,0)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("O",0,4)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("O",4,0)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("O",-1,-1)));

    }

    @DisplayName("Player X move on not empty slot")
    @Test
    void playerXMoveOverO() throws BadMove, BadPlayer, GameOver {
        Throwable exceptionExpected = assertThrows(BadMove.class, () -> {
            throw new BadMove("You tried to move over a not empty slot!");
        });

        this.ticTacToe.move("X",1,1);
        this.ticTacToe.move("O",2,2);
        ticTacToeCheckBadMoveException("X",2,2,exceptionExpected);
    }

    @DisplayName("Player O move on not empty slot")
    @Test
    void playerOMoveOverX() throws BadMove, BadPlayer, GameOver {
        Throwable exceptionExpected = assertThrows(BadMove.class, () -> {
            throw new BadMove("You tried to move over a not empty slot!");
        });

        this.ticTacToe.move("X",1,1);
        ticTacToeCheckBadMoveException("O",1,1, exceptionExpected);
        assertThrows(BadMove.class, () -> this.ticTacToe.move("O",1,1));
    }


    @DisplayName("Player O try to move in an end game")
    @Test
    void playerOMoveAfterTheGameEnd () throws BadPlayer, BadMove, GameOver {
        Throwable exceptionExpected = assertThrows(GameOver.class, () -> {
            throw new GameOver();
        });

        assertEquals(GameStatus.IN_PROGRESS, ticTacToe.getGameResult());
        ticTacToe.move("X",1,1);
        ticTacToe.move("O",2,1);
        ticTacToe.move("X",1,2);
        ticTacToe.move("O",2,2);
        ticTacToe.move("X",1,3);
        assertEquals(GameStatus.PLAYER_X_WON, ticTacToe.getGameResult());
        ticTacToeCheckBadMoveException("O",2,3,exceptionExpected);
    }

}