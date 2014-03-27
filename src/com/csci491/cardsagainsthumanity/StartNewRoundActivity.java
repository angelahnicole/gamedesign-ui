package com.csci491.cardsagainsthumanity;

import com.csci491.cardsagainsthumanity.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;


public class StartNewRoundActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_new_round);
		// rest of the code

		Button buttonSkip = (Button) findViewById(R.id.buttonSkip);
		buttonSkip.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(StartNewRoundActivity.this,
						InGameActivity.class);
				startActivity(intent);
				// finish();
			}
		});
	}
}
//