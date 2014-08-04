package com.karthi.gallery;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

	LayoutInflater layoutInflater;

	public Integer[] myImages = { R.drawable.pic_1, R.drawable.pic_2,
			R.drawable.pic_3, R.drawable.pic_4, R.drawable.pic_5,
			R.drawable.pic_6, R.drawable.pic_7, R.drawable.pic_8,
			R.drawable.pic_9, R.drawable.pic_10, R.drawable.pic_11,
			R.drawable.pic_12, R.drawable.pic_13, R.drawable.pic_14,
			R.drawable.pic_15 };

	public String[] myNames = { "Kate", "Bean", "Brad", "Jolie", "Bale", "yo",
			"Aish", "Hugh", "black", "pitt", "oops", "Bat", "Joker", "hero",
			"Spider" };

	Context myContext;

	public ImageAdapter(Context context) {
		myContext = context;
	}

	@Override
	public int getCount() {
		return myImages.length;
	}

	@Override
	public Object getItem(int position) {
		return myImages[position];
	}

	@Override
	public long getItemId(int position) {
		return myImages[position].longValue();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		layoutInflater = (LayoutInflater) myContext
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.layout_grid_item,
					null);
		}

		
		
		ImageView imageView = (ImageView) convertView
				.findViewById(R.id.imageView);
		TextView textView = (TextView) convertView.findViewById(R.id.name);
		imageView.setImageResource(myImages[position]);
		textView.setText(myNames[position]);
		imageView.setLayoutParams(new LinearLayout.LayoutParams(400, 400));
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		return convertView;
	}
}
