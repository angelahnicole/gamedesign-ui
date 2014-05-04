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

		// ========================================================================
		// PREPARE LAYOUT FOR CZAR VIEW
		// ========================================================================

		// display helper
		TextView textViewHelper = (TextView) findViewById(R.id.textViewHelper);
		textViewHelper.setText(R.string.helperInGameCzar);

		// Set question (Black card)
		TextView question = (TextView) findViewById(R.id.textViewQuestion);
		question.setText(Globals.getBlackCards().get(0).getContent());

		// Set white cards based on other players' submission
		Button buttonCard = (Button) findViewById(R.id.buttonCard);
		buttonCard.setTextColor(getApplication().getResources().getColor(R.color.white));
		buttonCard.setBackgroundColor(getApplication().getResources().getColor(R.color.black));
		buttonCard.setOnClickListener(cardListener);
		buttonCard.setText(Globals.getPlays().get(Globals.getIndexWhiteCard()).getContent());

		// navigation (white cards)
		Globals.setIndexWhiteCard(0);
		Button buttonLeft = (Button) findViewById(R.id.buttonLeft);
		Button buttonRight = (Button) findViewById(R.id.buttonRight);

		// Set listeners on navigation
		buttonLeft.setOnClickListener(leftListener);
		buttonRight.setOnClickListener(rightListener);
	}

	// ========================================================================
	// BUTTON LISTENERS
	// ========================================================================

	private OnClickListener leftListener = new OnClickListener() {
		public void onClick(View v) {
			Button card = (Button) findViewById(R.id.buttonCard);
			Button submit = (Button) findViewById(R.id.buttonSubmit);
			submit.setVisibility(View.GONE);
			// verify if it's possible to go back
			if (Globals.getIndexWhiteCard() > 0) {
				Globals.setIndexWhiteCard(Globals.getIndexWhiteCard() - 1);
			}
			else
			{
				Globals.setIndexWhiteCard(Globals.getNumPlayers() - 2);
			}
			card.setText(Globals.getPlays()
					.get(Globals.getIndexWhiteCard()).getContent());
		}
	};

	private OnClickListener rightListener = new OnClickListener() {
		public void onClick(View v) {
			Button card = (Button) findViewById(R.id.buttonCard);
			
			Button submit = (Button) findViewById(R.id.buttonSubmit);
			submit.setVisibility(View.GONE);
			// verify if it's possible to go further
			if (Globals.getIndexWhiteCard() < Globals.getNumPlayers() - 2) {
				Globals.setIndexWhiteCard(Globals.getIndexWhiteCard() + 1);
			}
			else
			{
				Globals.setIndexWhiteCard(0);
			}
			card.setText(Globals.getPlays()
					.get(Globals.getIndexWhiteCard()).getContent());
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

			// Call the listener of the button
			buttonSubmit.setOnClickListener(submitListener);
		}
	};
	
	private OnClickListener submitListener = new OnClickListener() {
		public void onClick(View arg0) {
			// add point to the player who chose the card
			Player player = Globals.getPlays().get(Globals.getIndexWhiteCard()).getOwner();
			int newScore = player.getScore() +1;
			Globals.getPlays().get(Globals.getIndexWhiteCard()).getOwner().setScore(newScore);
			Globals.setWinnerName(player.getName());
			
			//allows to set a new black card
			Globals.setChangeBlackCard(true);
			
			// Changes the player
			Globals.setIsRoundWinner(true);
			
			// Redirect to PlayerTurnActivity, now with a message for the winner
			// Later in that class player will be redirected to NewRoundActivity
			Intent intent = new Intent(CzarActivity.this,
					PlayerTurnActivity.class);
			startActivity(intent);
			finish();
		}
	};
}
