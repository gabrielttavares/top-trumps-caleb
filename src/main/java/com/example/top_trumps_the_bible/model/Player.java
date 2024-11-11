package com.example.top_trumps_the_bible.model;
import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private List<Character> hand;
	
	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<Character>();
	}
	
	public Character getCurrentCard() {
        return hand.isEmpty() ? null : hand.get(0); // Returns the first card if the hand isn't empty
    }
	
	public void addCards(List<Character> cards) {
		hand.addAll(cards); // Add to bottom of the hand
	}
	
	public Character playCard() {
		if (hand.isEmpty()) {
			return null;
		}
		return hand.remove(0); // Removes and returns top card
	}
	
	public void winCards(List<Character> wonCards) {
		hand.addAll(wonCards); // To the bottom
	}
	
	public boolean hasCards() {
		return !hand.isEmpty();
	}
	
	public String getName() {
		return name;
	}

	public int getCardCount() {
		return hand.size();
	}
}
