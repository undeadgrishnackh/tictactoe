package com.undeadgrishnakch.kata.exception;

import com.undeadgrishnakch.kata.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
class BadMoveTest {
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

    @Test
    void playerXMoveOverO() {
    }

    @Test
    void playerOMoveOverX() {
    }

}