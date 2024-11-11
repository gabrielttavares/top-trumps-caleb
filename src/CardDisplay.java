import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardDisplay extends JPanel {
	private Character character;
	
	public CardDisplay(Character character) {
		this.character = character;
		setLayout(new GridLayout(0, 1));
		displayCharacterDetails();
	}
	
	public void setCharacter(Character character) {
		this.character = character;
		removeAll();
        displayCharacterDetails();
        revalidate();
        repaint();
	}
	
	private void displayCharacterDetails() {
		add(new JLabel("Character: " + character.getName()));
		add(new JLabel("Special Ability: " + character.getSpecialAbility()));
		
		addAttributeLabel("Strength", character.getStrength());
        addAttributeLabel("Wisdom", character.getWisdom());
        addAttributeLabel("Faith Level", character.getFaithLevel());
        addAttributeLabel("Humility", character.getHumility());
        addAttributeLabel("Tribe", character.getTribe());
        addAttributeLabel("Leader", character.getIsLeader());
	}
	
	private void addAttributeLabel(String attributeName, Object value) {
		JLabel label = new JLabel(attributeName + ": " + value);
		add(label);
	}
}
