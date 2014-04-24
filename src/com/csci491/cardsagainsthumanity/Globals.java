package com.csci491.cardsagainsthumanity;

import java.util.ArrayList;

import android.app.Application;
import android.content.Context;

public class Globals extends Application {

	private final static int ROUND = 1;
	private final static int HANDSIZE = 7;
	private static ArrayList<BlackCard> blackCards = new ArrayList<BlackCard>();
	private static ArrayList<WhiteCard> whiteCards = new ArrayList<WhiteCard>();
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<WhiteCard> plays = new ArrayList<WhiteCard>();
	private static String userName = new String();
	private static int pointLimit;
	private static int numPlayers;
	private static int roundNum = ROUND;
	private static int indexWhiteCard = 0;
	private static int indexHumanPlayer = 0;
	private static FileIO cardMaker = new FileIO();

	private Globals() {
		resetGlobals();
	}
	
	static void resetGlobals(){
		Globals.blackCards = new ArrayList<BlackCard>();
		Globals.whiteCards = new ArrayList<WhiteCard>();
		Globals.userName = new String();
		Globals.roundNum = ROUND;
		Globals.players = new ArrayList<Player>();
		cardMaker = new FileIO();
	}
	
	static FileIO getCardMaker() {
		return cardMaker;
	}

	static void setCardMaker(FileIO cardMaker) {
		Globals.cardMaker = cardMaker;
	}

	static void setCardMakerContext(Context c) {
		Globals.cardMaker.setContext(c);
	}

	static int getHandSize() {
		return HANDSIZE;
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

	static ArrayList<WhiteCard> getPlays() {
		return plays;
	}
	
	static void setPlays(ArrayList<WhiteCard> plays) {
		Globals.plays = plays;
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

	static int getIndexWhiteCard() {
		return indexWhiteCard;
	}

	static void setIndexWhiteCard(int indexWhiteCard) {
		Globals.indexWhiteCard = indexWhiteCard;
	}
	
	static int getIndexHumanPlayer() {
		return indexHumanPlayer;
	}
	
	static void setIndexHumanPlayer(int indexHumanPlayer) {
		Globals.indexHumanPlayer = indexHumanPlayer;
	}

}