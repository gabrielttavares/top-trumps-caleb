package com.example.top_trumps_the_bible;

import com.example.top_trumps_the_bible.model.Character;
import com.example.top_trumps_the_bible.model.Game;
import com.example.top_trumps_the_bible.repository.CharacterRepository;
import com.example.top_trumps_the_bible.service.GameService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class GameServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInitializeGame() {
        List<Character> mockCharacters = Arrays.asList(
            new Character("David", 80, 90, 70, 4.0f, "Bravery", "Judah", true),
            new Character("Goliath", 95, 50, 40, 2.0f, "Strength", "Philistines", false)
        );

        when(characterRepository.findAll()).thenReturn(mockCharacters);

        Game game = gameService.initializeGame();
        assertNotNull(game);
        assertNotNull(game.getPlayer1());
        assertNotNull(game.getPlayer2());
    }
}
