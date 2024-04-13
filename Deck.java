package juegocartas;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        String color;
        String[] suits = {"treboles", "corazones", "picas", "diamantes"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String suit : suits) {
            if (suit.equals("treboles") || suit.equals("picas")) {
                color = "negro";
            } else {
                color = "rojo";
            }
            for (String value : values) {
                Card card = new Card(suit, color, value);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public Card head() throws Exception {
        if (cards.isEmpty()) {
            throw new Exception("Se han agotado las cartas");
        }
        Card card = cards.remove(0);
        System.out.println("La primera carta del deck es: " + card);
        System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
        return card;
    }

    public Card pick() throws Exception {
        if (cards.isEmpty()) {
            throw new Exception("Se han agotado las cartas");
        }
        int randomIndex = (int) (Math.random() * cards.size());
        Card card = cards.remove(randomIndex);
        System.out.println("La carta que te salió es: " + card);
        System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
        return card;
    }

    public ArrayList<Card> hand(int numCards) throws Exception {
        if (cards.size() < numCards) {
            throw new Exception("Se han agotado las cartas");
        }
        ArrayList<Card> hand = new ArrayList<Card>();
        System.out.println("Estas son tus cartas: ");
        for (int i = 0; i < numCards; i++) {
            Card card = pick();
            hand.add(card);
        }
        return hand;
    }
}
