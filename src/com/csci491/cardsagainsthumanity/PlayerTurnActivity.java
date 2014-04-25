package com.csci491.cardsagainsthumanity;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PlayerTurnActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_turn);
		
		Globals.setIndexHumanPlayer(Globals.getIndexHumanPlayer() +1);
		
		TextView textViewPlayerIndex = (TextView) findViewById(R.id.textViewPlayerIndex);
		textViewPlayerIndex.setText("It's your turn " + Globals.getPlayers().get(Globals.getIndexHumanPlayer()).getName()+" !");
		
	}
}