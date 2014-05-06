package com.csci491.PartyCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

/* ========================================================================
 * This is the file input and output class
 * It reads the card file in, as well as the user config file
 * ======================================================================== */

public class FileIO extends Activity {
	
	private Context c;
	
	public FileIO() {
	}
	
	public FileIO(Context c) {
		this.c = c;
	}
	
	public void setContext(Context c) {
		this.c = c;
	}
	
	// ------------------------------------------------------------------------
	// These methods are the preferred way of making cards
	// ------------------------------------------------------------------------
	public ArrayList<WhiteCard> readWhiteCards() {
		ArrayList<WhiteCard> whiteCards = new ArrayList<WhiteCard>();
		
		try {
			AssetManager assetManager = c.getAssets();
			InputStream in = assetManager.open("whitecards.txt");
			
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isr);
			
			String mLine;
			while ((mLine = reader.readLine()) != null) {
				whiteCards.add(new WhiteCard(mLine, null));
			}
			
			reader.close();
		} catch (IOException e) {
			// log the exception
		}
		
		return whiteCards;
	}
	
	public ArrayList<BlackCard> readBlackCards() {
		ArrayList<BlackCard> blackCards = new ArrayList<BlackCard>();
		
		try {
			AssetManager assetManager = c.getAssets();
			InputStream in = assetManager.open("blackcards.txt");
			
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isr);
			
			String mLine;
			while ((mLine = reader.readLine()) != null) {
				blackCards.add(new BlackCard(mLine));
			}
			
			reader.close();
		} catch (IOException e) {
			// log the exception
		}
		
		return blackCards;
	}
	
}
