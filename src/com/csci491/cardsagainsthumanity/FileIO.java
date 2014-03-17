package com.csci491.cardsagainsthumanity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;

/* ========================================================================
 * This is the file input and output class
 * It reads the card file in, as well as the user config file
 * ======================================================================== */

public class FileIO extends Activity {
	
	public ArrayList<Card> createWhiteCards() throws Exception {
		ArrayList<Card> whiteCards = new ArrayList<Card>();
		
		try {
			/*
			InputStream is = getAssets().open("WHITE_CARDS.dat");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			*/
			
			//Provided the file is NOT in the assets folder... (original theory)
			//BufferedReader BR = new BufferedReader(new FileReader(new File("WHITE_CARDS.dat")));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("WHITE_CARDS.dat")));
			
			String line;
			
			while ((line = br.readLine()) != null) {
				whiteCards.add(new WhiteCard(line));
			}
			
			br.close();
			
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
