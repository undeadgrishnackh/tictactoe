package com.undeadgrishnakch.kata.tictactoe.exception;

/**
 * Exception to manage the game over
 * Created by michele.brissoni@ibm.com on 21/08/2017.
 */
public class GameOver extends Exception {
    public GameOver() {
            super("You tried to move after the match is closed!");
        }
}
