package edu.wit.dcsn.comp2000.listapp;

import java.util.Arrays;

public class PileOfCards<Card> implements ListInterface<Card>
{
    private Card[] list;
    private int frontIndex;
    private int backIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public PileOfCards()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public PileOfCards(int initialCapacity)
    {
//        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        Card[] tempList = (Card[]) new Object[initialCapacity + 1];
        list = tempList;
        frontIndex = 0;
        backIndex = initialCapacity;
        initialized = true;
    } // end constructor

    public boolean add(Card newEntry) {
        list[list.length+1] = newEntry;
        return true;
    }

    public boolean add(int newPosition, Card newEntry) {
        Card[] copy = (Card[]) new Object[list.length];
        for (int i = 0; i < newPosition; i++) {
            copy[i] = list[i];
        }
        copy[newPosition] = newEntry;
        for (int j = newPosition + 1; j < list.length; j++) {
            copy[j] = list[j - 1];
        }
        list = copy;
        return true;
    }

    public void clear() {
        for (int i = 0; i < list.length; i++) {
            list[i] = null;
        }
    }

    public Card remove(int givenPosition) {
        Card card = list[givenPosition];
        list[givenPosition] = null;
        return card;
    }

    public boolean replace(int givenPosition, Card newEntry) {
        list[givenPosition] = newEntry;
        return false;
    }

    public Card getEntry(int givenPosition) {
        return list[givenPosition];
    }

    public boolean contains(Card anEntry) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == anEntry) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return list.length;
    }

    public boolean isEmpty() {
        if (list.length == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (list.length == DEFAULT_CAPACITY) {
            return true;
        }
        return false;
    }

    // Shuffles the deck by rearranging the Card objects in the array.
    public void shuffle()
    {

    }

    // toString method -- just goes through the whole deck and adds each
    //  individual card to the returned string
    public String toString()
    {
        return Arrays.toString(list.toArray());
//        StringBuilder text = new StringBuilder();
//        for (Card aCard : list)
//        {
//            if (text.equals(""))
//            {
//                text.append("[");
//            } else
//                {
//                    text.append(" "); //ADD CHARACTER
//                }
//                text.append(aCard.getColor().getDisplayName() + aCard.getFace().getDisplayName());
//        }
//        text.append("]");
//
//        return text.toString();
    }

}
