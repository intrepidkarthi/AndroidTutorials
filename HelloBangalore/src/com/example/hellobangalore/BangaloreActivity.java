package com.example.hellobangalore;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class BangaloreActivity extends Activity {

	Button myButton;
	EditText myEditText;
	String myName;
	VideoView myVideoView;
	Uri myVideoUri;
	MediaController myMediaController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bangalore);

		myButton = (Button) findViewById(R.id.button);
		myEditText = (EditText) findViewById(R.id.name_field);
		myVideoView = (VideoView) findViewById(R.id.videoView);
		
		myMediaController = new MediaController(this);
		myMediaController.setAnchorView(myVideoView);
		

		myVideoUri = Uri
				.parse("android.resource://com.example.hellobangalore/raw/howtotrainyourdragon");
		myVideoView.setMediaController(myMediaController);
		myVideoView.setVideoURI(myVideoUri);
		
		myVideoView.start();
		
		myButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Log.d("BangaloreActivity", "you clicked me!");

				Toast.makeText(getApplicationContext(), "Clicked!",
						Toast.LENGTH_SHORT).show();

				myName = myEditText.getText().toString();

				Intent intent = new Intent(getApplicationContext(),
						NameActivity.class);
				intent.putExtra("name", myName);
				startActivity(intent);

			}
		});

		Log.d("Hellobangalore", "onCreate");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("Hellobangalore", "onStart");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("Hellobangalore", "onPause");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d("Hellobangalore", "onRestart");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("Hellobangalore", "onStop");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("Hellobangalore", "onDestroy");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bangalore, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
