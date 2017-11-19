package edu.wit.dcsn.comp2000.listapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PlayerHand extends PileOfCards {

//    ArrayList<Card> PileOfCards = new ArrayList();
    //USE PILEOFCARDS AS A MEANS OF STORING PLAYER CARDS

    public void PlayerHand() {
        for (int i = 0; i < 5; i++) {
            PileOfCards.add(topCard);
        }
    }

    public Card releaseCard(Card card)
    {
        if (PileOfCards.contains(card))
        {
            PileOfCards.remove(card);
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
