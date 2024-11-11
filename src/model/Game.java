package model;

import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private Deck deck;
    private int tieCount;
    private String lastRoundResult;

    public Game(Player player1, Player player2, Deck deck) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = deck;
    }

    // Helper method to compare attribute values between two cards
    private static <T> int compareValues(Comparable<?> value1, Comparable<?> value2) {
        @SuppressWarnings("unchecked")
        Comparable<Object> comparable1 = (Comparable<Object>) value1;
        return comparable1.compareTo(value2);
    }

    public void startGame() {
        deck.shuffle();
        player1.addCards(deck.deal(deck.getSize() / 2));
        player2.addCards(deck.deal(deck.getSize() / 2));
        tieCount = 1;
        lastRoundResult = "Game started. Players have their cards.";
    }

    public void playRound(Attribute attribute) {
        Character card1 = player1.playCard();
        Character card2 = player2.playCard();

        if (card1 == null || card2 == null) {
            lastRoundResult = "One of the players has no cards left. Game over.";
            return;
        }

        System.out.println("Comparing attribute: " + attribute);

        Comparable<?> value1 = card1.getAttributeValue(attribute);
        Comparable<?> value2 = card2.getAttributeValue(attribute);

        int comparisonResult = compareValues(value1, value2);

        if (comparisonResult > 0) {
            lastRoundResult = player1.getName() + " wins the round with " + attribute + "!";
            player1.winCards(List.of(card1, card2));
            tieCount = 1;
        } else if (comparisonResult < 0) {
            lastRoundResult = player2.getName() + " wins the round with " + attribute + "!";
            player2.winCards(List.of(card1, card2));
            tieCount = 1;
        } else {
            lastRoundResult = "It's a tie with " + attribute + "! Next round is worth more.";
            tieCount++;
            player1.addCards(List.of(card1));
            player2.addCards(List.of(card2));
        }
    }

    public String getLastRoundResult() {
        return lastRoundResult;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}