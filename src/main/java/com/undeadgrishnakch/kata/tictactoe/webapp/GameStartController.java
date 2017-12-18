package com.undeadgrishnakch.kata.tictactoe.webapp;

import com.undeadgrishnakch.kata.tictactoe.TicTacToe;
import com.undeadgrishnakch.kata.tictactoe.exception.BadPlayer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameStartController {

    @RequestMapping("/")
    public String gameStart (){
        try {
            TicTacToe ticTacToe = new TicTacToe();
            return ticTacToe.showGameBoard();
        } catch (BadPlayer badPlayer) {
            badPlayer.printStackTrace();
        }
        return "";
    }
}
