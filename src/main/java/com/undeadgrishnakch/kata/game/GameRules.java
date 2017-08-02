package com.undeadgrishnakch.kata.game;

import com.undeadgrishnakch.kata.TicTacToe;
import com.undeadgrishnakch.kata.exception.BadMove;

/**
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
public class GameRules {

    public static boolean move(Player player, int row, int column) throws BadMove {
        //TODO: the UAT BadMoves engine is ready. Now is time to implement the rules code after the red tests.
        TicTacToe ticTacToe = player.getGame();
        if (!ticTacToe.isYourRound(player))
            throw new BadMove("Isn't your round player " + player.getName());

        //TODO: manage move out of the game
        if (!ticTacToe.moveAllowed(row, column))
            throw new BadMove("You tried to move outside the game board!");

        //TODO: manage move over a busy cell

        return true;
    }
}
