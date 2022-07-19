/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package kyle.kc.advance.pokertest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kyle Clarke
 */
public class TestHand {

    public TestHand() {
    }

    @Test
    void testHand() {

        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.KING));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.JACK));
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));

        Hand hand = new Hand(cards);

        List<Card> cardsSorted = new ArrayList<>();
        cardsSorted.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        cardsSorted.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));
        cardsSorted.add(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        cardsSorted.add(new Card(Card.Suit.CLUBS, Card.Rank.JACK));
        cardsSorted.add(new Card(Card.Suit.SPADES, Card.Rank.KING));

        assertEquals(cardsSorted, hand.getHand());
    }

    @Test
    void testRankMap() {

        List<Card> firstSortedCards = new ArrayList<>();
        firstSortedCards.add(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        firstSortedCards.add(new Card(Card.Suit.SPADES, Card.Rank.KING));
        firstSortedCards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        firstSortedCards.add(new Card(Card.Suit.CLUBS, Card.Rank.JACK));
        firstSortedCards.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));

        Hand firsthand = new Hand(firstSortedCards);

        List<Card> secondSortedCards = new ArrayList<>();
        secondSortedCards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        secondSortedCards.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));
        secondSortedCards.add(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        secondSortedCards.add(new Card(Card.Suit.CLUBS, Card.Rank.JACK));
        secondSortedCards.add(new Card(Card.Suit.SPADES, Card.Rank.KING));

        Hand secondhand = new Hand(secondSortedCards);
        
        assertEquals(firsthand.getRankMap(), secondhand.getRankMap());
    }

    @Test
    void testSuitMap() {

        List<Card> firstSortedCards = new ArrayList<>();
        firstSortedCards.add(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        firstSortedCards.add(new Card(Card.Suit.SPADES, Card.Rank.KING));
        firstSortedCards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        firstSortedCards.add(new Card(Card.Suit.CLUBS, Card.Rank.JACK));
        firstSortedCards.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));

        Hand firsthand = new Hand(firstSortedCards);

        List<Card> secondSortedCards = new ArrayList<>();
        secondSortedCards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        secondSortedCards.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));
        secondSortedCards.add(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        secondSortedCards.add(new Card(Card.Suit.CLUBS, Card.Rank.JACK));
        secondSortedCards.add(new Card(Card.Suit.SPADES, Card.Rank.KING));

        Hand secondhand = new Hand(secondSortedCards);
        
        assertEquals(firsthand.getSuitMap(), secondhand.getSuitMap());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
