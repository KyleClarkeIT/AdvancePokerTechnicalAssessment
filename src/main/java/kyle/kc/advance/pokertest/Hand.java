/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kyle.kc.advance.pokertest;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author Kyle Clarke
 */
public class Hand {

    private final List<Card> CardsInHand;

    public List<Card> getHand() {
        Collections.sort(CardsInHand);
        return this.CardsInHand;
    }

    public Hand(List<Card> cards) {
        this.CardsInHand = cards;
        Collections.sort(cards);
        BuildHashMap();
    }

    public Map<Card.Suit, Integer> getSuitMap() {
        return this.SuitMap;
    }

    public Map<Card.Rank, Integer> getRankMap() {
        return this.RankMap;
    }

    private Map<Card.Suit, Integer> SuitMap = new HashMap<>();
    private Map<Card.Rank, Integer> RankMap = new HashMap<>();

    private void BuildHashMap() {
        SuitMap = new HashMap<>();
        RankMap = new HashMap<>();
        for (Card card : CardsInHand) {
            SuitMap.putIfAbsent(card.getESuit(), 0);            
            SuitMap.put(card.getESuit(), SuitMap.get(card.getESuit()) + 1);

            RankMap.putIfAbsent(card.getERank(), 0);
            RankMap.put(card.getERank(), RankMap.get(card.getERank()) + 1);
        }
    }

    @Override
    public String toString() {
        return CardsInHand.stream().map(Card::toString).collect(joining(" "));
    }
}
