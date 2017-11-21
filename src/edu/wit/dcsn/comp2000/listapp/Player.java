package edu.wit.dcsn.comp2000.listapp;

public class Player
{
    public String name = null;

    private int score = 0;

    DeckOfCards hand;
    
    public Player() {
    		this("default");
    }

    public Player(String name)
    {
        this.name = name;
        hand = new DeckOfCards();
    }

    public void increaseScore()
    {
        this.score++;
    }

    public DeckOfCards getHand() {
        return this.hand;
    }

    public int getScore()
    {
        return this.score;
    }

    public void makeMove()
    {

    }
}
