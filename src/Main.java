import java.sql.Connection;
import javax.swing.SwingUtilities;

import controller.GameController;
import model.Character;
import model.Characters;
import model.Deck;
import model.Game;
import model.Player;
import view.GameWindow;
import util.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = dbConnection.connect();

        Characters characters = new Characters();
        characters.loadCharacterFromDatabase(connection);
        
        // Display all characters in console (for debugging)
        characters.displayAllCharacters();

        // Close database connection
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Pass the characters list to the Deck constructor
        Deck deck = new Deck(characters.getCharacterList());
        
        Game game = new Game(player1, player2, deck);
        game.startGame();

        // Initialize the main game window, passing in game and controller
        SwingUtilities.invokeLater(() -> {
            GameWindow gameWindow = new GameWindow(player1, player2);
            GameController controller = new GameController(game, gameWindow);
            gameWindow.setController(controller);
            gameWindow.setVisible(true);
        });

    }
}
