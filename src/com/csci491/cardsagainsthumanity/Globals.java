package com.csci491.cardsagainsthumanity;

import android.app.Application;
import java.util.ArrayList;

public class Globals extends Application {

	private ArrayList<BlackCard> blackCards = new ArrayList<BlackCard>();
	private ArrayList<WhiteCard> whiteCards = new ArrayList<WhiteCard>();
	private String userName = new String();
	private int pointLimit;
	private int numPlayers;

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public int getPointLimit() {
		return pointLimit;
	}

	public void setPointLimit(int pointLimit) {
		this.pointLimit = pointLimit;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<BlackCard> getBlackCards() {
		return blackCards;
	}

	public void setBlackCards(ArrayList<BlackCard> blackCards) {
		this.blackCards = blackCards;
	}

	public ArrayList<WhiteCard> getWhiteCards() {
		return whiteCards;
	}

	public void setWhiteCards(ArrayList<WhiteCard> whiteCards) {
		this.whiteCards = whiteCards;
	}

}