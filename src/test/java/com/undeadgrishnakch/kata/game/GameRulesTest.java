package com.undeadgrishnakch.kata.game;

import com.undeadgrishnakch.kata.TicTacToe;
import com.undeadgrishnakch.kata.exception.BadMove;
import com.undeadgrishnakch.kata.exception.BadPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * UNIT Test class to build the game rules logic.
 *
 * Created by michele.brissoni@ibm.com on 06/08/2017.
 */
class GameRulesTest {
    private TicTacToe ticTacToe = null;

    @BeforeEach
    void setUp() throws BadPlayer {
        this.ticTacToe = new TicTacToe();
    }

    @DisplayName("playerX Move on a Bad Round")
    @Test
    void playerXMoveBadRound() throws BadMove, BadPlayer {
        Throwable exception = assertThrows(BadMove.class, () -> {
            throw new BadMove("Isn't your round player X");
        });

        this.ticTacToe.move("X",1,1);
        assertAll("Bad Player round",
                () -> assertEquals("Isn't your round player X", exception.getMessage()),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",1,2)));
    }

    @DisplayName("playerO Move on a Bad Round")
    @Test
    void playerOMoveBadRound() throws BadMove, BadPlayer{
        Throwable exception = assertThrows(BadMove.class, () -> {
            throw new BadMove("Isn't your round player O");
        });

        this.ticTacToe.move("X",1,1);
        this.ticTacToe.move("O",2,1);
        assertAll("Bad Player round",
                () -> assertEquals("Isn't your round player O", exception.getMessage()),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("O",1,2)));
    }

    @DisplayName("Player Move outside the game board")
    @Test
    void playerMoveOutOfGameBoard() {
        Throwable exception = assertThrows(BadMove.class, () -> {
            throw new BadMove("You tried to move outside the game board!");
        });

        assertAll("Player move outside the game board",
                () -> assertEquals("You tried to move outside the game board!", exception.getMessage()),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",4,4)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",0,0)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",0,4)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",4,0)),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",-1,-1)));
    }

    @DisplayName("Player X move on not empty slot")
    @Test
    void playerXMoveOverO() throws BadMove, BadPlayer {
        Throwable exception = assertThrows(BadMove.class, () -> {
            throw new BadMove("You tried to move over a not empty slot!");
        });

        this.ticTacToe.move("X",1,1);
        this.ticTacToe.move("O",2,2);
        assertAll("Player move on a not empty slot",
                () -> assertEquals("You tried to move over a not empty slot!", exception.getMessage()),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("X",2,2)));
    }

    @DisplayName("Player O move on not empty slot")
    @Test
    void playerOMoveOverX() throws BadMove, BadPlayer {
        Throwable exception = assertThrows(BadMove.class, () -> {
            throw new BadMove("You tried to move over a not empty slot!");
        });

        this.ticTacToe.move("X",1,1);
        assertAll("Player move on a not empty slot",
                () -> assertEquals("You tried to move over a not empty slot!", exception.getMessage()),
                () -> assertThrows(BadMove.class, () -> this.ticTacToe.move("O",1,1)));
    }

}