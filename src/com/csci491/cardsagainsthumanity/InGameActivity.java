package com.csci491.cardsagainsthumanity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class InGameActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingame);
		// rest of the code

		System.out.println("InGameActivity: WhiteCards: " + Globals.getWhiteCards().size());
		System.out.println("InGameActivity: BlackCards: " + Globals.getBlackCards().size());

		TextView question = (TextView) findViewById(R.id.textViewQuestion);
		question.setText(Globals.getBlackCards().get(0).getContent());
		Globals.getBlackCards().remove(0);

		Button card = (Button) findViewById(R.id.buttonCard);
		card.setText(Globals.getPlayers().get(0).getMyHand().get(0).getContent());

		card.setOnClickListener(new OnClickListener() {
//			@SuppressWarnings("deprecation")
			public void onClick(View v) {
				// turn the visibility of the "submit" button to TRUE
				
				// but for now, show that the button even works by displaying a popup
//				AlertDialog myAlert = new AlertDialog.Builder(getApplicationContext()).create();
//				myAlert.setTitle("You tapped the card");
//				myAlert.setMessage("Are you sure?");
//				myAlert.setButton("OK", new DialogInterface.OnClickListener() {
//					public void onClick(DialogInterface dialog, int which) {
//						
//					}
//				});
//				myAlert.setIcon(R.drawable.logo);
//				myAlert.show();
			}
		});
		
		// navigation
		Button buttonLeft = (Button) findViewById(R.id.buttonLeft);
		buttonLeft.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// verify if it's possible to go back
				if (Globals.getIndexWhiteCard() > 0) {
					Globals.setIndexWhiteCard(Globals.getIndexWhiteCard() - 1);
					Button card = (Button) findViewById(R.id.buttonCard);
					card.setText(Globals.getPlayers().get(0).getMyHand().get(Globals.getIndexWhiteCard()).getContent());
				}
			}
		});

		Button buttonRight = (Button) findViewById(R.id.buttonRight);
		buttonRight.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// verify if it's possible to go further
				if (Globals.getIndexWhiteCard() < 6) {
					Button card = (Button) findViewById(R.id.buttonCard);
					Globals.setIndexWhiteCard(Globals.getIndexWhiteCard() + 1);
					card.setText(Globals.getPlayers().get(0).getMyHand().get(Globals.getIndexWhiteCard()).getContent());
				}
			}
		});

	}
}
//