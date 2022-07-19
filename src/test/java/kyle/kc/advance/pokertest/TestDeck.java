/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package kyle.kc.advance.pokertest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kyle Clarke
 */
public class TestDeck {
    
    public TestDeck() {
    }
    
    @Test
    void testDeck() {
        Deck deck = new Deck();
        assertEquals(52, deck.deckSize());
    }

    @Test
    void testShuffle() {
        Deck deck = new Deck();
        deck.Shuffle();

        assertNotEquals(new Deck(), deck);
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
