package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Character> cards;
	
	public Deck(List<Character>characters) {
		this.cards = new ArrayList<Character>(characters);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	// Returns a sublist of the first `numberOfCards` and remove them from the deck
	public List<Character> deal(int numberOfCards) {
		List<Character> hand = new ArrayList<>(cards.subList(0, numberOfCards));
		cards.subList(0, numberOfCards).clear();
		return hand;
	}
	
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
	public int getSize() {
        return cards.size();
    }
}
