package com.undeadgrishnakch.kata.game;

import com.undeadgrishnakch.kata.TicTacToe;
import com.undeadgrishnakch.kata.exception.BadMove;
import com.undeadgrishnakch.kata.status.GameStatus;

/**
 * Game sub class to model the game rules:
 * 1- rounds
 * 2- movements
 * 3- game over and final status
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
public class GameRules {
    public GameRules() {
    }

    public void move(Player player, int row, int column) throws BadMove {
        if (isGameOver(player))
            throw new BadMove("You tried to move after the match is closed!");

        if (!isYourRound(player))
            throw new BadMove("Isn't your round player " + player.getName());

        if (!isMovingIntoTheBoard(player, row, column))
            throw new BadMove("You tried to move outside the game board!");

        if (!isTheCellEmpty(player, row, column))
            throw new BadMove("You tried to move over a not empty slot!");


        placePlayerPinIntoTheCell(player, row, column);
    }

    private boolean isGameOver(Player player) {
        TicTacToe ticTacToe = player.getGame();
        if (ticTacToe.getGameResult().equals(GameStatus.IN_PROGRESS)) return false;
        return true;
    }


    public boolean isGameOverAfterThisMove(Player player) {
        GameBoard gameboard = player.getGame().getGameBoard();
        if (gameboard.isVerticalWon(player)){
            setGameStatusToVictory(player);
            return true;
        }

        if (gameboard.isHorizontalWon(player)){
            setGameStatusToVictory(player);
            return true;
        }

        if (gameboard.isDiagonalWon(player)){
            setGameStatusToVictory(player);
            return true;
        }

        if (gameboard.isDraw()){
            setGameStatusToDraw(player);
            return true;
        }

        return false;
    }

    /* --------------------------------------------------------------------------------- */

    private void setGameStatusToDraw(Player player) {
        setGameResult(player, GameStatus.DRAW);
    }

    private void setGameStatusToVictory(Player player) {
        if (player.getName().equals("X")) {
            setGameResult(player, GameStatus.PLAYER_X_WON);
        } else {
            setGameResult(player, GameStatus.PLAYER_O_WON);
        }
    }

    private void setGameResult(Player player, String gameStatus) {
        player.getGame().setGameResult(gameStatus);
    }

    private boolean isYourRound(Player player) {
        return player.getName().equals(player.getGame().getRound().getName());
    }

    private boolean isMovingIntoTheBoard(Player player, int row, int column) {
        return player.getGame().getGameBoard().isTheCellIntoTheGame(row, column);
    }

    private boolean isTheCellEmpty(Player player, int row, int column) throws BadMove {
        return player.getGame().getGameBoard().isTheCellEmpty(row,column);
    }

    private void placePlayerPinIntoTheCell(Player player, int row, int column) {
        player.getGame().getGameBoard().setGameBoardCell(player,row, column);
    }
}
