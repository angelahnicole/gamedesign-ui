package com.csci491.cardsagainsthumanity;

import android.app.Application;
import java.util.ArrayList;

public class Globals extends Application {

	private ArrayList<Card> blackCards = new ArrayList<Card>();
	private ArrayList<Card> whiteCards = new ArrayList<Card>();
	private boolean familyFilter;
	private int test;

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public boolean isFamilyFilter() {
		return familyFilter;
	}

	public void setFamilyFilter(boolean familyFilter) {
		this.familyFilter = familyFilter;
	}

	public ArrayList<Card> getBlackCards() {
		return blackCards;
	}

	public void setBlackCards(ArrayList<Card> blackCards) {
		this.blackCards = blackCards;
	}

	public ArrayList<Card> getWhiteCards() {
		return whiteCards;
	}

	public void setWhiteCards(ArrayList<Card> whiteCards) {
		this.whiteCards = whiteCards;
	}

}