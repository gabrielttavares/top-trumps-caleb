package com.example.top_trumps_the_bible;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.top_trumps_the_bible.model.Attribute;
import com.example.top_trumps_the_bible.model.Character;
import com.example.top_trumps_the_bible.model.Deck;
import com.example.top_trumps_the_bible.model.Game;
import com.example.top_trumps_the_bible.model.Player;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Deck deck;

    @BeforeEach
    void setup() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        
        deck = new Deck(List.of(
            new Character("Samson", "https://bible.com/samson", 80, 40, 30, 3, "Super Strength", "Dan", false),
            new Character("David", "https://bible.com/david", 60, 80, 70, 5, "Leadership", "Judah", true),
            new Character("Goliath", "https://bible.com/goliath", 90, 30, 20, 2, "Brute Strength", "Philistines", false),
            new Character("Moses", "https://bible.com/moses", 50, 70, 80, 4, "Prophecy", "Levi", true)
        ));
        
        game = new Game(player1, player2, deck);
        game.startGame(); // Ensures cards are dealt to both players
    }


    @Test
    void testPlayRound() {
        game.playRound(Attribute.STRENGTH);
        
        String result = game.getLastRoundResult();
        
        assertTrue(result.contains("wins the round with STRENGTH!") || result.equals("It's a tie with STRENGTH!"));
    }
}
