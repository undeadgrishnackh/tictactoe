package com.undeadgrishnakch.kata;

import com.undeadgrishnakch.kata.exception.BadPlayer;

import java.util.Arrays;

/**
 * Private class to model the Players
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
class Player {
    private String name = null;
    private String[] playerAllowed = {"X","O"};

    public Player(String name) throws BadPlayer {
        if (Arrays.asList(playerAllowed).contains(name)) {
            this.name = name;
        } else throw new BadPlayer("Player " + name + " isn't allowed!");
    }

    public String getName() {
        return this.name;
    }
}
