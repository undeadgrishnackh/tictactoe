package com.undeadgrishnakch.kata.tictactoe.exception;

import java.lang.Throwable;

/**
 * Exception to manage the BadMove into the game.
 *
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
public class BadMove extends Throwable {
    public BadMove(String message) {
        super(message);
    }
}
