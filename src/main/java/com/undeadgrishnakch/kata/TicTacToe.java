package com.undeadgrishnakch.kata;

import com.undeadgrishnakch.kata.exception.BadPlayer;

/**
 * Tic Tac Toe Kata developed in TDD mode to show TDD
 * development in a workshop training.
 *
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
public class TicTacToe {
    private GameBoard gameBoard = null;
    private Player[] players = new Player[2];

    public TicTacToe() throws BadPlayer {
        this.gameBoard = new GameBoard();
        this.players[0] = new Player("X");
        this.players[1] = new Player("O");
    }

    public String showGameBoard(){
        return this.gameBoard.getGameBoard();
    }

    /***
     * Return the player Name
     * @param i can be 0 or 1
     * @return X for player 0, O for player 1 as defined by the tic tac toe rules
     * @throws BadPlayer
     */
    public Player getPlayerName(int i) throws BadPlayer {
        if (i == 0 || i == 1){
            return this.players[i];
        } else throw new BadPlayer("The selected Player doesn't exist!");
    }

    /*public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.showGameBoard();
    }*/
}
