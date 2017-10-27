package com.undeadgrishnakch.kata.tictactoe;

import com.undeadgrishnakch.kata.tictactoe.exception.BadMove;
import com.undeadgrishnakch.kata.tictactoe.exception.BadPlayer;
import com.undeadgrishnakch.kata.tictactoe.exception.GameOver;
import com.undeadgrishnakch.kata.tictactoe.game.GameBoard;
import com.undeadgrishnakch.kata.tictactoe.game.GameRules;
import com.undeadgrishnakch.kata.tictactoe.game.Player;
import com.undeadgrishnakch.kata.tictactoe.status.GameStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

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
    private static Logger logger = LogManager.getLogger(TicTacToe.class);


    public TicTacToe() throws BadPlayer {
        logger.trace("Game creation...");
        this.gameBoard = new GameBoard();
        this.gameStatus = new GameStatus();
        this.gameRules = new GameRules();
        this.players[0] = new Player("X", this);
        this.players[1] = new Player("O", this);
        this.round = this.players[0];
        logger.trace("Game created.");
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

    public Player getActualRoundPlayer() {
        return round;
    }

    private void nextRound(){
        if (getActualRoundPlayer() == this.players[0]) {
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
    public void move(String player, int row, int column) throws BadMove, BadPlayer, GameOver {
        logger.trace("Player " + player + " is moving to r="+row+" c="+column);
        this.gameRules.move(this.getPlayer(player),row,column);
        if (!this.gameRules.isGameOverAfterThisMove(this.getPlayer(player))){
            nextRound();
            logger.debug("\n" + gameBoard.displayGameBoard() + getGameResult() + "\n");
        } else {
            logger.debug("\n" + gameBoard.displayGameBoard() + getGameResult() + "\n" + "GAME OVER! :)\n");
        }
    }

    //------------------------------------------------------ GAME TYPEs:
    // BOT VS BOT
    // BOT VS Player
    // Player VS Player
    public void playBotVsBotGame() throws BadPlayer {
        int round = 0;
        logger.debug("Game BOT VS BOT");
        for (; round < 9; round++) {
            try {
                logger.debug("Round " + round);
                this.getActualRoundPlayer().moveRandom();
            } catch (GameOver gameOverExc) {
                logger.debug("GAME OVER trapped. Exit signal.");
                break;
            }
        }
    }

}
