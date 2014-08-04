package com.karthi.gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageViewActivity extends Activity {

	ImageView myImageView;
	int imagePosition;
	TextView myTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().hide();
		
		setContentView(R.layout.activity_fullview);
		myImageView = (ImageView) findViewById(R.id.imageView);
		myTextView = (TextView) findViewById(R.id.textView);
		ImageAdapter imageAdapter = new ImageAdapter(this);

		Intent receivedIntent = getIntent();

		imagePosition = receivedIntent.getIntExtra("position", 0);

		myImageView.setImageResource(imageAdapter.myImages[imagePosition]);
		myTextView.setText(imageAdapter.myNames[imagePosition]);
	}

}
