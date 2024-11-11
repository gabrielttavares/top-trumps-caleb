package controller;

import model.Attribute;
import model.Game;
import view.GameWindow;

public class GameController {
    private Game game;
    private GameWindow view;

    public GameController(Game game) {
        this.game = game;
    }

    // Play a round with the selected attribute
    public void playRound(Attribute attribute) {
        game.playRound(attribute);

        view.updateRoundResult(game.getLastRoundResult());
        view.refreshCardDisplays(game.getPlayer1(), game.getPlayer2());
    }
}