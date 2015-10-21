package com.example.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

/**
 *
 * @Description: UI工具�? * @author lianxz
 * @Date 2014�?�?6�?下午2:09:23
 */
public class UIHelper {

	/**
	 * 自定义的toast
	 */
	public static void newToast(String message, Context context) {
		MyToast.getInstance(context).show(message);
		/*
		 * Toast toast = new Toast(context); toast.setDuration(10);
		 * toast.setGravity(Gravity.CENTER, 0,-50); LinearLayout.LayoutParams
		 * params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
		 * LayoutParams.WRAP_CONTENT); TextView toastText = new
		 * TextView(context); toastText.setPadding(20, 10, 20, 10);
		 * toastText.setBackgroundResource(R.drawable.kind_tp);
		 * toastText.setLayoutParams(params); toastText.setTextSize(30);
		 * toastText.setTextColor(Color.WHITE);
		 * toastText.setGravity(Gravity.CENTER); toastText.setText(message);
		 * toast.setView(toastText); toast.show();
		 */
	}

	/**
	 * 隐藏view
	 * 
	 * @param view
	 */
	public static void goneCurrentView(View view) {
		if (view != null) {
			view.setVisibility(View.GONE);
		}

	}

}
