package com.csci491.cardsagainsthumanity;

public abstract class Card {
	
	protected String content;
	
	public abstract void setContent(String content);
	
	public String getContent() {
		return this.content;
	}
	
}
