package com.csci491.cardsagainsthumanity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
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
				Intent intent = new Intent(StartNewRoundActivity.this,
						InGameActivity.class);
				startActivity(intent);
				// finish();
			}
		});

		// Find Tablelayout defined in xml
		TableLayout tl = (TableLayout) findViewById(R.id.tablePlayers);
		// Create new rows to be added.
		for (int i = 0; i < Globals.getPlayers().size(); i++) {
			TableRow tr = new TableRow(this);
			tr.setLayoutParams(new TableRow.LayoutParams(
					TableRow.LayoutParams.FILL_PARENT,
					TableRow.LayoutParams.WRAP_CONTENT));
			// Add controls to row
			tr.addView(CreateTextView(i + 1, true));
			tr.addView(CreateTextView(i, false));
			// Add row to TableLayout
			// tr.setBackgroundResource(R.drawable.sf_gradient_03);
			tl.addView(tr, new TableLayout.LayoutParams(
					TableLayout.LayoutParams.FILL_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

		}
	}

	private TextView CreateTextView(int i, boolean showName) {
		TextView textView = new TextView(getApplicationContext());
		textView.setTextAppearance(getApplicationContext(),
				android.R.style.TextAppearance_Medium);
		if (showName) {
			textView.setText("Player" + i);
		} else {
			textView.setText(Globals.getPlayers().get(i).getScore() + " points");
		}

		// Display display = getWindowManager().getDefaultDisplay();
		// Point size = new Point();
		// display.getSize(size);
		// int width = size.x;
		// int height = size.y;

		// textView.setWidth(width/2);

		return textView;
	}
}
//