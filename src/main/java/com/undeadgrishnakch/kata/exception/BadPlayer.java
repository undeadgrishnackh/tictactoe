package com.undeadgrishnakch.kata.exception;

/**
 * Exception to manage the bad players use or naming.
 *
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
public class BadPlayer extends Exception {

    public BadPlayer(String message) {
        super(message);
    }
}
