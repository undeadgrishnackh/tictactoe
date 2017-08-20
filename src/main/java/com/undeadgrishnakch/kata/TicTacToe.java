package com.undeadgrishnakch.kata;

import com.undeadgrishnakch.kata.exception.BadMove;
import com.undeadgrishnakch.kata.exception.BadPlayer;
import com.undeadgrishnakch.kata.game.GameBoard;
import com.undeadgrishnakch.kata.game.GameRules;
import com.undeadgrishnakch.kata.game.Player;
import com.undeadgrishnakch.kata.status.GameStatus;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * Tic Tac Toe Kata developed in TDD mode to show TDD
 * development in a workshop training.
 *
 * THIS Class is the game master class.
 *
 * Created by michele.brissoni@ibm.com on 23/07/2017.
 */
public class TicTacToe {
    private GameBoard gameBoard = null;
    private GameStatus gameStatus = null;
    private GameRules gameRules = null;
    private final Player[] players = new Player[2];
    private Player round = null;

    public TicTacToe() throws BadPlayer {
        this.gameBoard = new GameBoard();
        this.gameStatus = new GameStatus();
        this.gameRules = new GameRules();
        this.players[0] = new Player("X", this);
        this.players[1] = new Player("O", this);
        this.round = this.players[0];
    }

    //------------------------------------------------------ GAME BOARD

    public String showGameBoard(){
        return this.gameBoard.displayGameBoard();
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    //------------------------------------------------------ PLAYERS and ROUND

    private Player getPlayer( String player) throws BadPlayer {
        switch (player) {
            case "X":
                return this.players[0];
            case "O":
                return this.players[1];
            default:
                throw new BadPlayer("The player " + player + " doesn't exit!");
        }
    }

    public Player getRound() {
        return round;
    }

    private void nextRound(){
        if (getRound() == this.players[0]) {
            this.round = this.players[1];
        } else this.round = this.players[0];
    }

    //------------------------------------------------------ GAME RESULT
    public String getGameResult() {
        return this.gameStatus.getGameResult();
    }

    public void setGameResult(@NotNull String status) {
        this.gameStatus.setGameResult(status);
    }

    //------------------------------------------------------ GAME MOVEMENTS
    public void move(String player, int row, int column) throws BadMove, BadPlayer {
        this.gameRules.move(this.getPlayer(player),row,column);
        if (!this.gameRules.isGameOverAfterThisMove(this.getPlayer(player))){
            nextRound();
            System.out.println(gameBoard.displayGameBoard() + getGameResult() + "\n");
        } else {
            System.out.println(gameBoard.displayGameBoard() + getGameResult() + "\n" + "GAME OVER! :)\n");
        }
    }

    //------------------------------------------------------ GAME TYPE:
    // BOT VS BOT
    // BOT VS Player
    // Player VS Player
    public void generateGame() throws BadPlayer {
        Random random = new Random();
        int r, c, maxRounds = 0;
        while (maxRounds < 9) { //at max 9 movements
            try {
                r = random.nextInt(3)+1;
                c = random.nextInt(3)+1; //TODO: refactor this piece of code with a new PlayerBot class to test the random movements range.
                this.move(this.getRound().getName(), r, c);
            } catch (BadMove badMove) {
                continue;
            }
            maxRounds++;
        }
    }

}
