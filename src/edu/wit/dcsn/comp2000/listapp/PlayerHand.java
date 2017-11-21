package edu.wit.dcsn.comp2000.listapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PlayerHand extends PileOfCards<Card> {

    PileOfCards<Card> PileOfCards = new PileOfCards<>();
    //USE PILEOFCARDS AS A MEANS OF STORING PLAYER CARDS

    // constructor for hand object
    // pass in initial cards
    public PlayerHand() {
    		this(new Card[0]);
    }
    
    public PlayerHand(Card[] initialCards)
    {
    		super();
    }
    
    public ArrayList<Card> checkHand(){
    		return this.getCards();
    }

    public Card releaseCard(Card card)
    {
        if (PileOfCards.contains(card))
        {
            PileOfCards.remove(PileOfCards.getEntry(card));
            return card;
        }
        return null;
    }

    public void retrieveCard(PlayerHand selectedHand, Card card)
    {
        if (PileOfCards.contains(card) && selectedHand.PileOfCards.contains(card))
        {
            selectedHand.releaseCard(card);
            PileOfCards.add(card);
        }
    }

    public boolean combineCards()
    {
        Set<Card> dupes = new HashSet<>();
        for (Card card : PileOfCards)
        {
            if (!dupes.add(card))
            {
                PileOfCards.remove(card);
                PileOfCards.remove(card);
                return true;
            }
        }
        return false;
    }
}
