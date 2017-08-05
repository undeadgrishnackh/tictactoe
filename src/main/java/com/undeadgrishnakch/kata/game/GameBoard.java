package com.undeadgrishnakch.kata.game;

import com.undeadgrishnakch.kata.exception.BadMove;

/**
 * GameBoard class
 * Private class to model the GameBoard
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
public class GameBoard {
    int rows = 3;
    int columns = 3;
    String gameboard[][] = {{" "," "," "},{" "," "," "},{" "," "," "}}; //new String[3][3];

    public GameBoard() {
    }


    public String getGameboardCell(int row, int column) {
        return gameboard[row-1][column-1];
    }

    public void setGameboardCell(Player player, int row, int column) {
        this.gameboard[row-1][column-1] = player.getName();
    }


    public String displayGameBoard(){
        return getGameboardCell(1,1) + "|" +
                getGameboardCell(1,2) + "|" +
                getGameboardCell(1,3) +
                "\n-+-+-\n" +
                getGameboardCell(2,1) + "|" +
                getGameboardCell(2,2) + "|" +
                getGameboardCell(2,3) +
                "\n-+-+-\n" +
                getGameboardCell(3,1) + "|" +
                getGameboardCell(3,2) + "|" +
                getGameboardCell(3,3) + "\n";
    }

    public boolean isTheCellIntoTheGame(int row, int column) {
        if (row >= 1 && row <= this.rows && column >= 1 && column <= columns){
            return true;
        } else return false;
    }

    public boolean isTheCellEmpty(int row, int column) throws BadMove {
        if (isTheCellIntoTheGame( row,  column)){
            if (getGameboardCell(row,column).equals(" ")){
                return true;
            } else return false;
        } else throw new BadMove("Move out of the game!");  //TODO: techdebt - refactor throw mechanism above
    }

    public boolean isVerticalWon(Player player) {
        for (int col = 1; col <= this.columns; col++) {
            if (    getGameboardCell(1,col).equals(player.getName()) &&
                    getGameboardCell(2,col).equals(player.getName()) &&
                    getGameboardCell(3,col).equals(player.getName())) {
                return true;
            }
        }
        return false;
    }
}
