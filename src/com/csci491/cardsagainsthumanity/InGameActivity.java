package com.csci491.cardsagainsthumanity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InGameActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingame);
		// rest of the code

		System.out.println("InGameActivity: WhiteCards: " + Globals.getWhiteCards().size());
		System.out.println("InGameActivity: BlackCards: " + Globals.getBlackCards().size());

		TextView question = (TextView) findViewById(R.id.textViewQuestion);
		question.setText(Globals.getBlackCards().get(0).getContent());
		Globals.getBlackCards().remove(0);

		Button card = (Button) findViewById(R.id.buttonCard);
		card.setText(Globals.getPlayers().get(0).getMyHand().get(0).getContent());

		card.setOnClickListener(new OnClickListener() {
//			@SuppressWarnings("deprecation")
			public void onClick(View v) {
				// turn the visibility of the "submit" button to TRUE
				
				Button submit = (Button) findViewById(R.id.buttonSubmit);
				
				if (submit.getVisibility() == View.GONE){
					submit.setVisibility(View.VISIBLE);
				} else {
					submit.setVisibility(View.GONE);
				}
				
				submit.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						Toast.makeText(getBaseContext(), "You clicked submit on: " + Globals.getPlayers().get(0).getMyHand().get(Globals.getIndexWhiteCard()).getContent(), Toast.LENGTH_SHORT).show();
					}
				});
			}
		});
		
		// navigation
		Button buttonLeft = (Button) findViewById(R.id.buttonLeft);
		buttonLeft.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// verify if it's possible to go back
				if (Globals.getIndexWhiteCard() > 0) {
					Globals.setIndexWhiteCard(Globals.getIndexWhiteCard() - 1);
					Button card = (Button) findViewById(R.id.buttonCard);
					card.setText(Globals.getPlayers().get(0).getMyHand().get(Globals.getIndexWhiteCard()).getContent());
					
					Button submit = (Button) findViewById(R.id.buttonSubmit);
					submit.setVisibility(View.GONE);
					
				}
			}
		});

		Button buttonRight = (Button) findViewById(R.id.buttonRight);
		buttonRight.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// verify if it's possible to go further
				if (Globals.getIndexWhiteCard() < 6) {
					Button card = (Button) findViewById(R.id.buttonCard);
					Globals.setIndexWhiteCard(Globals.getIndexWhiteCard() + 1);
					card.setText(Globals.getPlayers().get(0).getMyHand().get(Globals.getIndexWhiteCard()).getContent());
					
					Button submit = (Button) findViewById(R.id.buttonSubmit);
					submit.setVisibility(View.GONE);
				}
			}
		});

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ingame, menu);
		return true;
	}
}
//