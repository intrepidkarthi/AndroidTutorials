package com.karthi.gridgame;

import java.util.Random;

import com.exa.gridgame.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class GridActivity extends Activity {

	int currentRandom;
	MyCounter countDownTimer;
	GridView gridView;
	EditText resultBox;
	Button startButton, stopButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid);

		gridView = (GridView) findViewById(R.id.gridview);
		startButton = (Button) findViewById(R.id.start);
		stopButton = (Button) findViewById(R.id.stop);
		resultBox = (EditText) findViewById(R.id.answerbox);
		ImageAdapter imageAdapter = new ImageAdapter(this, generateRandom());
		gridView.setAdapter(imageAdapter);
		
		

		resultBox.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (s.length() > 0) {
					if (currentRandom == Integer.parseInt(s.toString()))
						Toast.makeText(getApplicationContext(), "Correct!",
								1000).show();
					else
						Toast.makeText(getApplicationContext(), "No dude!",
								1000).show();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				countDownTimer = new MyCounter(20000, 1000);
				countDownTimer.start();

			}
		});

		stopButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				countDownTimer.cancel();
			}
		});

	}

	private int generateRandom() {
		Random rand = new Random();
		int random = rand.nextInt(8);
		return random;
	}

	class MyCounter extends CountDownTimer {

		public MyCounter(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onTick(long millisUntilFinished) {

			Log.d("seconds ", "" + millisUntilFinished);

			if ((millisUntilFinished / 1000) % 2 == 0) {
				currentRandom = generateRandom();
				Log.d("Current random numer ", "" + currentRandom);
				ImageAdapter imageAdapter = new ImageAdapter(
						getApplicationContext(), currentRandom);
				gridView.setAdapter(imageAdapter);
			}

		}

		@Override
		public void onFinish() {
			countDownTimer.cancel();

		}

	}

}