package com.csci491.cardsagainsthumanity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/* ========================================================================
 * This is the file input and output class
 * It reads the card file in, as well as the user config file
 * ======================================================================== */

public class FileIO {
	
	public ArrayList<Card> createWhiteCards() throws Exception {
		ArrayList<Card> whiteCards = new ArrayList<Card>();
		
		try {
			BufferedReader BR = new BufferedReader(new FileReader(new File("WHITE_CARDS.dat")));
			String line;
			
			while ((line = BR.readLine()) != null) {
				whiteCards.add(new WhiteCard(line));
			}
		}
		catch (Exception e) {
			
		}
		
		return whiteCards;
	}
	
	public ArrayList<Card> createBlackCards() throws Exception {
		ArrayList<Card> blackCards = new ArrayList<Card>();
	
		try {
			BufferedReader BR = new BufferedReader(new FileReader(new File("BLACK_CARDS.dat")));
			String line;
			
			while ((line = BR.readLine()) != null) {
				blackCards.add(new BlackCard(line));
			}
		}
		catch (Exception e) {
			
		}
		
		return blackCards;
	}
	
}
