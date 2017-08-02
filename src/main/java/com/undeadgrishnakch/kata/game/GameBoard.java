package com.undeadgrishnakch.kata.game;

/**
 * GameBoard class
 * Private class to model the GameBoard
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
public class GameBoard {
    int rows = 3;
    int columns = 3;
    String gameboard[][] = new String[3][3];

    public GameBoard() {
    }

    public String getGameBoard(){
        return " | | \n-+-+-\n | | \n-+-+-\n | | ";
    }

    public boolean isTheCellIntoTheGame(int row, int column) {
        if (row >= 1 && row <= this.rows && column >= 1 && column <= columns){
            return true;
        } else return false;
    }
}
