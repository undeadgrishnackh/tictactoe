package com.undeadgrishnakch.kata;

import com.undeadgrishnakch.kata.exception.BadPlayer;
import com.undeadgrishnakch.kata.game.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by michele.brissoni@ibm.com on 29/07/2017.
 */
class PlayerTest {
    @DisplayName("Players creation: X, O")
    @ParameterizedTest
    @ValueSource(strings = { "X", "O" })
    void createPlayers(String argument) throws BadPlayer {
        assertEquals(argument, new Player(argument).getName());
    }

    @DisplayName("Player Name not allowed by the game")
    @Test
    void createBadPlayer(){
        Throwable exception = assertThrows(BadPlayer.class, () -> {
            throw new BadPlayer("bad player");
        });

        assertAll("Bad Player creation",
            () -> assertEquals("bad player", exception.getMessage()),
            () -> assertThrows(BadPlayer.class, () -> new Player("BAD")));
    }
}