package com.csci491.cardsagainsthumanity;

import java.util.ArrayList;
import java.util.Collections;

import com.csci491.cardsagainsthumanity.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class StartNewGameActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_new_game);
		// rest of the code

		Button buttonCancel = (Button) findViewById(R.id.buttonCancel);
		buttonCancel.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(StartNewGameActivity.this,
						MainActivity.class);
				startActivity(intent);
				// finish();
			}
		});

		Button buttonStartGame = (Button) findViewById(R.id.buttonStartGame);
		buttonStartGame.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// find controls
				EditText editTextPointLimit = (EditText) findViewById(R.id.editTextPointLimit);
				EditText editTextPlayers = (EditText) findViewById(R.id.editTextPlayers);

				// verify integrity of data
				if (editTextPointLimit.getText().toString() == ""
						|| editTextPlayers.getText().toString() == "") {
					// display error message!
				} else {

					// store variables
					Globals.setPointLimit(Integer.parseInt(editTextPointLimit.getText().toString()));
					Globals.setNumPlayers(Integer.parseInt(editTextPlayers.getText().toString()));


					System.out.println("Score Limit: " + Globals.getPointLimit());
					System.out.println("Num Players: " + Globals.getNumPlayers());
					
					// creating players
//					ArrayList<Player> custArr = new ArrayList<Player>();
//					for (int i = 1; i <= Globals.getNumPlayers(); i++) {
//						custArr.add(new Player());
//					}

//					System.out.println("Num Players: " + custArr.size());
					
					System.out.println("Creating the players...");
					Globals.getPlayers().add(new Player(true));
					for (int i = 0; i < Globals.getNumPlayers(); i++) {
						// if the parameter being passed into the Player constructor is true,
						// then the player is a human player.	
						
						// else if the parameter in the Player constructor is false,
						// then the player is a computer
						if (i == 0) {
							Globals.getPlayers().add(new Player(true));	
						} else {
							Globals.getPlayers().add(new Player(false));
						}
						
					}
					System.out.println("Players successfully created!");
					
					
					System.out.println("Dealing out the cards...");
					// Deal out cards to each player
					// TODO fix this... the draw method is messed up
					for (int i = 0; i < Globals.getHandSize(); i++) {
						for (int j = 0; j < Globals.getPlayers().size(); j++) {
							Globals.getPlayers().get(j).draw();
						}
					}
					System.out.println("Cards successfully dealt!");
					
					Intent intent = new Intent(StartNewGameActivity.this,
							StartNewRoundActivity.class);
					startActivity(intent);
					// finish();
				}
			}
		});
	}
}
//