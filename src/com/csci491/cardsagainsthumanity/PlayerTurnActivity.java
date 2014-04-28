package com.csci491.cardsagainsthumanity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PlayerTurnActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_turn);

		changePlayer();
		
		lookForWinner();

	}

	public void changePlayer() {
		TextView textViewPlayerTurnMessage = (TextView) findViewById(R.id.textViewPlayerTurnMessage);
		Button buttonContinue = (Button) findViewById(R.id.buttonContinue);

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

		// Goes to next player
		// KNOW BUG 2nd round and so on:
		// The Czar turn is coming before than all other players could play!
		Globals.setIndexHumanPlayer(Globals.getIndexHumanPlayer() + 1 < Globals
				.getPlayers().size() ? Globals.getIndexHumanPlayer() + 1 : 0);

		// if this next player is Czar
		if (Globals.getPlayers().get(Globals.getIndexHumanPlayer()).isCzar()) {
			// next player is Czar
			textViewPlayerTurnMessage.setText(Globals.getPlayers()
					.get(Globals.getIndexHumanPlayer()).getName()
					+ " You're the card Czar!");

			buttonContinue.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent intent = new Intent(PlayerTurnActivity.this,
							CzarActivity.class);
					startActivity(intent);
					finish();
				}
			});
		} else {
			// next player is a normal player
			textViewPlayerTurnMessage.setText("It's your turn "
					+ Globals.getPlayers().get(Globals.getIndexHumanPlayer())
							.getName() + " !");

			buttonContinue.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent intent = new Intent(PlayerTurnActivity.this,
							InGameActivity.class);
					startActivity(intent);
					finish();
				}
			});
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
	}
	
	public void lookForWinner(){
		TextView textViewPlayerTurnMessage = (TextView) findViewById(R.id.textViewPlayerTurnMessage);
		Button buttonContinue = (Button) findViewById(R.id.buttonContinue);
		
		if (Globals.isWinner()){
			textViewPlayerTurnMessage.setText(Globals.getWinnerName() + " won this round!");
			
			buttonContinue.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent intent = new Intent(PlayerTurnActivity.this,
							NewRoundActivity.class);
					startActivity(intent);
					finish();
				}
			});
			Globals.setIsWinner(false);
		}
	}
}