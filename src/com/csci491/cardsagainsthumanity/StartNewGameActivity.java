package com.csci491.cardsagainsthumanity;

import java.util.ArrayList;

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
					Globals.setPointLimit(Integer.parseInt(editTextPointLimit
							.getText().toString()));
					Globals.setNumPlayers(Integer.parseInt(editTextPlayers
							.getText().toString()));

					// creating players
					ArrayList<Player> custArr = new ArrayList<Player>();
					for (int i = 1; i <= Globals.getNumPlayers(); i++) {
						custArr.add(new Player());
					}

					System.out.println("Num Players: " + custArr.size());

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