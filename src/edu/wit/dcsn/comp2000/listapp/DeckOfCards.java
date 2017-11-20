/**
 * A collection of 52 individual cards. Extends & uses methods from Pile of Cards.
 * The constructor automatically makes a 52 card deck each time.
 * 
 * @author Nico De Paolis - Sun 11/19/2017
 *
 */

package edu.wit.dcsn.comp2000.listapp;

public class DeckOfCards extends PileOfCards<Object>
{
	PileOfCards<Card> deck;
	
	/**
	 * Constructs a deck object that consists of 52 Cards, with the proper
	 * amount of each Rank & Suit.
	 */
	public DeckOfCards()
	{
		deck = new PileOfCards<Card>(52);
		
		for(Suit aSuit : Suit.values())
		{
			for(Rank aRank : Rank.values())
			{
				deck.add(new Card(aRank, aSuit));
			}
		}
		
		deck.shuffle();
	}
	
	/**
	 * Grabs the card off the top of the deck.
	 */
	public Card deal()
	{
		return deck.remove(0);
	}
	
	/**
	 * Used to test the methods of the Card class in a controlled
	 * environment & ensure they all work as intended.
	 * 
	 * @param args -unused-
	 */
	public static void main(String[] args)
	{
		DeckOfCards deck = new DeckOfCards();
		
		System.out.println("The deck currently has " + deck.getLength() + " cards in it.");
		
		deck.deal();
		
		System.out.println("The deck currently has " + deck.getLength() + " cards in it.");
	
		System.out.println("The deck currently has " + deck.getLength() + " cards in it.");
		
		System.out.println("The deck currently has " + deck.getLength() + " cards in it.");
	}
}
