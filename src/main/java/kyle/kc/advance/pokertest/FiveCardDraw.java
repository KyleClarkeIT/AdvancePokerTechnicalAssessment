/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kyle.kc.advance.pokertest;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Kyle Clarke
 */
public class FiveCardDraw {

    public String evaluateResults(Hand fiveHand) {
        if (fiveHand.getHand().size()>5||fiveHand.getHand().size()<=0) {
            System.out.println("Invalid hand count, current count is "+fiveHand.getHand().size());
            return Results.INVALID_HAND.getResult();
        }
        if (isStraightFlush(fiveHand)) {
            return Results.STRAIGHT_FLUSH.getResult();
        }
        if (isStraightFlushLowAce(fiveHand)) {
            return Results.STRAIGHT_FLUSH.getResult();
        }
        if (isFourOfAKind(fiveHand)) {
            return Results.FOUR_OF_A_KIND.getResult();
        }
        if (isFullHouse(fiveHand)) {
            return Results.FULL_HOUSE.getResult();
        }
        if (isFlush(fiveHand)) {
            return Results.FLUSH.getResult();
        }
        if (isStraight(fiveHand)) {
            return Results.STRAIGHT.getResult();
        }
        if (isStraightWithAceAsOne(fiveHand)) {
            return Results.STRAIGHT.getResult();
        }
        if (isThreeOfAKind(fiveHand)) {
            return Results.THREE_OF_A_KIND.getResult();
        }
        if (isTwoPairs(fiveHand)) {

            return Results.TWO_PAIR.getResult();
        }
        if (isOnePair(fiveHand)) {
            return Results.ONE_PAIR.getResult();
        }
        return Results.HIGH_CARD.getResult();
    }

    private boolean isStraightFlush(Hand playerHand) {
        return isStraight(playerHand) && isFlush(playerHand);//Checks for three of a kind and one pair
    }

    private boolean isStraightFlushLowAce(Hand playerHand) {
        return isStraightWithAceAsOne(playerHand) && isFlush(playerHand);//Checks for three of a kind and one pair
    }

    private boolean isFourOfAKind(Hand playerHand) {

        int numberOfAKindIsFour = 0;
        //looks at each "set" of cards
        for (int value : playerHand.getRankMap().values()) {
            //if there is three cards, we count it as Three of a kind
            if (value == 4) {
                numberOfAKindIsFour += 1;
            }
        }
        if (numberOfAKindIsFour == 1) {
            return true;
        }
        return false;
    }

    private boolean isFullHouse(Hand playerHand) {
        return isThreeOfAKind(playerHand) && isOnePair(playerHand);//Checks for three of a kind and one pair
    }

    private boolean isFlush(Hand playerHand) {

        int flushIsPresent = 0;
        //looks at each "set" of cards
        for (int value : playerHand.getSuitMap().values()) {
            //if there is three cards, we count it as Three of a kind
            if (value == 5) {
                flushIsPresent += 1;
            }
        }
        if (flushIsPresent == 1) {
            return true;
        }
        return false;
    }

    private boolean isStraight(Hand playerHand) {
        int intArray[] = new int[5];
        int index = 0;
        for (Card card : playerHand.getHand()) {
            //creating an array that holds the ranks of the current hand
            intArray[index] = card.getRank();
            index += 1;
        }

        Arrays.sort(intArray);

        for (int i = 0; i < index - 1; i++) {
            //checking if the first value of the array equals the second value of the array
            if (intArray[i] + 1 != intArray[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isStraightWithAceAsOne(Hand playerHand) {
        int intArray[] = new int[5];
        int index = 0;
        for (Card card : playerHand.getHand()) {
            //creating an array that holds the ranks of the current hand
            intArray[index] = card.getRankLowAce();
            index += 1;
        }

        Arrays.sort(intArray);

        for (int i = 0; i < index - 1; i++) {
            //checking if the first value of the array equals the second value of the array
            if (intArray[i] + 1 != intArray[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isThreeOfAKind(Hand playerHand) {

        int numberOfAKindIsThree = 0;
        //looks at each "set" of cards
        for (int value : playerHand.getRankMap().values()) {
            //if there is three cards, we count it as Three of a kind
            if (value == 3) {
                numberOfAKindIsThree += 1;
            }
        }
        if (numberOfAKindIsThree == 1) {
            return true;
        }
        return false;
    }

    private boolean isTwoPairs(Hand playerHand) {

        int numberOfPairs = 0;
        //looks at each "set" of cards
        for (int value : playerHand.getRankMap().values()) {
            //if there is two cards, we count it as a pair
            if (value == 2) {
                numberOfPairs += 1;
            }
        }
        if (numberOfPairs == 2) {
            return true;
        }
        return false;
    }

    private boolean isOnePair(Hand playerHand) {

        int numberOfPairs = 0;
        //looks at each "set" of cards
        for (int value : playerHand.getRankMap().values()) {
            //if there is two cards, we count it as a pair
            if (value == 2) {
                numberOfPairs += 1;
            }
        }
        if (numberOfPairs == 1) {
            return true;
        }
        return false;
    }

    private enum Results {
        STRAIGHT_FLUSH("Straight Flush"),
        STRAIGHT("Straight"),
        FLUSH("Flush"),
        FOUR_OF_A_KIND("Four of a Kind"),
        FULL_HOUSE("Full House"),
        THREE_OF_A_KIND("Three of a Kind"),
        TWO_PAIR("Two Pair"),
        ONE_PAIR("One Pair"),
        HIGH_CARD("High Card"),
        INVALID_HAND("Incorrect hand count");

        private final String result;

        Results(String result) {
            this.result = result;
        }

        public String getResult() {
            return this.result;
        }
    }

}
