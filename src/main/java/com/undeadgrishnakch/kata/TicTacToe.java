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
    private Player round = null;

    public TicTacToe() throws BadPlayer {
        this.gameBoard = new GameBoard();
        this.players[0] = new Player("X", this);
        this.players[1] = new Player("O", this);
        this.round = this.players[0];
    }

    public String showGameBoard(){
        return this.gameBoard.getGameBoard();
    }


    public Player getPlayerName(int i) throws BadPlayer {
        if (i == 0 || i == 1){
            return this.players[i];
        } else throw new BadPlayer("The selected Player doesn't exist!");
    }

    public void move(String player, int row, int column) throws BadMove, BadPlayer {
        //TODO: the game rules for the moment is static
        GameRules.move(this.getPlayer(player),row,column);
        nextRound();
    }

    private Player getPlayer(String player) throws BadPlayer {
        switch (player) {
            case "X":
                return this.players[0];
            case "O":
                return this.players[1];
            default:
                throw new BadPlayer("The player " + player + " doesn't exit!");
        }
    }

    public String getGameResult() {
        return this.gameResult;
    }

    public boolean isYourRound(Player player) {
        if ( player.getName().equals(this.getRound().getName())) {
            return true;
        } else return false;
    }

    public Player getRound() {
        return round;
    }

    public void nextRound(){
        if (getRound() == this.players[0]) {
            this.round = this.players[1];
        } else this.round = this.players[0];
    }

    public boolean moveAllowed(int row, int column) {
        return this.gameBoard.isTheCellIntoTheGame(row, column);
    }

    /*public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.showGameBoard();
    }*/
}
