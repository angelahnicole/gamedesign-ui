package com.csci491.cardsagainsthumanity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class PlayerActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		// rest of the code

		// Find Tablelayout defined in xml
		TableLayout tl = (TableLayout) findViewById(R.id.Table1);
		// Create new rows to be added.
		for (int i = 0; i < Globals.getPlayers().size(); i++) {
			TableRow tr = new TableRow(this);
			tr.setLayoutParams(new TableRow.LayoutParams(
					TableRow.LayoutParams.FILL_PARENT,
					TableRow.LayoutParams.WRAP_CONTENT));
			// Add controls to row
			tr.addView(CreateEditText(i + 1));
			tr.addView(CreateSpinner(i));
			// Add row to TableLayout
			// tr.setBackgroundResource(R.drawable.sf_gradient_03);
			tl.addView(tr, new TableLayout.LayoutParams(
					TableLayout.LayoutParams.FILL_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

		}
		// Create StartNewGame button
		Button buttonStartNewGame = new Button(this);
		buttonStartNewGame.setText("Start Game");
		buttonStartNewGame.setBackgroundColor(getBaseContext().getResources().getColor(R.color.greenT));

		buttonStartNewGame.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(PlayerActivity.this,
						StartNewRoundActivity.class);
				startActivity(intent);
				// finish();
			}
		});
		tl.addView(buttonStartNewGame, new TableLayout.LayoutParams(
				TableLayout.LayoutParams.FILL_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT));

		// Deal out cards to each player
		System.out.println("Dealing out the cards...");

		for (int i = 0; i < Globals.getHandSize(); i++) {
			for (int j = 0; j < Globals.getPlayers().size() - 1; j++) {
				Globals.getPlayers().get(j).draw();
			}
		}
		System.out.println("Cards successfully dealt!");
	}

	private TextView CreateEditText(int i) {
		EditText editText = new EditText(getApplicationContext());
		editText.setTextAppearance(getApplicationContext(),
				android.R.style.TextAppearance_Medium);
		editText.setText("Player " + i);

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;

		editText.setWidth(width / 2);

		return editText;
	}

	private Spinner CreateSpinner(int i) {
		Spinner spinner = new Spinner(this);
		ArrayList<String> spinnerArray = new ArrayList<String>();
		// First player is always you
		if (i == 0) {
			spinnerArray.add("YOU");
			spinner.setEnabled(false);
		} else {

			spinnerArray.add("COMPUTER");
			spinnerArray.add("HUMAN");
		}
		ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_dropdown_item,
				spinnerArray);
		spinner.setAdapter(spinnerArrayAdapter);
		spinner.setLayoutParams(new TableRow.LayoutParams(
				TableRow.LayoutParams.FILL_PARENT,
				TableRow.LayoutParams.WRAP_CONTENT));
		return spinner;
	}
}