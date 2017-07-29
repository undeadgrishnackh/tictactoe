package com.undeadgrishnakch.kata;

import com.undeadgrishnakch.kata.exception.BadMove;
import com.undeadgrishnakch.kata.exception.BadPlayer;
import com.undeadgrishnakch.kata.game.GameBoard;
import com.undeadgrishnakch.kata.game.GameRules;
import com.undeadgrishnakch.kata.game.Player;
import com.undeadgrishnakch.kata.status.GameStatus;

/**
 * Tic Tac Toe Kata developed in TDD mode to show TDD
 * development in a workshop training.
 *
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
public class TicTacToe {
    private GameBoard gameBoard = null;
    private final Player[] players = new Player[2];
    private final String gameResult = GameStatus.IN_PROGRESS;

    public TicTacToe() throws BadPlayer {
        this.gameBoard = new GameBoard();
        this.players[0] = new Player("X");
        this.players[1] = new Player("O");
    }

    public String showGameBoard(){
        return this.gameBoard.getGameBoard();
    }


    public Player getPlayerName(int i) throws BadPlayer {
        if (i == 0 || i == 1){
            return this.players[i];
        } else throw new BadPlayer("The selected Player doesn't exist!");
    }

    public void move(String player, int row, int column) throws BadMove {
        GameRules.move(player,row,column);
    }

    public String getGameResult() {
        return this.gameResult;
    }

    /*public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.showGameBoard();
    }*/
}
