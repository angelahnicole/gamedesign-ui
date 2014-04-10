package com.csci491.cardsagainsthumanity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class StartNewRoundActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_new_round);
		// rest of the code

		TextView round = (TextView) findViewById(R.id.lblRoundNum);
		round.setText(" " + Globals.getRoundNum());
		
		Globals.setRoundNum(Globals.getRoundNum() + 1);
		
		System.out.println("Next Round Number: " + Globals.getRoundNum());
		
		Button buttonSkip = (Button) findViewById(R.id.buttonSkip);
		buttonSkip.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(StartNewRoundActivity.this, InGameActivity.class);
				startActivity(intent);
				// finish();
			}
		});
	}
}
//