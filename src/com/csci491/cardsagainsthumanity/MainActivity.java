/* |===========================================================================
 * |					Cards Against Humanity
 * |
 * | 					Garcia, Meissner, Woelich
 * |---------------------------------------------------------------------------
 * |                         Main Activity
 * |=========================================================================== 
 */

package com.csci491.cardsagainsthumanity;

import java.util.Collections;

import com.csci491.cardsagainsthumanity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Hacky way - potential memory leak
		FileIO cardMaker = new FileIO(this);
		
		// Preferred Way - better decoupling
//		FileIO cardMaker = new FileIO();
		
		
		// Last resort methods
//		Globals.setWhiteCards(cardMaker.hardCodedWhiteCards());
//		Globals.setBlackCards(cardMaker.hardCodedBlackCards());
		
		// Method calls to read in the files
		Globals.setWhiteCards(cardMaker.readWhiteCards());
		Globals.setBlackCards(cardMaker.readBlackCards());
		
		// Shuffles the decks of cards
		Collections.shuffle(Globals.getWhiteCards());
		Collections.shuffle(Globals.getBlackCards());
		
		System.out.println("Num White Cards: " + Globals.getWhiteCards().size());
		System.out.println("Num Black Cards: " + Globals.getBlackCards().size());
		
		Button buttonStart = (Button) findViewById(R.id.buttonStart);
		buttonStart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						StartNewGameActivity.class);
				startActivity(intent);
				// finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
