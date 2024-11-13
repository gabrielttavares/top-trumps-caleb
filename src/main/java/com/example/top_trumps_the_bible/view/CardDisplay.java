package com.example.top_trumps_the_bible.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.top_trumps_the_bible.model.Character;
import com.example.top_trumps_the_bible.controller.GameManager;
import com.example.top_trumps_the_bible.model.Attribute;
import com.example.top_trumps_the_bible.service.BibleApiService;

public class CardDisplay extends JPanel {
    private static final long serialVersionUID = 1L;
    private Character character;
    private BibleApiService bibleApiService;
	private GameManager gameManager;

    public CardDisplay(Character character, BibleApiService bibleApiService) {
        this.character = character;
        this.bibleApiService = bibleApiService;
        setLayout(new GridLayout(0, 1));
        displayCharacterDetails();
    }
    
    public void setController(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    private void displayCharacterDetails() {
        removeAll();  // Clear previous components

        if (character != null) {
            add(new JLabel("Character: " + character.getName()));
            add(new JLabel("Special Ability: " + character.getSpecialAbility()));

            // Display reference link button if available
            if (character.getReferenceLink() != null && !character.getReferenceLink().isEmpty()) {
                JButton referenceButton = new JButton("Read " + character.getName() + "'s Story");
                referenceButton.addActionListener(e -> fetchAndDisplayPassage(character));
                add(referenceButton);
            }

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

    private void fetchAndDisplayPassage(Character character) {
        String bibleId = character.getBibleId();
        String passageId = character.getPassageId();

        // Fetch the passage synchronously
        String passage = bibleApiService.getPassage(bibleId, passageId);

        // Display the passage in a dialog
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JOptionPane.showMessageDialog(this, passage, character.getName() + "'s Story", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void addAttributeButton(String attributeName, Attribute attribute) {
        JButton button = new JButton(attributeName + ": " + character.getAttributeValue(attribute));
        button.addActionListener(e -> {
            System.out.println("Selected attribute: " + attribute);
        });
        add(button);
    }

    public void setCharacter(Character character) {
        this.character = character;
        displayCharacterDetails();
    }
}
