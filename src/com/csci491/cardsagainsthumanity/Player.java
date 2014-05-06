package com.csci491.cardsagainsthumanity;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Context;

public class Player extends Activity {
	
	// private ArrayList<WhiteCard> whiteCards;
	// private ArrayList<BlackCard> blackCards;
	private ArrayList<WhiteCard> myHand;
	private int myIndex;
	public int getMyIndex() {
		return myIndex;
	}

	public void setMyIndex(int myIndex) {
		this.myIndex = myIndex;
	}

	private String name;
	private boolean isHuman;
	private boolean isCzar;
	private int score;
	private int numPlayers; // awareness of other players
	private boolean playedAlready = false;
	private Context c;
	
	public Player() {
		myHand = new ArrayList<WhiteCard>();
	}
	
	public Player(boolean isHuman) {
		setHuman(isHuman);
		myHand = new ArrayList<WhiteCard>();
		isCzar = false;
	}
	
	public Player(String name) {
		setName(name);
		myHand = new ArrayList<WhiteCard>();
		isCzar = false;
	}
	
	public Player(String name, boolean isHuman, boolean isCzar) {
		setName(name);
		setHuman(isHuman);
		this.isCzar = isCzar;
		myHand = new ArrayList<WhiteCard>();
	}
	
	public Player(int index, String name, boolean isHuman, boolean isCzar) {
		setMyIndex(index);
		setName(name);
		setHuman(isHuman);
		this.isCzar = isCzar;
		myHand = new ArrayList<WhiteCard>();
	}
	
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
	
	public WhiteCard playWhiteCard(int index) {
		WhiteCard play = myHand.remove(index);
		draw();
		return play;
	}
	
	public void draw() {
		if (!Globals.getWhiteCards().isEmpty()) {
			WhiteCard newCard = Globals.getWhiteCards().remove(0);
			newCard.setOwner(this);
			myHand.add(newCard);
//			myHand.add(Globals.getWhiteCards().remove(0));
		} else {
			shuffleWhiteCards();
			draw();
		}
	}
	
	private void shuffleWhiteCards() {
		FileIO myFileIO = new FileIO(this.c);
		Globals.setWhiteCards(myFileIO.readWhiteCards());
		Collections.shuffle(Globals.getWhiteCards());
	}
	
	public boolean isCzar() {
		return isCzar;
	}
	
	public void setCzar(boolean isCzar) {
		this.isCzar = isCzar;
	}
	
	public boolean isPlayedAlready() {
		return playedAlready;
	}
	
	public void setPlayedAlready(boolean playedAlready) {
		this.playedAlready = playedAlready;
	}
	
}
