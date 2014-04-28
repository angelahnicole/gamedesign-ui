package com.csci491.cardsagainsthumanity;

public class WhiteCard extends Card {
	private Player owner;
	
	public WhiteCard(String content, Player owner) {
		this.setContent(content);
	}

	@Override
	public void setContent(String content) {
		super.content = content;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
