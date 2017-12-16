package com.undeadgrishnakch.kata.tictactoe.game;

import org.jetbrains.annotations.NotNull;

/**
 * GameBoard class to create the playground and the
 * logic to understand who is where --> players vs
 * space matrix
 *
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
public class GameBoard {
    private String[][] board = null;
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;

    public GameBoard() {
        this.board = new String[][] {{" "," "," "},{" "," "," "},{" "," "," "}};
    }

    public String displayGameBoard(){
        return getGameBoardCell(1,1) + "|" +
                getGameBoardCell(1,2) + "|" +
                getGameBoardCell(1,3) +
                "\n-+-+-\n" +
                getGameBoardCell(2,1) + "|" +
                getGameBoardCell(2,2) + "|" +
                getGameBoardCell(2,3) +
                "\n-+-+-\n" +
                getGameBoardCell(3,1) + "|" +
                getGameBoardCell(3,2) + "|" +
                getGameBoardCell(3,3) + "\n";
    }


    private String getGameBoardCell(int row, int column) {
        return board[row-1][column-1];
    }

    void setGameBoardCell(Player player, int row, int column) {
        this.board[row-1][column-1] = player.getName();
    }

    boolean isTheCellIntoTheGame(int row, int column) {
        return row >= 1 && row <= ROWS && column >= 1 && column <= COLUMNS;
    }

    boolean isTheCellEmpty(int row, int column) {
        return isTheCellIntoTheGame(row, column) && getGameBoardCell(row, column).equals(" ");
    }

    boolean isVerticalWon(@NotNull Player player) {
        for (int col = 1; col <= COLUMNS; col++) {
            if (    getGameBoardCell(1,col).equals(player.getName()) &&
                    getGameBoardCell(2,col).equals(player.getName()) &&
                    getGameBoardCell(3,col).equals(player.getName())) {
                return true;
            }
        }
        return false;
    }

    boolean isHorizontalWon(Player player) {
        for (int row = 1; row <= COLUMNS; row++) {
            if (    getGameBoardCell(row,1).equals(player.getName()) &&
                    getGameBoardCell(row,2).equals(player.getName()) &&
                    getGameBoardCell(row,3).equals(player.getName())) {
                return true;
            }
        }
        return false;
    }

    boolean isDiagonalWon(Player player) {
        return  getGameBoardCell(1, 1).equals(player.getName()) &&
                getGameBoardCell(2, 2).equals(player.getName()) &&
                getGameBoardCell(3, 3).equals(player.getName()) ||

                getGameBoardCell(1, 3).equals(player.getName()) &&
                getGameBoardCell(2, 2).equals(player.getName()) &&
                getGameBoardCell(3, 1).equals(player.getName());

    }

    boolean isDraw() {
        for (int col = 1; col <= COLUMNS; col++) {
            for (int row = 1; row <= ROWS; row++) {
                if (getGameBoardCell(row, col).equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
