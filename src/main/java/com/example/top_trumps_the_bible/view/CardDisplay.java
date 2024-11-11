package com.example.top_trumps_the_bible.view;
import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.top_trumps_the_bible.controller.GameController;
import com.example.top_trumps_the_bible.model.Character;
import com.example.top_trumps_the_bible.model.Attribute;

public class CardDisplay extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Character character;
	private GameController controller;
	
	public CardDisplay(Character character, GameController controller) {
		this.character = character;
		this.controller = controller;
		setLayout(new GridLayout(0, 1));
		displayCharacterDetails();
	}
	
	public void setController(GameController controller) {
        this.controller = controller;
    }
	
	private void displayCharacterDetails() {
		removeAll();  // Clear previous components
        
        if (character != null) {
            add(new JLabel("Character: " + character.getName()));
            add(new JLabel("Special Ability: " + character.getSpecialAbility()));

            addAttributeButton("Strength", Attribute.STRENGTH);
            addAttributeButton("Wisdom", Attribute.WISDOM);
            addAttributeButton("Faith Level", Attribute.FAITH_LEVEL);
            addAttributeButton("Humility", Attribute.HUMILITY);
        } else {
            add(new JLabel("No character available"));
        }

        revalidate();
        repaint();
	}
	
	private void addAttributeButton(String attributeName, Attribute attribute) {
        JButton button = new JButton(attributeName + ": " + character.getAttributeValue(attribute));
        button.addActionListener(e -> {
            if (controller != null) {
                controller.playRound(attribute);  // Guaranteed to have a non-null controller
            } else {
                System.err.println("Controller is not set in CardDisplay");
            }
        });
        add(button);
	}
	
	public void setCharacter(Character character) {
		this.character = character;
        displayCharacterDetails();
	}
}
