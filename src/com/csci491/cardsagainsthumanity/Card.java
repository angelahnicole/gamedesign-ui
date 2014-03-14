package com.csci491.cardsagainsthumanity;

public class Card {
	
	private final int MINDEX = 6;
	private String content;
	private boolean mature;
	private int type;		// 0 = white card :::: 1 = black card
	
	public Card(String text) {
		read(text);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isMature() {
		return mature;
	}

	public void setMature(boolean mature) {
		this.mature = mature;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public void read(String text) {
		String test = "This is a white card.";
		
		if (test.startsWith("NSFW:"))
		{
			setMature(true);
		} else {
			setMature(false);
		}
		
		setContent(test.substring(MINDEX));
	}

}
