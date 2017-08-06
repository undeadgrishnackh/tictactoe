package com.undeadgrishnakch.kata.game;

import com.undeadgrishnakch.kata.TicTacToe;
import com.undeadgrishnakch.kata.exception.BadPlayer;

import java.util.Arrays;

/**
 * Game sub class to model the Players: X; O
 *
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
public class Player {
    private String name = null;
    private TicTacToe game = null;


    public Player(String name) throws BadPlayer {
        String[] playerAllowed = {"X", "O"};
        if (Arrays.asList(playerAllowed).contains(name)) {
            this.name = name;
        } else throw new BadPlayer("Player " + name + " isn't allowed!");
    }

    public Player(String name, TicTacToe game) throws BadPlayer {
        this(name);
        this.game = game;
    }


    public String getName() {
        return this.name;
    }

    public TicTacToe getGame() {
        return game;
    }
}
