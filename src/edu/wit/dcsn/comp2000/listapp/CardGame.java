package edu.wit.dcsn.comp2000.listapp;

import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {
	public static void main(String[] args){
		Scanner userIn = new Scanner(System.in);
		boolean stillPlaying = true;
		DeckOfCards gameDeck = new DeckOfCards();
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
		for(Player p : players) {
			p = new Player();
			for(int i = 0; i < 5; i++) {
				Card ca = gameDeck.deal();
				p.getHand().add(ca);
			}
		}
		//Testing
		for(int i = 0; i < gameDeck.getLength(); i++) {
			System.out.println(gameDeck.getEntry(i).toString());
		}
		//end testing
		for(int i = 0; i < numPlayers; i++){
			System.out.printf("Player %d's name: ", i+1);
			String playerName = userIn.next();
			players[i] = new Player(playerName);
		}
		while(stillPlaying){
			for(Player k : players){
				System.out.println(k.name + "'s cards:");
				for(int i = 0; i < k.getHand().getLength(); i++) {
					System.out.println(k.getHand().getEntry(i).toString());
				}
				System.out.printf(k.name + ", rank to ask for: ");
				String storeRank;
				Rank rCheck = Rank.ACE;
				boolean isIn = false;
				while(!isIn) {
					storeRank = userIn.next();
					for(Rank r : Rank.values()) {
						if (r.getDisplayName().equals(storeRank)) {
							isIn = true;
							rCheck = r;
						}
					}
					if(!isIn) {
						System.out.printf("Invalid: Select a rank to ask for: ");
					}
				}
				int j = 0;
				for(Suit s : Suit.values()) {
					if(k.getHand().contains(new Card(rCheck, s))) {
						for(Player p : players) {
							for(int i = 0; i < p.getHand().getLength(); i++) {
								Card ca = (Card) p.getHand().getEntry(i);
								if(ca.equals(((new Card(rCheck, s))))) {
									k.getHand().add(p.getHand().remove(i));
									k.increaseScore();
									for(int v = 0; v < k.getHand().getLength(); v++) {
										if(k.getHand().getEntry(v).equals(k.getHand().getEntry(k.getHand().getLength()-1))) {
											k.getHand().remove(v);
										}
									}
									i--;
									j++;
								}
							}
						}
					}
				}
				if(j == 0 && gameDeck.getLength() != 0) {
					System.out.println("Go Fish!");
					k.getHand().add(gameDeck.deal());
				}
				else {
					System.out.println("1 up!");
				}
			}
		}
		int num = userIn.nextInt();
		//check player's number against their own hand, make sure they have one
		//check other players for cards of that value
		//put cards in player's hand or go fish
	}
}



