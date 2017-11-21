/**
 * A single card, where all of the variables of a card are defined: Rank, and Suit -- color is implied in the suit.
 * 
 * @author Nico De Paolis - Sun 11/19/2017
 *
 */

package edu.wit.dcsn.comp2000.listapp;

import java.lang.Comparable;
import java.lang.Object;

public class Card implements Comparable<Card>
{
	final Rank rank;
	final Suit suit;
	
	/**
	 * Constructor for the Card Class, creates a card with a defined Rank and Suit.
	 * 
	 * @param rank is the rank of the card (Ace, Two, Kind, etc).
	 * @param suit is the suit of the card (Hearts, Diamonds, etc).
	 */
	public Card(Rank rank, Suit suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * Method used to compare the numerical point value of two cards for the purpose of
	 * seeing if a card is greater than, less than, or equal to another. If a negative number
	 * is returned, 'this' is smaller than 'card'. If a zero is returned, they are equal. If a
	 * positive number is returned 'this' is larger than 'card'.
	 * 
	 * @param card is the card object that 'this' will be subtracted from.
	 * @return a positive/negative number or zero, depending on the results of the comparison.
	 */
	@Override
	public int compareTo(Card card)
	{	
		return (card.getRank().getPoints() - this.getRank().getPoints());
	}
	
	/**
	 * Method called by one card to compare it against another & see if they are the same.
	 * 
	 * @param card is the card object that will be compared against.
	 * @return true or false, depending on if the cards are equal or not.
	 */
	public boolean equals(Card card)
	{
		
		if(this.getRank() == card.getRank() && this.getSuit() == card.getSuit())
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the rank of the particular card.
	 * 
	 * @return the rank of the particular card (Ace, Two, King, etc)
	 */
	public Rank getRank()
	{
		return rank;
	}
	
	/**
	 * Returns the suit of the particular card. Color is implicit in suit.
	 * 
	 * @return the suit of the particular card (Clubs, Diamonds, etc)
	 */
	public Suit getSuit()
	{
		return suit;
	}
	
	/**
	 * Returns the details of the Card object as a string.
	 * 
	 * @return the details of the Card object as a string.
	 */
	public String toString()
	{
		return "This card is the " + rank.getDisplayName() + " of " + suit.getDisplayName();
	}
	
	/**
	 * Used to test the methods of the Card class in a controlled 
	 * environment & ensure they all work as intended.
	 * 
	 * @param args -unused-
	 */
	public static void main(String[] args)
	{	
		Card card = new Card(Rank.ACE, Suit.CLUBS);
		Card cardTwo = new Card (Rank.NINE, Suit.HEARTS);
		Card cardThree = new Card (Rank.KING, Suit.DIAMONDS);
		Card cardFour = new Card (Rank.SIX, Suit.SPADES);
		
		System.out.println(card.compareTo(cardTwo));
		System.out.println(cardTwo.compareTo(cardThree));
		System.out.println(cardThree.compareTo(cardFour));
		System.out.println(card.compareTo(cardFour));
		System.out.println(cardFour.compareTo(cardTwo));
	}
}
