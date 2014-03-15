package com.csci491.cardsagainsthumanity;

public abstract class Card {
	
	protected final int MINDEX = 5;
	protected String content;
	protected boolean mature;
	
	public abstract void setContent(String content);
	public String getContent()
	{
		return this.content;
	}
	
	public void setMature(boolean mature)
	{
		this.mature = mature;
	}
	
	public boolean getMature()
	{
		return this.mature;
	}
	
}