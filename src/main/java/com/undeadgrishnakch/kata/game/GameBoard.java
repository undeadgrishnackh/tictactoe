package com.undeadgrishnakch.kata.game;

import com.undeadgrishnakch.kata.exception.BadMove;
import org.jetbrains.annotations.NotNull;

/**
 * GameBoard class to create the playground and the
 * logic to understand who is where --> players vs
 * space matrix
 *
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
public class GameBoard {
    static private final int rows = 3;
    static private final int columns = 3;
    private String gameBoard[][] = null;

    public GameBoard() {
        this.gameBoard = new String[][] {{" "," "," "},{" "," "," "},{" "," "," "}};
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
        return gameBoard[row-1][column-1];
    }

    void setGameBoardCell(Player player, int row, int column) {
        this.gameBoard[row-1][column-1] = player.getName();
    }

    public boolean isTheCellIntoTheGame(int row, int column) {
        return row >= 1 && row <= rows && column >= 1 && column <= columns;
    }

    public boolean isTheCellEmpty(int row, int column) throws BadMove {
        if (isTheCellIntoTheGame( row,  column)){
            return getGameBoardCell(row, column).equals(" ");
        } else throw new BadMove("Move out of the game!");  //TODO: techdebt - refactor throw mechanism above
    }

    public boolean isVerticalWon(@NotNull Player player) {
        for (int col = 1; col <= columns; col++) {
            if (    getGameBoardCell(1,col).equals(player.getName()) &&
                    getGameBoardCell(2,col).equals(player.getName()) &&
                    getGameBoardCell(3,col).equals(player.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean isHorizontalWon(Player player) {
        for (int row = 1; row <= columns; row++) {
            if (    getGameBoardCell(row,1).equals(player.getName()) &&
                    getGameBoardCell(row,2).equals(player.getName()) &&
                    getGameBoardCell(row,3).equals(player.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean isDiagonalWon(Player player) {
        if (    getGameBoardCell(1,1).equals(player.getName()) &&
                getGameBoardCell(2,2).equals(player.getName()) &&
                getGameBoardCell(3,3).equals(player.getName())) {
            return true;
        }

        if (    getGameBoardCell(1,3).equals(player.getName()) &&
                getGameBoardCell(2,2).equals(player.getName()) &&
                getGameBoardCell(3,1).equals(player.getName())) {
            return true;
        }
        return false;
    }

    public boolean isDraw(Player player) {
        for (int col = 1; col <= columns; col++) {
            for (int row = 1; row <= rows; row++) {
                if (getGameBoardCell(row, col).equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
