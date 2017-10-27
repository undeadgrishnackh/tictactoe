package com.undeadgrishnakch.kata.tictactoe.status;

/**
 * Game sub class that define the possible game status.
 *
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
public class GameStatus {
    public static final String IN_PROGRESS = "in progress...";
    public static final String PLAYER_X_WON = "PLAYER X WON";
    public static final String PLAYER_O_WON = "PLAYER O WON";
    public static final String DRAW = "GAME ENDS WITH A DRAW!";
    private String gameResult = "";

    public GameStatus() {
        this.gameResult = GameStatus.IN_PROGRESS;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

}
