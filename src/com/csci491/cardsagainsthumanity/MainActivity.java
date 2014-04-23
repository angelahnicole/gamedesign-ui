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

}
