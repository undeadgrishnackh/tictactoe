package com.undeadgrishnakch.kata.exception;

/**
 * Exception to manage the BadMove into the game.
 *
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
public class BadMove extends Exception {
    public BadMove(String message) {
        super(message);
    }
}
