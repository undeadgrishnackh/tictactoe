package com.undeadgrishnakch.kata.tictactoe.webapp;

import com.undeadgrishnakch.kata.tictactoe.TicTacToe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TicTacToeGameController {

    @RequestMapping("/")
    public @ResponseBody String homePage(){
        return "Welcome to the TicTacToe Game.";
    }

    @RequestMapping("/getEmptyBoard")
    public @ResponseBody String getEmptyBoard(){
        TicTacToe ticTacToe = new TicTacToe();
        return ticTacToe.showGameBoardJSON();
    }

}
