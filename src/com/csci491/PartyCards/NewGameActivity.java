package com.csci491.PartyCards;

import java.util.Collections;

import com.csci491.PartyCards.R;

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
				Intent intent = new Intent(NewGameActivity.this, MainActivity.class);
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
					Toast.makeText(getBaseContext(), R.string.blank_point_limit_toast, Toast.LENGTH_SHORT).show();
				} else if (editTextPlayers.getText().toString().length() == 0) {
					Toast.makeText(getBaseContext(), R.string.blank_player_limit_toast, Toast.LENGTH_SHORT).show();
				} else if (Integer.parseInt(editTextPlayers.getText().toString()) < 3) {
					Toast.makeText(getBaseContext(), R.string.min_players_toast, Toast.LENGTH_SHORT).show();
				} else if (Integer.parseInt(editTextPlayers.getText().toString()) > 10) {
					Toast.makeText(getBaseContext(), R.string.max_players_toast, Toast.LENGTH_SHORT).show();
				} else {
					// Reset everything, to make sure there is nothing from a
					// possible previous game
					Globals.resetGlobals();
					
					// store variables and create a game
					Globals.setPointLimit(Integer.parseInt(editTextPointLimit.getText().toString()));
					Globals.setNumPlayers(Integer.parseInt(editTextPlayers.getText().toString()));
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
				Globals.getPlayers().add(new Player(i, "You", true, false));
			} else if (i == Globals.getNumPlayers() - 1) {
				// last player is by default Czar
				Globals.getPlayers().add(new Player(i, "Player " + (i + 1), true, true));
			} else {
				// other players
				Globals.getPlayers().add(new Player(i, "Player " + (i + 1), true, false));
			}
		}
		
		System.out.println("Players successfully created!");
		
		Intent intent = new Intent(NewGameActivity.this, PlayerConfigActivity.class);
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
		
		System.out.println("Num White Cards: " + Globals.getWhiteCards().size());
		System.out.println("Num Black Cards: " + Globals.getBlackCards().size());
	}
	
}
