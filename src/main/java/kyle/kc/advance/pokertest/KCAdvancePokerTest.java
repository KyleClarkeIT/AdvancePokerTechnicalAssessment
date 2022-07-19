/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package kyle.kc.advance.pokertest;

import java.util.Arrays;

/**
 *
 * @author Kyle Clarke
 */
public class KCAdvancePokerTest {

    public static void main(String[] args) {
        Deck deck = new Deck();

        Hand hand = new Hand(deck.dealHand(5));//deal a new hand with a size of 5

        FiveCardDraw fiveCardRuleSet = new FiveCardDraw();//instantiating the rule set

        System.out.println("Your hand: " + hand.toString());//displaying hand
        System.out.println(fiveCardRuleSet.evaluateResults(hand)); //sending through the cards drawn into the logic class
        
        
        System.out.println();
    }
}
