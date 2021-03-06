package com.undeadgrishnakch.kata.tictactoe.game;

import com.undeadgrishnakch.kata.tictactoe.TicTacToe;
import com.undeadgrishnakch.kata.tictactoe.exception.BadMove;
import com.undeadgrishnakch.kata.tictactoe.exception.BadPlayer;
import com.undeadgrishnakch.kata.tictactoe.exception.GameOver;
import org.apache.logging.log4j.LogManager;

import java.util.Arrays;
import java.util.Random;


/**
 * Game sub class to model the Players: X; O
 *
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
public class Player {
    private String name = null;
    private TicTacToe game = null;
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Player.class);

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

    /**
     * Generate a random paintMark that satisfy the game rules. In case after this paintMark the game is over
     * throw a game over exception to signal that the game is done.
     */
    public void moveRandom() throws GameOver, BadPlayer {
        Random random = new Random();
        int r;
        int c;
        while (true) {
            try {
                r = random.nextInt(3)+1;
                c = random.nextInt(3)+1;
                logger.debug("Random paintMark is r=" + r + "; c="+ c);
                this.getGame().paintMark(this.getName(), r, c);
                break;
            } catch (BadMove ignored) {
                logger.trace("BadMove is caught but ignored.");
            }
        }
    }
}
