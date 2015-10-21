package com.example.utils;


import com.example.demo_utils.R;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;


public class MyToast {

	Context context;
	private static MyToast instance = null;
	private Toast toast = null;

	private MyToast() {
	}

	private MyToast(Context context) {
		super();
		this.context = context;
	}

	public static MyToast getInstance(Context context) {
		if (instance == null) {
			instance = new MyToast(context);
		}
		return instance;
	}

	public void show(String text) {

		if (toast != null) {
			toast.setGravity(Gravity.CENTER, 0, -50);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView toastText = new TextView(context);
			toastText.setPadding(20, 10, 20, 10);
			toastText.setBackgroundResource(R.drawable.kind_tp);
			toastText.setLayoutParams(params);
			toastText.setTextSize(30);
			toastText.setTextColor(Color.WHITE);
			toastText.setGravity(Gravity.CENTER);
			toastText.setText(text);
			toast.setView(toastText);
			toast.setDuration(Toast.LENGTH_SHORT);
			toast.show();
		} else {
			creatView(text);
		}
	}

	public void show(int id) {

		if (toast != null) {
			toast.setGravity(Gravity.CENTER, 0, -50);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView toastText = new TextView(context);
			toastText.setPadding(20, 10, 20, 10);
			toastText.setBackgroundResource(R.drawable.kind_tp);
			toastText.setLayoutParams(params);
			toastText.setTextSize(30);
			toastText.setTextColor(Color.WHITE);
			toastText.setGravity(Gravity.CENTER);
			toastText.setText(id+"");
			toast.setView(toastText);
			toast.setDuration(Toast.LENGTH_SHORT);
			toast.show();
		} else {
			creatView(context.getResources().getString(id));
		}
	}

	public void creatView(final String text) {
		toast = new Toast(context);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, -50);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		TextView toastText = new TextView(context);
		toastText.setPadding(20, 10, 20, 10);
		toastText.setBackgroundResource(R.drawable.kind_tp);
		toastText.setLayoutParams(params);
		toastText.setTextSize(30);
		toastText.setTextColor(Color.WHITE);
		toastText.setGravity(Gravity.CENTER);
		toastText.setText(text);
		toast.setView(toastText);

		toast.show();

	}

	public void cancel() {
		toast = null;
	}
}
