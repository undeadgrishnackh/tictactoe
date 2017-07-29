package com.undeadgrishnakch.kata;

/**
 * Tic Tac Toe Kata developed in TDD mode to show TDD
 * development in a workshop training.
 *
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
public class TicTacToe {

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        System.out.print(gameBoard.getGameBoard());
    }


}
