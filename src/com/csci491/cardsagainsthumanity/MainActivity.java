/* |===========================================================================
 * |					Cards Against Humanity
 * |
 * | 					Garcia, Meissner, Woelich
 * |---------------------------------------------------------------------------
 * |                         Main Activity
 * |=========================================================================== 
 */

package com.csci491.cardsagainsthumanity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("Before the try");
		try {
			System.out.println("In the try before everything");
			FileIO reader = new FileIO();
			Globals globals = (Globals) this.getApplicationContext();
			globals.setWhiteCards(reader.createWhiteCards());
			//globals.setBlackCards(reader.createBlackCards());
			System.out.println(globals.getWhiteCards().size());
			for (int i = 0; i < globals.getWhiteCards().size(); i++)
			{
				System.out.println(globals.getWhiteCards().get(i).getContent());
			}
			System.out.println("In the try after everything");
		}
		catch (Exception e)
		{
			System.out.println("Something went wrong somewhere");
		}
		System.out.println("after the try / catch");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
