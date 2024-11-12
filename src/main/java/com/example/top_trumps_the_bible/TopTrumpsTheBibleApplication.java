package com.example.top_trumps_the_bible;

import java.awt.GraphicsEnvironment;

import javax.swing.SwingUtilities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.top_trumps_the_bible.controller.GameManager;
import com.example.top_trumps_the_bible.model.Game;
import com.example.top_trumps_the_bible.service.GameService;
import com.example.top_trumps_the_bible.view.GameWindow;

@SpringBootApplication
public class TopTrumpsTheBibleApplication implements CommandLineRunner {

    private final GameService gameService;

    public TopTrumpsTheBibleApplication(GameService gameService) {
        this.gameService = gameService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TopTrumpsTheBibleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Game game = gameService.initializeGame();

        // Check if running in a non-headless environment before launching GUI
        if (!GraphicsEnvironment.isHeadless()) {
            SwingUtilities.invokeLater(() -> {
                GameWindow gameWindow = new GameWindow(game.getPlayer1(), game.getPlayer2());
                GameManager gameManager = new GameManager(game, gameWindow);
                gameWindow.setGameManager(gameManager);
                gameWindow.setVisible(true);
            });
        } else {
            System.out.println("Running in headless mode. GUI will not be displayed.");
        }
    }
}
