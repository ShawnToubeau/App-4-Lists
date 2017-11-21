package edu.wit.dcsn.comp2000.listapp;

public class Player
{
    public String name = null;

    private int score = 0;

    PlayerHand hand = new PlayerHand();

    public Player(String name)
    {
        this.name = name;
    }

    public void increaseScore()
    {
        this.score++;
    }

    public PlayerHand getHand() {
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
