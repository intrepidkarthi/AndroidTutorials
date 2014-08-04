package com.karthi.gridgame;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

	LayoutInflater layoutInflater;
	public String[] myNames = { "Kate", "Bean", "Brad", "Jolie", "Bale", "yo",
			"Aish", "Hugh", "black", "pitt", "oops", "Bat", "Joker", "hero",
			"Spider" };
	int randValue;
	Context myContext;

	public ImageAdapter(Context context, int val) {
		myContext = context;
		randValue = val;
	}

	@Override
	public int getCount() {
		return 9;
	}

	@Override
	public Object getItem(int position) {
		return myNames[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@SuppressLint("ResourceAsColor")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ImageView imageView = new ImageView(myContext);		
		//imageView.setImageResource(myImages[position]);
		if(randValue == position)
			imageView.setBackgroundColor(Color.BLACK);
		else
			imageView.setBackgroundColor(Color.GREEN);
		
		
		imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
		
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		return imageView;
	}
}
