package com.csci491.cardsagainsthumanity;

public class WhiteCard extends Card {

	public WhiteCard(String content) {
		this.setContent(content);
	}

	@Override
	public void setContent(String content) {
		super.content = content;
	}

}
