package com.csci491.cardsagainsthumanity;

public class BlackCard extends Card {
	
	protected int blanks;
	
	public BlackCard(String content) {
		setContent(content);
	}
	
	@Override
	public void setContent(String content) {
		int numBlanks = 0;
		
		if (content.contains("<blank>")) {
			String[] words = content.split(" ");
			for (int i = 0; i < words.length; i++) {
				if (words[i].equalsIgnoreCase("<blank>")) {
					numBlanks++;
				}
			}
		}
		
		setBlanks(numBlanks);
		super.content = content;
		
	}
	
	public void setBlanks(int blanks) {
		this.blanks = blanks;
	}
	
	public int getBlanks() {
		return this.blanks;
	}
	
}
