package com.csci491.cardsagainsthumanity;

import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewGameActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_new_game);

		Button buttonCancel = (Button) findViewById(R.id.buttonCancel);
		buttonCancel.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(NewGameActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			}
		});

		Button buttonNext = (Button) findViewById(R.id.buttonNext);
		buttonNext.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// find controls
				EditText editTextPointLimit = (EditText) findViewById(R.id.editTextPointLimit);
				EditText editTextPlayers = (EditText) findViewById(R.id.editTextPlayers);

				// verify integrity of data
				if (editTextPointLimit.getText().toString().length() == 0) {
					Toast.makeText(getBaseContext(),
							"Point limit cannot be left blank!",
							Toast.LENGTH_SHORT).show();
				} else if (editTextPlayers.getText().toString().length() == 0) {
					Toast.makeText(getBaseContext(),
							"Player limit cannot be left blank!",
							Toast.LENGTH_SHORT).show();
				} else if (Integer.parseInt(editTextPlayers.getText()
						.toString()) < 3) {
					Toast.makeText(getBaseContext(),
							"You need at least 3 players.", Toast.LENGTH_SHORT)
							.show();
				} else if (Integer.parseInt(editTextPlayers.getText()
						.toString()) > 10) {
					Toast.makeText(getBaseContext(),
							"There's too many players! The limit is 10.",
							Toast.LENGTH_SHORT).show();
				} else {
					// Reset everything, to make sure there is nothing from a
					// possible previous game
					Globals.resetGlobals();

					// store variables and create a game
					Globals.setPointLimit(Integer.parseInt(editTextPointLimit
							.getText().toString()));
					Globals.setNumPlayers(Integer.parseInt(editTextPlayers
							.getText().toString()));
					createCards();
					createGame();
				}
			}

		});

	}

	private void createGame() {

		System.out.println("Score Limit: " + Globals.getPointLimit());
		System.out.println("Num Players: " + Globals.getNumPlayers());

		// creating players
		System.out.println("Creating the players...");

		for (int i = 0; i < Globals.getNumPlayers(); i++) {
			// if the parameter being passed into the Player
			// constructor is true,
			// then the player is a human player.

			// else if the parameter in the Player constructor is false,
			// then the player is a computer
			if (i == 0) {
				// First player is always "You"
				Globals.getPlayers().add(new Player("You", true, false));
			} else
				if (i == Globals.getNumPlayers() - 1) {
				// last player is by default Czar
				//Globals.getPlayers().add(new Player(Globals.generateRandomName(), true, true));
				Globals.getPlayers().add(new Player("Player " +i, true, true));
			} else {
				//other players
				//Globals.getPlayers().add(new Player(Globals.generateRandomName(), true, false));
				Globals.getPlayers().add(new Player("Player " + i, true, false));
			}
		}
		//make a copy of the players
		//useful when dealing with Czar
		Globals.setORIGINALplayers(Globals.getPlayers());
		
		System.out.println("Players successfully created!");

		Intent intent = new Intent(NewGameActivity.this,
				PlayerConfigActivity.class);
		startActivity(intent);
		// finish();

	}

	private void createCards() {
		Globals.getCardMaker().setContext(this);
		Globals.setWhiteCards(Globals.getCardMaker().readWhiteCards());
		Globals.setBlackCards(Globals.getCardMaker().readBlackCards());

		// Shuffles the decks of cards
		Collections.shuffle(Globals.getWhiteCards());
		Collections.shuffle(Globals.getBlackCards());

		System.out
				.println("Num White Cards: " + Globals.getWhiteCards().size());
		System.out
				.println("Num Black Cards: " + Globals.getBlackCards().size());
	}

}
