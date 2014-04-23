package com.csci491.cardsagainsthumanity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartNewGameActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_new_game);

		Button buttonCancel = (Button) findViewById(R.id.buttonCancel);
		buttonCancel.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(StartNewGameActivity.this,
						MainActivity.class);
				startActivity(intent);
				// finish();
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
						.toString()) < 2) {
					Toast.makeText(getBaseContext(),
							"You need at least 3 players: You and 2 more", Toast.LENGTH_SHORT)
							.show();
				} else if (Integer.parseInt(editTextPlayers.getText()
						.toString()) > 20) {
					Toast.makeText(getBaseContext(),
							"There's too many players! The limit is 20.", Toast.LENGTH_SHORT)
							.show();
				} else {
					// store variables and create a game
					Globals.setPointLimit(Integer.parseInt(editTextPointLimit
							.getText().toString()));
					Globals.setNumPlayers(Integer.parseInt(editTextPlayers
							.getText().toString()));
					CreateGame();
				}
			}

		});

	}

	private void CreateGame() {

		System.out.println("Score Limit: " + Globals.getPointLimit());
		System.out.println("Num Players: " + Globals.getNumPlayers());

		// creating players
		System.out.println("Creating the players...");
		
		//cleans the variable that stores players
		Globals.setPlayers(new  ArrayList<Player>());
		
		for (int i = 0; i < Globals.getNumPlayers(); i++) {			
			// if the parameter being passed into the Player
			// constructor is true,
			// then the player is a human player.

			// else if the parameter in the Player constructor is
			// false,
			// then the player is a computer
			if (i == 0) {
				Globals.getPlayers().add(new Player(true));
			} else {
				Globals.getPlayers().add(new Player(false));
			}
		}
		System.out.println("Players successfully created!");

		
		Intent intent = new Intent(StartNewGameActivity.this, PlayerActivity.class);
//		Intent intent = new Intent(StartNewGameActivity.this, StartNewRoundActivity.class);
		startActivity(intent);
		// finish();

	}

}
