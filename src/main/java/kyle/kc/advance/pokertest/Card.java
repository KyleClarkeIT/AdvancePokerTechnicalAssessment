/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kyle.kc.advance.pokertest;

import java.util.Objects;

/**
 *
 * @author Kyle Clarke
 */
public class Card implements Comparable<Card> {

    private final Rank rank; //enum for card number, holds the string and value
    private final Suit suit;//enum for suit

    public Card(Suit suit, Rank rank) {
        if (suit == null) {
            throw new IllegalArgumentException("Suit is null");
        }
        if (rank == null) {
            throw new IllegalArgumentException("Rank is null");
        }
        this.rank = rank;
        this.suit = suit;
    }

    public Card() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //This method is used to make the getRankLowAce method return 1 instead of 14 if there is an ace present
    private int returnAceAsRankOne(int rank) {

        if (getRank() == 14) {
            return rank = 1;
        } else {
            return rank;
        }
    }

    public int getRank() {

        return this.rank.getRankValue();
    }

    //created for when having to look at the ace as a lower value
    public int getRankLowAce() {

        return returnAceAsRankOne(this.rank.getRankValue());
    }

    public String getSuit() {

        return this.suit.getSuitLetter();
    }

    public Suit getESuit() {
        return this.suit;
    }

    public Rank getERank() {

        return this.rank;
    }

    @Override
    public String toString() {
        return String.format("%s of %s ", this.rank, this.suit.getSuitLetter());
    }

    //Cards will be sorted according to rank value
    @Override
    public int compareTo(Card card) {
        int result = 0;
        if (card.rank.getRankValue() == rank.getRankValue()) {
            return result = 0;
        }
        if (card.rank.getRankValue() < this.rank.getRankValue()) {
            return result = +1;
        } else {
            return result = -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == obj) {
            return false;
        }
        if (!(obj instanceof Card)) {
            return false;
        } else {
            Card card = (Card) obj;//casting the obj as card
            return card.getERank() == this.getERank() && card.getESuit() == this.getESuit();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.rank);
        hash = 79 * hash + Objects.hashCode(this.suit);
        return hash;
    }

    //enums used to limit the options for new card creations
    enum Suit {
        DIAMONDS("D"),//unicode for diamonds \u2666
        CLUBS("C"),//unicode for clubs - \u2663
        HEARTS("H"),//unicode for hearts - \u2764
        SPADES("S");//unicode for spades - \u2660

        private final String suitLetter;

        Suit(final String suitLetter) {
            this.suitLetter = suitLetter;
        }

        ;
        
        public String getSuitLetter() {
            return this.suitLetter;
        }
    };

    enum Rank {

        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private int rankValue;

        Rank(int rankValue) {
            this.rankValue = rankValue;
        }

        ;

//used to obtain the int value of the enum
        public int getRankValue() {
            return this.rankValue;
        }
    };
}
