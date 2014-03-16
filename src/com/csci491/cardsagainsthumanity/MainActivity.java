/* |===========================================================================
 * |					Cards Against Humanity
 * |
 * |                Garciaambrosio, Meissner, Woelich
 * |---------------------------------------------------------------------------
 * |                         Main Activity
 * |=========================================================================== 
 */

package com.csci491.cardsagainsthumanity;

import java.io.FileNotFoundException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FileIO myFileIO = new FileIO();
		GlobalVariables globalVars = (GlobalVariables) getApplicationContext();
		
		try {
			Log.i("ANDREW", "Inside the try, right above where I set the cards");
			globalVars.setWhiteCards(myFileIO.createWhiteCards());
			globalVars.setBlackCards(myFileIO.createBlackCards());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
