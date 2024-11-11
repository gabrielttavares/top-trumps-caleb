import java.awt.BorderLayout;
import java.security.PublicKey;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameWindow extends JFrame {
	private CardDisplay player1CardDisplay;
	private CardDisplay player2CardDisplay;
	private JLabel roundResultLabel;
	
	public GameWindow(Player player1, Player player2) {
		setTitle("Top Trumps - The Bible");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		player1CardDisplay = new CardDisplay(player1.getCurrentCard());
		player2CardDisplay = new CardDisplay(player2.getCurrentCard());
		
		add(player1CardDisplay, BorderLayout.WEST);
		add(player2CardDisplay, BorderLayout.EAST);
		
		roundResultLabel = new JLabel("Round results will appear here.");
		add(roundResultLabel, BorderLayout.SOUTH);
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
}
