package com.csci491.cardsagainsthumanity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PlayerTurnActivity extends Activity {
	public static int indexCzarSkipped = -1;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_turn);

		changePlayer();

		lookForWinner();

	}

	public void changePlayer() {

		if (Globals.getPlayers().get(Globals.getIndexHumanPlayer()).isCzar()) {
			// if player was Czar, now set as normal player
			Globals.getPlayers().get(Globals.getIndexHumanPlayer())
					.setCzar(false);
			// choose the new Czar
			Globals.getPlayers()
					.get(Globals.getIndexHumanPlayer() - 1 >= 0 ? Globals
							.getIndexHumanPlayer() - 1 : Globals
							.getNumPlayers() - 1).setCzar(true);
		}

		// Is there a Czar skipped?
		if (Globals.getIndexHumanPlayer() == indexCzarSkipped) {
			// Yes, make him play and finalize this round
			indexCzarSkipped = -1;
			playCzarPlayer();

			for (int i = Globals.getIndexHumanPlayer(); i < Globals
					.getNumPlayers(); i++) {
				Globals.getPlayers().get(Globals.getIndexHumanPlayer())
						.setPlayedAlready(true);
			}
		} else {
			// No, go to next player
			Globals.setIndexHumanPlayer(Globals.getIndexHumanPlayer() + 1 < Globals
					.getPlayers().size() ? Globals.getIndexHumanPlayer() + 1
					: 0);

			for (int i = 0; i < Globals.getNumPlayers(); i++) {
				// this one already played?
				if (!Globals.getPlayers().get(i).isPlayedAlready()) {
					// is Czar?
					if (!Globals.getPlayers()
							.get(Globals.getIndexHumanPlayer()).isCzar()) {
						// no, so play!
						playNormalPlayer();
					} else {
						// yes it's Czar
						if (Globals.getIndexHumanPlayer() == Globals
								.getNumPlayers() - 1) {
							// it's the last one to play, so play!
							playCzarPlayer();
						} else {
							// store his index
							indexCzarSkipped = Globals.getIndexHumanPlayer();

							// it's not the last, so skip!
							Globals.setIndexHumanPlayer(Globals
									.getIndexHumanPlayer() + 1 < Globals
									.getPlayers().size() ? Globals
									.getIndexHumanPlayer() + 1 : 0);

						}
					}
				}
			}

			if (indexCzarSkipped != -1) {
				Globals.setIndexHumanPlayer(indexCzarSkipped);

			}

			for (int i = 0; i < Globals.getNumPlayers(); i++) {
				Globals.getPlayers().get(Globals.getIndexHumanPlayer())
						.setPlayedAlready(false);
			}
		}
	}

	public void playCzarPlayer() {
		TextView textViewPlayerTurnMessage = (TextView) findViewById(R.id.textViewPlayerTurnMessage);
		Button buttonContinue = (Button) findViewById(R.id.buttonContinue);

		textViewPlayerTurnMessage.setText(Globals.getPlayers()
				.get(Globals.getIndexHumanPlayer()).getName()
				+ " You're the card Czar!");

		Globals.getPlayers().get(Globals.getIndexHumanPlayer())
				.setPlayedAlready(true);

		buttonContinue.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(PlayerTurnActivity.this,
						CzarActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	public void playNormalPlayer() {
		TextView textViewPlayerTurnMessage = (TextView) findViewById(R.id.textViewPlayerTurnMessage);
		Button buttonContinue = (Button) findViewById(R.id.buttonContinue);

		textViewPlayerTurnMessage.setText("It's your turn "
				+ Globals.getPlayers().get(Globals.getIndexHumanPlayer())
						.getName() + " !");

		Globals.getPlayers().get(Globals.getIndexHumanPlayer())
				.setPlayedAlready(true);

		buttonContinue.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(PlayerTurnActivity.this,
						InGameActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	public void lookForWinner() {
		TextView textViewPlayerTurnMessage = (TextView) findViewById(R.id.textViewPlayerTurnMessage);
		Button buttonContinue = (Button) findViewById(R.id.buttonContinue);

		if (Globals.isWinner()) {
			textViewPlayerTurnMessage.setText(Globals.getWinnerName()
					+ " won this round!");

			buttonContinue.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent intent = new Intent(PlayerTurnActivity.this,
							NewRoundActivity.class);
					startActivity(intent);
					finish();
				}
			});
			Globals.setIsWinner(false);

			for (int i = 0; i < Globals.getNumPlayers(); i++) {
				Globals.getPlayers().get(Globals.getIndexHumanPlayer())
						.setPlayedAlready(false);
			}

			Globals.getPlays().clear();

			Globals.setIndexHumanPlayer(0);
		}
	}
}
// move to next player now functions as follows:
//
// if (Globals.getIndexHumanPlayer() + 1 < Globals.getPlayers()
// Globals.setIndexHumanPlayer(Globals.getIndexHumanPlayer() + 1)
// else
// Globals.setIndexHumanPlayer(0);
//
// It checks to see if adding 1 to the current human index is larger
// than the Players size,
// and if it is it starts back at 0, otherwise it adds 1 to the index.
