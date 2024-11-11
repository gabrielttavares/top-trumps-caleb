package com.example.top_trumps_the_bible.service;

import com.example.top_trumps_the_bible.model.Character;
import com.example.top_trumps_the_bible.model.Characters;
import com.example.top_trumps_the_bible.model.Deck;
import com.example.top_trumps_the_bible.model.Game;
import com.example.top_trumps_the_bible.model.Player;
import com.example.top_trumps_the_bible.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final CharacterRepository characterRepository;

    public GameService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Game initializeGame() {
        // Load characters from the database
        List<Character> characterList = characterRepository.findAll();
        Characters characters = new Characters(characterList);

        // Initialize players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Create deck and game
        Deck deck = new Deck(characters.getCharacterList());
        Game game = new Game(player1, player2, deck);
        game.startGame();

        return game;
    }
}
