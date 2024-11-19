package com.example.top_trumps_the_bible.service;

import com.example.top_trumps_the_bible.model.Attribute;
import com.example.top_trumps_the_bible.model.Character;
import com.example.top_trumps_the_bible.model.Characters;
import com.example.top_trumps_the_bible.model.Deck;
import com.example.top_trumps_the_bible.model.Game;
import com.example.top_trumps_the_bible.model.Player;
import com.example.top_trumps_the_bible.repository.CharacterRepository;
import com.example.top_trumps_the_bible.controller.GameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final CharacterRepository characterRepository;
    private GameManager gameManager;
    private Game game;

    @Autowired
    @Lazy
    private BibleApiService bibleApiService;

    public GameService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Game startNewGame() {
        List<Character> characterList = characterRepository.findAll();
        Characters characters = new Characters(characterList);

        for (Character character : characters.getCharacterList()) {
            // Retrieve and set the passage if not already set
            if (character.getReferenceLink() == null || character.getReferenceLink().isEmpty()) {
                String passage = getCharacterPassage(character);
                character.setReferenceLink(passage);
                characterRepository.save(character);
            }
        }

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Deck deck = new Deck(characters.getCharacterList());
        game = new Game(player1, player2, deck);
        game.startGame();

        gameManager = new GameManager(game, null); // null for GameWindow in headless mode
        return game;
    }

    public String playRound(String attributeName) {
        Attribute attribute;
        try {
            attribute = Attribute.valueOf(attributeName.toUpperCase());
        } catch (IllegalArgumentException e) {
            return "Invalid attribute selected.";
        }

        gameManager.playRound(attribute);
        return game.getLastRoundResult();
    }

    public Game getCurrentGameStatus() {
        return game;
    }

    // Fetch and return the passage for a specific character using BibleApiService
    public String getCharacterPassage(Character character) {
        String bibleId = "179568874c45066f-01";
        String passageId = character.getPassageId();

        return bibleApiService.getPassage(bibleId, passageId);
    }
}