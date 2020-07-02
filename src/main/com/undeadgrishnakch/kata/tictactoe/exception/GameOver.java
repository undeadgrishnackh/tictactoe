package com.undeadgrishnakch.kata.tictactoe.exception;

import java.lang.Throwable;

/**
 * Exception to manage the game over
 * Created by michele.brissoni@ibm.com on 21/08/2017.
 */
public class GameOver extends Throwable {
    public GameOver() {
            super("You tried to paintMark after the match is closed!");
        }
}
