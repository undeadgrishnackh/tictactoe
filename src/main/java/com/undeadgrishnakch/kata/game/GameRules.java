package com.undeadgrishnakch.kata.game;

import com.undeadgrishnakch.kata.exception.BadMove;
import com.undeadgrishnakch.kata.status.GameStatus;

/**
 * Game sub class to model the game rules:
 * 1- rounds
 * 2- movements
 * 3- game over and final status
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
//TODO: techdebt -- Create the constructor to improve tests and link to the game instance.
public class GameRules {

    public static void move(Player player,  int row, int column) throws BadMove {
        if (!isYourRound(player))
            throw new BadMove("Isn't your round player " + player.getName());

        if (!isMovingIntoTheBoard(player, row, column))
            throw new BadMove("You tried to move outside the game board!");

        if (!isTheCellEmpty(player, row, column))
            throw new BadMove("You tried to move over a not empty slot!");

        placePlayerPinIntoTheCell(player, row, column);
    }


    public static boolean isGameOver(Player player) {
        GameBoard gameboard = player.getGame().getGameBoard();
        if (gameboard.isVerticalWon(player)){
            return setGameStatusToVictory(player);
        }

        if (gameboard.isHorizontalWon(player)){
            return setGameStatusToVictory(player);
        }

        if (gameboard.isDiagonalWon(player)){
            return setGameStatusToVictory(player);
        }

        return false;
    }

    /* --------------------------------------------------------------------------------- */

    private static boolean setGameStatusToVictory(Player player) {
        if (player.getName().equals("X")) {
            setGameResult(player, GameStatus.PLAYER_X_WON);
            return true;
        } else {
            setGameResult(player, GameStatus.PLAYER_O_WON);
            return true;
        }
    }

    private static void setGameResult(Player player, String gameStatus) {
        player.getGame().setGameResult(gameStatus);
    }

    private static boolean isYourRound(Player player) {
        return player.getName().equals(player.getGame().getRound().getName());
    }

    private static boolean isMovingIntoTheBoard(Player player, int row, int column) {
        return player.getGame().getGameBoard().isTheCellIntoTheGame(row, column);
    }

    private static boolean isTheCellEmpty(Player player, int row, int column) throws BadMove {
        return player.getGame().getGameBoard().isTheCellEmpty(row,column);
    }

    private static void placePlayerPinIntoTheCell(Player player, int row, int column) {
        player.getGame().getGameBoard().setGameBoardCell(player,row, column);
    }
}
