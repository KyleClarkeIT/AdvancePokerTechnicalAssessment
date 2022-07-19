/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package kyle.kc.advance.pokertest;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kyle Clarke
 */
public class TestFiveCardDraw {

    public TestFiveCardDraw() {
    }

    @Test
    void testIsStraightFlush() {
//added cards out of order to test sort for straight results
        Hand hand = new Hand(Arrays.asList(new Card[]{
            new Card(Card.Suit.HEARTS, Card.Rank.TEN),
            new Card(Card.Suit.HEARTS, Card.Rank.KING),
            new Card(Card.Suit.HEARTS, Card.Rank.JACK),
            new Card(Card.Suit.HEARTS, Card.Rank.QUEEN),
            new Card(Card.Suit.HEARTS, Card.Rank.ACE)
        }));

        FiveCardDraw fiveCardRules = new FiveCardDraw();
        assertEquals("Straight Flush", fiveCardRules.evaluateResults(hand));

    }

    @Test
    void testIsStraightFlushLowAce() {
//added cards out of order to test sort for straight results
        Hand hand = new Hand(Arrays.asList(new Card[]{
            new Card(Card.Suit.HEARTS, Card.Rank.THREE),
            new Card(Card.Suit.HEARTS, Card.Rank.FIVE),
            new Card(Card.Suit.HEARTS, Card.Rank.ACE),
            new Card(Card.Suit.HEARTS, Card.Rank.FOUR),
            new Card(Card.Suit.HEARTS, Card.Rank.TWO)
        }));

        FiveCardDraw fiveCardRules = new FiveCardDraw();
        assertEquals("Straight Flush", fiveCardRules.evaluateResults(hand));

    }

    @Test
    void testIsFourOfAKind() {
        Hand hand = new Hand(Arrays.asList(new Card[]{
            new Card(Card.Suit.HEARTS, Card.Rank.FIVE),
            new Card(Card.Suit.CLUBS, Card.Rank.FIVE),
            new Card(Card.Suit.SPADES, Card.Rank.FIVE),
            new Card(Card.Suit.HEARTS, Card.Rank.TWO),
            new Card(Card.Suit.DIAMONDS, Card.Rank.FIVE)
        }));

        FiveCardDraw fiveCardRules = new FiveCardDraw();
        assertEquals("Four of a Kind", fiveCardRules.evaluateResults(hand));

    }

    @Test
    void testIsFullHouse() {
        Hand hand = new Hand(Arrays.asList(new Card[]{
            new Card(Card.Suit.HEARTS, Card.Rank.FIVE),
            new Card(Card.Suit.CLUBS, Card.Rank.FIVE),
            new Card(Card.Suit.SPADES, Card.Rank.FIVE),
            new Card(Card.Suit.HEARTS, Card.Rank.TWO),
            new Card(Card.Suit.DIAMONDS, Card.Rank.TWO)
        }));

        FiveCardDraw fiveCardRules = new FiveCardDraw();
        assertEquals("Full House", fiveCardRules.evaluateResults(hand));

    }

    @Test
    void testIsFlush() {
        Hand hand = new Hand(Arrays.asList(new Card[]{
            new Card(Card.Suit.HEARTS, Card.Rank.TEN),
            new Card(Card.Suit.HEARTS, Card.Rank.ACE),
            new Card(Card.Suit.HEARTS, Card.Rank.FOUR),
            new Card(Card.Suit.HEARTS, Card.Rank.TWO),
            new Card(Card.Suit.HEARTS, Card.Rank.KING)
        }));

        FiveCardDraw fiveCardRules = new FiveCardDraw();
        assertEquals("Flush", fiveCardRules.evaluateResults(hand));

    }

