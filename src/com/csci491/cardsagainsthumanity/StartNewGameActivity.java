package com.csci491.cardsagainsthumanity;

import com.csci491.cardsagainsthumanity.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
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
				Intent intent = new Intent(StartNewGameActivity.this,
						StartNewRoundActivity.class);
				startActivity(intent);
				// finish();
			}
		});
	}
}
//