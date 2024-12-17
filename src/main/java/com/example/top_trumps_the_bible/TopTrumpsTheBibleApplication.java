package com.example.top_trumps_the_bible;

import java.awt.GraphicsEnvironment;

import javax.swing.SwingUtilities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
        System.setProperty("java.awt.headless", "false"); // Local
        SpringApplication.run(TopTrumpsTheBibleApplication.class, args);
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) {
        Game game = gameService.startNewGame();

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
