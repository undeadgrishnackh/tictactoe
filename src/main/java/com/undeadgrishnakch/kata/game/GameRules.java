package com.undeadgrishnakch.kata.game;

import com.undeadgrishnakch.kata.exception.BadMove;

/**
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
public class GameRules {

    public static boolean move(Player player, int row, int column) throws BadMove {
        //TODO: the UAT BadMoves engine is ready. Now is time to implement the rules code after the red tests.
        if (player.getGame().isYourRound(player)){
            return true;
        } else throw new BadMove("Isn't your round player " + player.getName());
    }
}
