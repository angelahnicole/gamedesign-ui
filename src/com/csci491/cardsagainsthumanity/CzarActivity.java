package com.csci491.cardsagainsthumanity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

public class CzarActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingame);
		
		if (Globals.isRoundWinner()) {
			// ========================================================================
			// PREPARE LAYOUT FOR REVIEW CARDS (END OF A ROUND)
			// ========================================================================
			// change submit button
			Button submit = (Button) findViewById(R.id.buttonSubmit);
			submit.setVisibility(0);
			submit.setText("Continue");
			
			// set owner name
			TextView textViewAditionalInfo = (TextView) findViewById(R.id.textViewAditionalInfo);
			textViewAditionalInfo.setVisibility(0);
			textViewAditionalInfo.setText(Globals.getPlays().get(Globals.getIndexWhiteCard()).getOwner().getName());
			
			// display helper
			TextView textViewHelper = (TextView) findViewById(R.id.textViewHelper);
			textViewHelper.setText(R.string.helperInGameReview);
			
		} else {
			// ========================================================================
			// PREPARE LAYOUT FOR CZAR VIEW
			// ========================================================================
			Button buttonCard = (Button) findViewById(R.id.buttonCard);
			buttonCard.setOnClickListener(cardListener);
			
			// display helper
			TextView textViewHelper = (TextView) findViewById(R.id.textViewHelper);
			textViewHelper.setText(R.string.helperInGameCzar);
			
		}
		// ========================================================================
		// PREPARE WHAT'S THE SAME FOR BOTH VIEWS
		// ========================================================================
		// Set question (Black card)
		TextView question = (TextView) findViewById(R.id.textViewQuestion);
		question.setText(Globals.getBlackCards().get(0).getContent());
		
		// Set white cards based on other players' submission
		// Call the listener of the button
		Button buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
		buttonSubmit.setOnClickListener(submitListener);
		
		Button buttonCard = (Button) findViewById(R.id.buttonCard);
		buttonCard.setTextColor(getApplication().getResources().getColor(R.color.white));
		buttonCard.setBackgroundColor(getApplication().getResources().getColor(R.color.black));
		buttonCard.setText(Globals.getPlays().get(Globals.getIndexWhiteCard()).getContent());
		
		// navigation (white cards)
		Globals.setIndexWhiteCard(0);
		Button buttonLeft = (Button) findViewById(R.id.buttonLeft);
		Button buttonRight = (Button) findViewById(R.id.buttonRight);
		
		// Set listeners on navigation
		buttonLeft.setOnClickListener(leftListener);
		buttonRight.setOnClickListener(rightListener);
		
		for (int i = 0; i < Globals.getPlays().size(); i++) {
			System.out.println(Globals.getPlays().get(i).getOwner().getName() + " owns " + Globals.getPlays().get(i).getContent());
		}
		
	}
	
	// ========================================================================
	// BUTTON LISTENERS
	// ========================================================================
	
	private OnClickListener leftListener = new OnClickListener() {
		public void onClick(View v) {
			Button card = (Button) findViewById(R.id.buttonCard);
			Button submit = (Button) findViewById(R.id.buttonSubmit);
			
			// verify if it's possible to go back
			if (Globals.getIndexWhiteCard() > 0) {
				Globals.setIndexWhiteCard(Globals.getIndexWhiteCard() - 1);
			} else {
				Globals.setIndexWhiteCard(Globals.getNumPlayers() - 2);
			}
			card.setText(Globals.getPlays().get(Globals.getIndexWhiteCard()).getContent());
			
			if (!Globals.isRoundWinner())
				submit.setVisibility(View.GONE);
			
			else {
				TextView textViewAditionalInfo = (TextView) findViewById(R.id.textViewAditionalInfo);
				textViewAditionalInfo.setText(Globals.getPlays().get(Globals.getIndexWhiteCard()).getOwner().getName());
			}
		}
	};
	
	private OnClickListener rightListener = new OnClickListener() {
		public void onClick(View v) {
			Button card = (Button) findViewById(R.id.buttonCard);
			Button submit = (Button) findViewById(R.id.buttonSubmit);
			
			// verify if it's possible to go further
			if (Globals.getIndexWhiteCard() < Globals.getNumPlayers() - 2) {
				Globals.setIndexWhiteCard(Globals.getIndexWhiteCard() + 1);
			} else {
				Globals.setIndexWhiteCard(0);
			}
			card.setText(Globals.getPlays().get(Globals.getIndexWhiteCard()).getContent());
			
			if (!Globals.isRoundWinner())
				submit.setVisibility(View.GONE);
			
			else {
				TextView textViewAditionalInfo = (TextView) findViewById(R.id.textViewAditionalInfo);
				textViewAditionalInfo.setText(Globals.getPlays().get(Globals.getIndexWhiteCard()).getOwner().getName());
			}
		}
	};
	
	private OnClickListener cardListener = new OnClickListener() {
		public void onClick(View v) {
			// turn the visibility of the "submit" button to TRUE
			Button buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
			
			if (buttonSubmit.getVisibility() == View.GONE) {
				buttonSubmit.setVisibility(View.VISIBLE);
			} else {
				buttonSubmit.setVisibility(View.GONE);
			}
		}
	};
	
	private OnClickListener submitListener = new OnClickListener() {
		public void onClick(View arg0) {
			if (Globals.isGameWinner()) {
				// just reviewing cards and game is over: Back to main screen
				Intent intent = new Intent(CzarActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			} else if (Globals.isRoundWinner()) {
				// just reviewing cards and the game is not over: Go to next
				// round
				Intent intent = new Intent(CzarActivity.this, NewRoundActivity.class);
				startActivity(intent);
				finish();
			} else {
				// card Czar screen:
				// add point to the player who chose the card
				Player player = Globals.getPlays().get(Globals.getIndexWhiteCard()).getOwner();
				int newScore = player.getScore() + 1;
				Globals.getPlays().get(Globals.getIndexWhiteCard()).getOwner().setScore(newScore);
				Globals.setWinnerName(player.getName());
				
				System.out.println(player.getName());
				
				// allows to set a new black card
				Globals.setChangeBlackCard(true);
				
				// Changes the player
				Globals.setIsRoundWinner(true);
				
				Globals.setIndexWhiteCard(0);
				
				// Redirect to PlayerTurnActivity, now with a message for the
				// winner
				// Later in that class player will be redirected to
				// NewRoundActivity
				Intent intent = new Intent(CzarActivity.this, PlayerTurnActivity.class);
				startActivity(intent);
				finish();
				
			}
		}
	};
}
