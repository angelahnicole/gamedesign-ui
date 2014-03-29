package com.csci491.cardsagainsthumanity;
import java.util.ArrayList;

import android.app.Activity;



public class Player extends Activity {

//	private ArrayList<WhiteCard> whiteCards;
//	private ArrayList<BlackCard> blackCards;
	private ArrayList<WhiteCard> myHand;
	private String name;
	private boolean isHuman;
	private int score;
	private int numPlayers; // awareness of other players
	
	
	public boolean isHuman() {
		return isHuman;
	}

	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public Player() {
	}
	
	public Player(String name) {
		setName(name);
	}

	public ArrayList<WhiteCard> getMyHand() {
		return myHand;
	}

	public void setMyHand(ArrayList<WhiteCard> myHand) {
		this.myHand = myHand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public WhiteCard playWhiteCard() {
		WhiteCard play = myHand.remove(0);
		draw();
		return play;
	}
	
	public void draw() {
		if (!Globals.getWhiteCards().isEmpty()) {
			myHand.add(Globals.getWhiteCards().remove(0));
		}
		else {
			shuffleWhiteCards();
			draw();
		}
	}
	
	private void shuffleWhiteCards() {
		FileIO myFileIO = new FileIO();
		Globals.setWhiteCards(myFileIO.hardCodedWhiteCards());
		//whiteCards = Globals.getWhiteCards();
	}
	
}
