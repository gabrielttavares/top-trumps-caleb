package com.example.top_trumps_the_bible.controller;

import com.example.top_trumps_the_bible.model.Attribute;
import com.example.top_trumps_the_bible.model.Game;
import com.example.top_trumps_the_bible.view.GameWindow;

public class GameManager {
    private Game game;
    private GameWindow view; // Nullable, used only for GUI mode

    public GameManager(Game game, GameWindow view) {
        this.game = game;
        this.view = view;
    }

    // Play a round with the selected attribute
    public void playRound(Attribute attribute) {
        game.playRound(attribute);

        // If view is set, update GUI; otherwise, just perform logic for API response
        if (view != null) {
            view.updateRoundResult(game.getLastRoundResult());
            view.refreshCardDisplays(game.getPlayer1(), game.getPlayer2());

            if (game.isGameOver()) {
                view.displayGameOver(game.getWinner());
            }
        }
    }
}
