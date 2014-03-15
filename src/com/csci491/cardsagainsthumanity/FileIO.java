package com.csci491.cardsagainsthumanity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO {

	private File whiteFile = new File("WHITE_CARDS.dat");
	private File blackFile = new File("BLACK_CARDS.dat");
	private final int WHITE = 0;
	private final int BLACK = 1;
	
	
	
	public ArrayList<Card> createWhiteCards() throws FileNotFoundException {
		ArrayList<Card> whiteCards = new ArrayList<Card>();
		Scanner whiteScanner = new Scanner(whiteFile);
		
		while (whiteScanner.hasNext()) {
			String line = whiteScanner.nextLine();
			whiteCards.add(new WhiteCard(line));
		}
		
		return whiteCards;
	}
	
	public ArrayList<Card> createBlackCards() throws FileNotFoundException {
		ArrayList<Card> blackCards = new ArrayList<Card>();
		Scanner blackScanner = new Scanner(whiteFile);
		
		while (blackScanner.hasNext()) {
			String line = blackScanner.nextLine();
			blackCards.add(new BlackCard(line));
		}
		
		return blackCards;
	}
	
}