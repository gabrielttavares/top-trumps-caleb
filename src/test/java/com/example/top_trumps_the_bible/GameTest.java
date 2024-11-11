package com.example.top_trumps_the_bible;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.top_trumps_the_bible.model.Attribute;
import com.example.top_trumps_the_bible.model.Deck;
import com.example.top_trumps_the_bible.model.Game;
import com.example.top_trumps_the_bible.model.Player;
import com.example.top_trumps_the_bible.model.Character;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class GameTest {
	
    private Player player1;
    private Player player2;
    private Game game;

    @BeforeEach
    public void setUp() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
    
	    Deck deck = new Deck(List.of(
	        new Character("David", 80, 90, 70, 4.0f, "Bravery", "Judah", true),
	        new Character("Goliath", 95, 50, 40, 2.0f, "Strength", "Philistines", false)
	    ));
	    
	    game = new Game(player1, player2, deck);
	    game.startGame();
    }

	@Test
	public void testPlayRound() {
	    game.playRound(Attribute.STRENGTH);
	    String result = game.getLastRoundResult();
	    assertEquals("Player 2 wins the round with STRENGTH!", result);
	}
}