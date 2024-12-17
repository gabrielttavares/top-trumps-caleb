package com.example.top_trumps_the_bible.view;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.example.top_trumps_the_bible.controller.GameManager;
import com.example.top_trumps_the_bible.model.Player;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private GameManager gameManager;
	private CardDisplay player1CardDisplay;
	private CardDisplay player2CardDisplay;
	private JLabel roundResultLabel;
	
	public GameWindow(Player player1, Player player2) {		
		setTitle("Top Trumps - The Bible");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		player1CardDisplay = new CardDisplay(player1.getCurrentCard(), null);
		player2CardDisplay = new CardDisplay(player2.getCurrentCard(), null);
		
		add(player1CardDisplay, BorderLayout.WEST);
		add(player2CardDisplay, BorderLayout.EAST);
		
		roundResultLabel = new JLabel("Select an attribute to start the round.");
		add(roundResultLabel, BorderLayout.SOUTH);
	}
	
	// Method to set the GameManager after GameWindow creation
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
        player1CardDisplay.setController(gameManager);
        player2CardDisplay.setController(gameManager);
    }
	
	public void updateRoundResult(String result) {
		roundResultLabel.setText(result);
	}
	
	public void refreshCardDisplays(Player player1, Player player2) {
		player1CardDisplay.setCharacter(player1.getCurrentCard());
		player2CardDisplay.setCharacter(player2.getCurrentCard());
		
		player1CardDisplay.revalidate();
        player1CardDisplay.repaint();
        player2CardDisplay.revalidate();
        player2CardDisplay.repaint();
	}

	public void displayGameOver(String winner) {
		JOptionPane.showMessageDialog(this, winner + " wins the game!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		roundResultLabel.setText("Game Over. " + winner + " is the winner!");
	}
}
