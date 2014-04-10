package com.csci491.cardsagainsthumanity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class InGameActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingame);
		// rest of the code
		
		System.out.println("InGameActivity: WhiteCards: " + Globals.getWhiteCards().size());
		System.out.println("InGameActivity: BlackCards: " + Globals.getBlackCards().size());
		
		TextView question = (TextView)findViewById(R.id.textViewQuestion);
		question.setText(Globals.getBlackCards().get(0).getContent());
		Globals.getBlackCards().remove(0);
		
		Button card = (Button)findViewById(R.id.buttonCard);
		card.setText(Globals.getPlayers().get(0).getMyHand().get(0).getContent());

	}
}
//