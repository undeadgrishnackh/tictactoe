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
    private GameBoard gameBoard;
    private GameStatus gameStatus;
    private GameRules gameRules;
    private final Player[] players = new Player[2];
    private Player actualPlayer;
    private static final Logger logger = LogManager.getLogger(TicTacToe.class);


    public TicTacToe() {
        logger.trace("Game creation...");
        this.gameBoard = new GameBoard();
        this.gameStatus = new GameStatus();
        this.gameRules = new GameRules();
        createPlayersXO();
        this.actualPlayer = this.players[0];
        logger.trace("Game created.");
    }



    //------------------------------------------------------ GAME BOARD

    public String showGameBoardASCII(){
        return this.gameBoard.displayGameBoardASCII();
    }

    public String showGameBoardJSON() {
        return this.gameBoard.displayGameBoardJSON();
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }


    //------------------------------------------------------ PLAYERS and ROUND

    private void createPlayersXO() {
        try {
            this.players[0] = new Player("X", this);
            this.players[1] = new Player("O", this);
        } catch (BadPlayer badPlayer) {
            logger.trace(badPlayer.getMessage());
        }
    }

    private Player getPlayer( String playerName) throws BadPlayer {
        switch (playerName) {
            case "X":
                return playerX();
            case "O":
                return playerY();
            default:
                throw new BadPlayer("The player " + playerName + " doesn't exit!");
        }
    }

    private Player playerY() {
        return this.players[1];
    }

    private Player playerX() {
        return this.players[0];
    }

    public Player getActualPlayer() {
        return actualPlayer;
    }

    private void passGameToNextPlayer(){
        if (getActualPlayer() == playerX()) {
            this.actualPlayer = playerY();
        } else this.actualPlayer = playerX();
    }

    //------------------------------------------------------ GAME RESULT
    public String getGameResult() {
        return this.gameStatus.getGameResult();
    }

    public void setGameResult(@NotNull String status) { this.gameStatus.setGameResult(status); }

    //------------------------------------------------------ GAME MOVEMENTS
    public void paintMark(String player, int row, int column) throws BadMove, BadPlayer, GameOver {
        logger.trace("Player {} is moving to r={} c={}", player, row, column);
        this.gameRules.paintMark(this.getPlayer(player), row, column);
        if (!this.gameRules.isGameOverAfterThisMove(this.getPlayer(player))){
            passGameToNextPlayer();
            logger.debug("\n {} {} \n", gameBoard.displayGameBoardASCII(), getGameResult());
        } else {
            logger.debug("\n {} {} \n GAME OVER! :)\n", gameBoard.displayGameBoardASCII(), getGameResult());
        }
    }

    //------------------------------------------------------ GAME TYPEs:
    // BOT VS BOT
    // BOT VS Player
    // Player VS Player
    public void playBotVsBotGame() throws BadPlayer {
        int gameRound = 0;
        logger.debug("Game BOT VS BOT");
        for (; gameRound < 9; gameRound++) {
            try {
                logger.debug("Round {}", gameRound);
                this.getActualPlayer().moveRandom();
            } catch (GameOver gameOverExc) {
                logger.debug("GAME OVER trapped. Exit signal.");
                break;
            }
        }
    }
}
