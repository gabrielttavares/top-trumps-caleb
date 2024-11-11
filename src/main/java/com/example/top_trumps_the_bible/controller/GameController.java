package com.example.top_trumps_the_bible.controller;

import com.example.top_trumps_the_bible.model.Attribute;
import com.example.top_trumps_the_bible.model.Game;
import com.example.top_trumps_the_bible.view.GameWindow;

public class GameController {
    private Game game;
    private GameWindow view;

    public GameController(Game game, GameWindow view) {
        this.game = game;
        this.view = view;
    }

	// Play a round with the selected attribute
    public void playRound(Attribute attribute) {
        game.playRound(attribute);

        // Ensure view is not null
        if (view != null) {
            view.updateRoundResult(game.getLastRoundResult());
            view.refreshCardDisplays(game.getPlayer1(), game.getPlayer2());

            if (game.isGameOver()) {
                view.displayGameOver(game.getWinner());
            }
        } else {
            System.err.println("GameWindow (view) is not initialized in GameController.");
        }
    }
}