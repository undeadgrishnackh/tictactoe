package com.undeadgrishnakch.kata.exception;

import com.undeadgrishnakch.kata.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void playerOMoveBadRound() {
    }

    @Test
    void playerMoveOutOfGameBoard() {
    }

    @Test
    void playerXMoveOverO() {
    }

    @Test
    void playerOMoveOverX() {
    }

}