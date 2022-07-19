package kyle.kc.advance.pokertest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kyle Clarke
 */
public class TestCard{

    @Test
    void testGetSuit() {
        Card card = new Card(Card.Suit.HEARTS, Card.Rank.FIVE);
        assertEquals("H", card.getSuit());
    }

    @Test
    void testGetESuit() {
        Card card = new Card(Card.Suit.DIAMONDS, Card.Rank.ACE);
        assertEquals(Card.Suit.DIAMONDS, card.getESuit());
    }

    @Test
    void testGetRank() {
        Card card = new Card(Card.Suit.SPADES, Card.Rank.KING);
        assertEquals(13, card.getRank());
    }

    @Test
    void testGetERank() {
        Card card = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        assertEquals(Card.Rank.ACE, card.getERank());
    }

    @Test
    void testNotEqualsSuit() {
        Card firstCard = new Card(Card.Suit.HEARTS, Card.Rank.FIVE);
        Card secondCard = new Card(Card.Suit.DIAMONDS, Card.Rank.FIVE);
        assertFalse(firstCard.equals(secondCard));
    }

    @Test
    void testNotEqualsRank() {
        Card firstCard = new Card(Card.Suit.HEARTS, Card.Rank.FIVE);
        Card secondCard = new Card(Card.Suit.HEARTS, Card.Rank.THREE);
        assertFalse(firstCard.equals(secondCard));
    }

    @Test
    void testisEquals() {
        Card firstCard = new Card(Card.Suit.SPADES, Card.Rank.THREE);
        Card secondCard = new Card(Card.Suit.SPADES, Card.Rank.THREE);
        assertTrue(firstCard.equals(secondCard));
    }

    @Test
    void compareTo() {
        Card firstCard = new Card(Card.Suit.HEARTS, Card.Rank.FIVE);
        Card secondCard = new Card(Card.Suit.SPADES, Card.Rank.THREE);

        assertEquals(1, firstCard.compareTo(secondCard));//testing if first card has a higher rank
        assertEquals(-1, secondCard.compareTo(firstCard));//testing if second card has a lower rank

        Card thirdCard = new Card(Card.Suit.HEARTS, Card.Rank.FIVE);
        Card fourthCard = new Card(Card.Suit.DIAMONDS, Card.Rank.THREE);      

        assertEquals(0, thirdCard.compareTo(firstCard));//making sure that it is equals with same rank and suit
        assertEquals(0, fourthCard.compareTo(secondCard));//making sure that it is equals with same rank but different suit
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
