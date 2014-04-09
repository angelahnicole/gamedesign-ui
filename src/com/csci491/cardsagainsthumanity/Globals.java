package com.csci491.cardsagainsthumanity;

import java.util.ArrayList;

import android.app.Application;

public class Globals extends Application {

	private final static int ROUND = 1;
	
	private static ArrayList<BlackCard> blackCards = new ArrayList<BlackCard>();
	private static ArrayList<WhiteCard> whiteCards = new ArrayList<WhiteCard>();
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static String userName = new String();
	private static int pointLimit;
	private static int numPlayers;
	private static int roundNum = ROUND;

	private Globals() {
		Globals.blackCards = new ArrayList<BlackCard>();
		Globals.whiteCards = new ArrayList<WhiteCard>();
		Globals.userName = new String();
		Globals.roundNum = ROUND;
	}
	
	static int getRoundNum() {
		return roundNum;
	}
	
	static void setRoundNum(int roundNum) {
		Globals.roundNum = roundNum;
	}
	
	static int getNumPlayers() {
		return numPlayers;
	}

	static void setNumPlayers(int numPlayers) {
		Globals.numPlayers = numPlayers;
	}

	static int getPointLimit() {
		return pointLimit;
	}

	static void setPointLimit(int pointLimit) {
		Globals.pointLimit = pointLimit;
	}

	static String getUserName() {
		return userName;
	}

	static void setUserName(String userName) {
		Globals.userName = userName;
	}

	static ArrayList<Player> getPlayers() {
		return players;
	}
	
	static void setPlayers(ArrayList<Player> players) {
		Globals.players = players;
	}
	
	static ArrayList<BlackCard> getBlackCards() {
		return blackCards;
	}

	static void setBlackCards(ArrayList<BlackCard> blackCards) {
		Globals.blackCards = blackCards;
	}

	static ArrayList<WhiteCard> getWhiteCards() {
		return whiteCards;
	}

	static void setWhiteCards(ArrayList<WhiteCard> whiteCards) {
		Globals.whiteCards = whiteCards;
	}

}