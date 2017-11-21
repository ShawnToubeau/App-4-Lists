package edu.wit.dcsn.comp2000.listapp;

import java.util.Scanner;

public class CardGame {
	public static void main(String[] args){
		Scanner userIn = new Scanner(System.in);
		boolean stillPlaying = true;
		DeckOfCards gameDeck = new DeckOfCards();
		//shuffle(gameDeck);
		System.out.println("Welcome to Go Fish! (press q any time to quit)");
		System.out.print("Number of Players (2-5, default 2): ");
		boolean hasInt = false;
		int store = 0;
		while(!hasInt) {
			if(!userIn.hasNextInt()) {
				System.out.printf("invalid, enter number of players (2-5, default 2): ");
				String storeQ = userIn.next();
				if(storeQ.charAt(0) == 'q') {
					System.out.println("Game Ended");
					System.exit(0);
				}
			}
			else {
				store = userIn.nextInt();
				if(store >= 2 && store <= 5) {
					hasInt = true;
				}
				else {
					System.out.printf("invalid, enter number of players (2-5, default 2): ");
				}
			}
		}
		int numPlayers = store;
		if(numPlayers < 2 || numPlayers > 5){
			numPlayers = 2;
		}
		Player[] players;
		players = new Player[numPlayers];
		for(int i = 0; i < numPlayers; i++){
			System.out.printf("Player %d's name: ", i+1);
			String playerName = userIn.next();
			players[i] = new Player(playerName);
		}
		while(stillPlaying){
			for(Player k : players){
				System.out.printf(k.name + ", rank to ask for: ");
				String storeRank = userIn.next();

			}
			int num = userIn.nextInt();
			//check player's number against their own hand, make sure they have one
			//check other players for cards of that value
			//put cards in player's hand or go fish
		}
	}
}