    @Test
    void testIsStraight() {
        //Straight that consists of Ace having the rank value of 14
        Hand hand = new Hand(Arrays.asList(new Card[]{
            new Card(Card.Suit.HEARTS, Card.Rank.TEN),
            new Card(Card.Suit.DIAMONDS, Card.Rank.KING),
            new Card(Card.Suit.HEARTS, Card.Rank.JACK),
            new Card(Card.Suit.HEARTS, Card.Rank.QUEEN),
            new Card(Card.Suit.HEARTS, Card.Rank.ACE)
        }));

        FiveCardDraw fiveCardRules = new FiveCardDraw();
        assertEquals("Straight", fiveCardRules.evaluateResults(hand));

    }

    @Test
    void testIsStraightLowAce() {
        //Straight that consists of Ace having the rank value of 1
        Hand hand = new Hand(Arrays.asList(new Card[]{
            new Card(Card.Suit.HEARTS, Card.Rank.FIVE),
            new Card(Card.Suit.SPADES, Card.Rank.ACE),
            new Card(Card.Suit.HEARTS, Card.Rank.FOUR),
            new Card(Card.Suit.DIAMONDS, Card.Rank.TWO),
            new Card(Card.Suit.HEARTS, Card.Rank.THREE)
        }));

        FiveCardDraw fiveCardRules = new FiveCardDraw();
        assertEquals("Straight", fiveCardRules.evaluateResults(hand));

    }

    @Test
    void testIsThreeOfAKind() {
        Hand hand = new Hand(Arrays.asList(new Card[]{
            new Card(Card.Suit.HEARTS, Card.Rank.FIVE),
            new Card(Card.Suit.CLUBS, Card.Rank.FIVE),
            new Card(Card.Suit.SPADES, Card.Rank.FIVE),
            new Card(Card.Suit.HEARTS, Card.Rank.TWO),
            new Card(Card.Suit.DIAMONDS, Card.Rank.ACE)
        }));

        FiveCardDraw fiveCardRules = new FiveCardDraw();
        assertEquals("Three of a Kind", fiveCardRules.evaluateResults(hand));

    }

    @Test
    void testIsTwoPair() {
        Hand hand = new Hand(Arrays.asList(new Card[]{
            new Card(Card.Suit.HEARTS, Card.Rank.ACE),
            new Card(Card.Suit.DIAMONDS, Card.Rank.ACE),
            new Card(Card.Suit.HEARTS, Card.Rank.FOUR),
            new Card(Card.Suit.CLUBS, Card.Rank.FOUR),
            new Card(Card.Suit.SPADES, Card.Rank.THREE)
        }));

        FiveCardDraw fiveCardRules = new FiveCardDraw();
        assertEquals("Two Pair", fiveCardRules.evaluateResults(hand));

    }

    @Test
    void testIsOnePair() {
        Hand hand = new Hand(Arrays.asList(new Card[]{
            new Card(Card.Suit.HEARTS, Card.Rank.FIVE),
            new Card(Card.Suit.SPADES, Card.Rank.ACE),
            new Card(Card.Suit.CLUBS, Card.Rank.KING),
            new Card(Card.Suit.DIAMONDS, Card.Rank.KING),
            new Card(Card.Suit.HEARTS, Card.Rank.THREE)
        }));

        FiveCardDraw fiveCardRules = new FiveCardDraw();
        assertEquals("One Pair", fiveCardRules.evaluateResults(hand));

    }

    @Test
    void testIsHighCard() {
        Hand hand = new Hand(Arrays.asList(new Card[]{
            new Card(Card.Suit.SPADES, Card.Rank.KING),
            new Card(Card.Suit.DIAMONDS, Card.Rank.ACE),
            new Card(Card.Suit.HEARTS, Card.Rank.FOUR),
            new Card(Card.Suit.HEARTS, Card.Rank.JACK),
            new Card(Card.Suit.HEARTS, Card.Rank.THREE)
        }));

        FiveCardDraw fiveCardRules = new FiveCardDraw();
        assertEquals("High Card", fiveCardRules.evaluateResults(hand));

    }

    @Test
    void testHandCountAboveFive() {
        Deck deck = new Deck();
        Hand hand = new Hand(deck.dealHand(6));
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        assertEquals("Incorrect hand count", fiveCardDraw.evaluateResults(hand));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
