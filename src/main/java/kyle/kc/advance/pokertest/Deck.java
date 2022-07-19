/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kyle.kc.advance.pokertest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Kyle Clarke
 */
public class Deck {

    private List<Card> DeckOfCards;

    public Deck() {
        this.DeckOfCards = new ArrayList();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                this.DeckOfCards.add(new Card(suit, rank));
            }
        }
        Shuffle();
    }

    public void Shuffle() {
        System.out.println("Shuffling...");
        Collections.shuffle(DeckOfCards);
    }

    public List<Card> dealHand(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Requested hand count value to be dealt is incorrect");
        }

        List<Card> hand = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            hand.add(DeckOfCards.get(0)); // top card
            DeckOfCards.remove(0); // top card            
        }

        Collections.sort(hand);
        return hand;
    }

    public int deckSize() {

        return DeckOfCards.size();
    }
}
