/**
 * A collection of 52 individual cards. Extends & uses methods from Pile of Cards.
 * The constructor automatically makes a 52 card deck each time.
 * 
 * @author Nico De Paolis - Sun 11/19/2017
 *
 */

package edu.wit.dcsn.comp2000.listapp;

public class DeckOfCards extends PileOfCards<Card>
{
	PileOfCards<Card> deck;
	
	/**
	 * Constructs a deck object that consists of 52 Cards, with the proper
	 * amount of each Rank & Suit.
	 */
	public DeckOfCards()
	{
//		deck = new PileOfCards<Card>(52);
		
		super(52);
		
		for(Suit aSuit : Suit.values())
		{
			for(Rank aRank : Rank.values())
			{
				this.add(new Card(aRank, aSuit));
			}
		}
		
		this.shuffle();
	}
	
	/**
	 * Grabs the card off the top of the deck.
	 */
	public Card deal()
	{
		return this.remove(0);
	}
	
	
	
	/**
	 * Used to test the methods of the Card class in a controlled
	 * environment & ensure they all work as intended.
	 * 
	 * @param args -unused-
	 */
	public static void main(String[] args)
	{
		
//		int k = 0;
//		while(k < 1000) {
//			DeckOfCards deck = new DeckOfCards();
//			System.out.print(deck.isFull());
//			System.out.println(deck.deal().toString());
//			k++;
//		}
		int b = 0;
		DeckOfCards deck = new DeckOfCards();
		for(int i = 0; i < deck.getLength(); i++) {
			System.out.println(deck.getEntry(i));
			b++;
		}
		System.out.println(deck.getLength() + " " + b);
		
		System.out.println("The deck currently has " + deck.getLength() + " cards in it.");
		
		System.out.println(deck.deal().toString());
		
		System.out.println("The deck currently has " + deck.getLength() + " cards in it.");
	
		System.out.println("The deck currently has " + deck.getLength() + " cards in it.");
		
		System.out.println("The deck currently has " + deck.getLength() + " cards in it.");
	}
}
