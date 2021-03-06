package es.ugr.redforest.museumsforeveryone.screens;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import es.ugr.redforest.museumsforeveryone.R;
import es.ugr.redforest.museumsforeveryone.utils.ControllerPreferences;

/**
 * Activity which shows two buttons about accessibility or enter the museum
 *
 * @author Julian Torices Hernandez
 * @version 1.0.0
 */
public class ActivityFirstView extends AppCompatActivity {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_view2);
	}

	/**
	 * Assign an action to do on element click
	 *
	 * @author Julian Torices Hernandez
	 * @version 1.0.0
	 */
	public void launchAccessibilityActivity(View v){
		Intent accessibilityIntent = new Intent(ActivityFirstView.this, ActivityAccessibility.class);
		startActivity(accessibilityIntent);
	}

	/**
	 * On click set accessibility preference, no accessibility problems
	 *
	 * @author Julian Torices Hernandez
	 * @version 1.0.0
	 */
	public void buttonEnterMuseum(View v){
		ControllerPreferences preferences= ControllerPreferences.getInstance();
		preferences.savePreferencesDisability(this,0);
		Intent instructionIntent = new Intent(ActivityFirstView.this, ActivityInstructionsMain.class);
		instructionIntent.putExtra("FirstTime","True");
		startActivity(instructionIntent);
	}
}
