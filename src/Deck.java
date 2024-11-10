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
	
	public List<Character> deal(int numberOfCards) {
		List<Character> hand = new ArrayList<>(cards.subList(0, numberOfCards));
		cards.subList(0, numberOfCards).clear();
		return hand;
	}
	
	public boolean isEmpty() {
		return cards.isEmpty();
	}
}
