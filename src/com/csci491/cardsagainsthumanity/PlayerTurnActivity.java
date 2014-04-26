package com.csci491.cardsagainsthumanity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerTurnActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_turn);
		
		//move to next player
		// CHANGE THIS CODE! IT OVERFLOWS THE INDEX!
		Globals.setIndexHumanPlayer(Globals.getIndexHumanPlayer() +1);
		
		TextView textViewPlayerIndex = (TextView) findViewById(R.id.textViewPlayerIndex);
		
		//Verify if the next player is a normal one or Czar
		if (Globals.getPlayers().get(Globals.getIndexHumanPlayer()).isCzar()){
			//it's Czar
			textViewPlayerIndex.setText(Globals.getPlayers().get(Globals.getIndexHumanPlayer()).getName()+" You're the card Czar!");
			//define the new Czar
			// CHANGE THIS CODE! IT OVERFLOWS THE INDEX!
			Globals.getPlayers().get(Globals.getIndexHumanPlayer()).setCzar(false);
			Globals.getPlayers().get(Globals.getIndexHumanPlayer()-1).setCzar(true);
		}
		else
		{
			//it's a normal player
			textViewPlayerIndex.setText("It's your turn " + Globals.getPlayers().get(Globals.getIndexHumanPlayer()).getName()+" !");
		}
		
		
		Button buttonContinue = (Button) findViewById(R.id.buttonContinue);
		buttonContinue.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(PlayerTurnActivity.this, InGameActivity.class);
				startActivity(intent);
				finish();
			}
		});	
		
	}
}