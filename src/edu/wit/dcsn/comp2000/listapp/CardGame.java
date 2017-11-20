package edu.wit.dcsn.comp2000.listapp;

import java.util.Scanner;

public class CardGame {
	public static void main(String[] args){
		Scanner userIn = new Scanner(System.in);
		boolean stillPlaying = true;
		DeckOfCards gameDeck = new DeckOfCards();
		shuffle(gameDeck);
		System.out.println("Welcome to Go Fish!");
		System.out.println("Number of Players (2-5, default 2): ");
		int numPlayers = userIn.nextInt();
		if(numPlayers < 2 || numPlayers > 5){
			numPlayers = 2;
		}
		Player[] players;
		players = new Player[numPlayers];
		for(int i = 0; i < numPlayers; i++){
			System.out.printf("Player %n's name: ", i);
			String playerName = userIn.next();
			players[i] = new Player(playerName);
		}
		while(stillPlaying){
			for(Player k : players){
				System.out.println(k.toString() + ", number to ask for: ");
				int num = userIn.nextInt();
				//check player's number against their own hand, make sure they have one
				//check other players for cards of that value
				//put cards in player's hand or go fish
			}
		}
	}
}

