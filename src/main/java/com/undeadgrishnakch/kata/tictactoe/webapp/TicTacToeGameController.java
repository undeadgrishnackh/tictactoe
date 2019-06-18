package com.undeadgrishnakch.kata.tictactoe.webapp;

import com.undeadgrishnakch.kata.tictactoe.TicTacToe;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicTacToeGameController {

    @RequestMapping("/")
    public String homePage(){
        return "Welcome to the TicTacToe Game.";
    }

    @RequestMapping("/getEmptyBoard")
    public String getEmptyBoard(){
        TicTacToe ticTacToe = new TicTacToe();
        return ticTacToe.showGameBoardJSON();
    }

}
