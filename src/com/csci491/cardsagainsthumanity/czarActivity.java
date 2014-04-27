package com.csci491.cardsagainsthumanity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class czarActivity extends Activity {

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
		buttonCard.setText(Globals.getPlays().get(Globals.getIndexWhiteCard())
				.getContent());

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
			// verify if it's possible to go back
			if (Globals.getIndexWhiteCard() > 0) {
				Globals.setIndexWhiteCard(Globals.getIndexWhiteCard() - 1);
				Button card = (Button) findViewById(R.id.buttonCard);
				card.setText(Globals.getPlays()
						.get(Globals.getIndexWhiteCard()).getContent());

				//Button submit = (Button) findViewById(R.id.buttonSubmit);
				//submit.setVisibility(View.GONE);
			}
		}
	};

	private OnClickListener rightListener = new OnClickListener() {
		public void onClick(View v) {
			// verify if it's possible to go further
			if (Globals.getIndexWhiteCard() < Globals.getNumPlayers() -2) {
				Button card = (Button) findViewById(R.id.buttonCard);
				Globals.setIndexWhiteCard(Globals.getIndexWhiteCard() + 1);
				card.setText(Globals.getPlays()
						.get(Globals.getIndexWhiteCard()).getContent());

				//Button submit = (Button) findViewById(R.id.buttonSubmit);
				//submit.setVisibility(View.GONE);
			}
		}
	};
}
