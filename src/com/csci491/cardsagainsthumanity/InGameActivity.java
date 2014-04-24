package com.csci491.cardsagainsthumanity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InGameActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingame);

		System.out.println("InGameActivity: WhiteCards: "
				+ Globals.getWhiteCards().size());
		System.out.println("InGameActivity: BlackCards: "
				+ Globals.getBlackCards().size());

		// Set question and make sure it won't appear again in the same game
		TextView question = (TextView) findViewById(R.id.textViewQuestion);
		question.setText(Globals.getBlackCards().remove(0).getContent());
//		question.setText(Globals.getBlackCards().get(0).getContent());
//		Globals.getBlackCards().remove(0);
		
		
		// Set Card based on player's hand
		Button buttonCard = (Button) findViewById(R.id.buttonCard);
		buttonCard.setText(Globals.getPlayers().get(Globals.getIndexHumanPlayer()).getMyHand().get(0).getContent());

		buttonCard.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// turn the visibility of the "submit" button to TRUE
				Button buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

				if (buttonSubmit.getVisibility() == View.GONE) {
					buttonSubmit.setVisibility(View.VISIBLE);
				} else {
					buttonSubmit.setVisibility(View.GONE);
				}

				buttonSubmit.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
//						Toast.makeText(getBaseContext(), "You clicked submit on: " + Globals.getPlayers().get(0).getMyHand().get(Globals.getIndexWhiteCard()).getContent(), Toast.LENGTH_SHORT).show();
						Globals.getPlays().add(Globals.getPlayers().get(Globals.getIndexHumanPlayer()).getMyHand().remove(Globals.getIndexWhiteCard()));
						
						for (int i = 0; i < Globals.getPlayers().size(); i++) {
							if (i != Globals.getIndexHumanPlayer()) {
								
							} else {
								
							}
						}
						
					}
				});
			}
		});

		// navigation (white cards)
		Button buttonLeft = (Button) findViewById(R.id.buttonLeft);
		buttonLeft.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// verify if it's possible to go back
				if (Globals.getIndexWhiteCard() > 0) {
					Globals.setIndexWhiteCard(Globals.getIndexWhiteCard() - 1);
					Button card = (Button) findViewById(R.id.buttonCard);
					card.setText(Globals.getPlayers().get(Globals.getIndexHumanPlayer()).getMyHand()
							.get(Globals.getIndexWhiteCard()).getContent());

					Button submit = (Button) findViewById(R.id.buttonSubmit);
					submit.setVisibility(View.GONE);
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
					card.setText(Globals.getPlayers().get(Globals.getIndexHumanPlayer()).getMyHand()
							.get(Globals.getIndexWhiteCard()).getContent());

					Button submit = (Button) findViewById(R.id.buttonSubmit);
					submit.setVisibility(View.GONE);
				}
			}
		});

	}

	// Show menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ingame, menu);

		return true;
	}

	// Menu:
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.action_leavegame:
			AlertDialog.Builder builder = new AlertDialog.Builder(
					InGameActivity.this);
			builder.setTitle(R.string.leave_game_message);
			// Add the buttons
			builder.setPositiveButton(R.string.leave_game,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							// Leave Game
							Intent intent = new Intent(InGameActivity.this,
									MainActivity.class);
							startActivity(intent);
						}
					});
			builder.setNegativeButton(R.string.cancel,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							// User cancelled the dialog
						}
					});

			// Create the AlertDialog
			AlertDialog dialog = builder.create();
			dialog.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}