package com.undeadgrishnakch.kata.game;

import com.undeadgrishnakch.kata.exception.BadMove;

/**
 * GameBoard class
 * Private class to model the GameBoard
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
public class GameBoard {
    static private final int rows = 3;
    static private final int columns = 3;
    private final String gameboard[][] = {{" "," "," "},{" "," "," "},{" "," "," "}};

    public GameBoard() {
    }


    private String getGameboardCell(int row, int column) {
        return gameboard[row-1][column-1];
    }

    void setGameboardCell(Player player, int row, int column) {
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
        return row >= 1 && row <= rows && column >= 1 && column <= columns;
    }

    public boolean isTheCellEmpty(int row, int column) throws BadMove {
        if (isTheCellIntoTheGame( row,  column)){
            return getGameboardCell(row, column).equals(" ");
        } else throw new BadMove("Move out of the game!");  //TODO: techdebt - refactor throw mechanism above
    }

    public boolean isVerticalWon(Player player) {
        for (int col = 1; col <= columns; col++) {
            if (    getGameboardCell(1,col).equals(player.getName()) &&
                    getGameboardCell(2,col).equals(player.getName()) &&
                    getGameboardCell(3,col).equals(player.getName())) {
                return true;
            }
        }
        return false;
    }
}
