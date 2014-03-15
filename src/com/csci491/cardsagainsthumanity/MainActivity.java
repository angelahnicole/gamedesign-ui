/* |===========================================================================
 * |					Cards Against Humanity
 * |
 * | 					Garcia, Meissner, Woelich
 * |---------------------------------------------------------------------------
 * |                         Main Activity
 * |=========================================================================== 
 */

package com.csci491.cardsagainsthumanity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		FileIO myFileIO = new FileIO();
		((GlobalVariables) this.getApplication()).setWhiteCards(myFileIO.createWhiteCards());
		((GlobalVariables) this.getApplication()).setBlackCards(myFileIO.createBlackCards());
		
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
