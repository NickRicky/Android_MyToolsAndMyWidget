package com.example.utils;


import com.example.demo_utils.R;

import android.app.Dialog;
import android.content.Context;

/**
 * 
 * @Description: 自定义加载进度条
 * @author lianxz
 * @Date 2014�?�?7�?上午9:42:00
 */

public class MyProgressDialog extends Dialog {

	public MyProgressDialog(Context context) {
		super(context, R.style.myProgressDialog);
		setCancelable(true);
		setCanceledOnTouchOutside(false);
		setContentView(R.layout.progress_dialog);
	}

	@Override
	public void dismiss() {
		super.dismiss();
	}

}
