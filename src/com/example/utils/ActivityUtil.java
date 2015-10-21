package com.example.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class ActivityUtil {

	
	
	/**
	 * 跳转到某个activity,并把这个activity关掉
	 * @param mActivity
	 * @param cls
	 */
	@SuppressWarnings("rawtypes")
	public static void startOneActivity(Activity mActivity, Class cls){
		Intent intent = new Intent(mActivity, cls);
		mActivity.startActivity(intent);
		mActivity.finish();
	}
	
	
	public static boolean hasActivity(Context context, String pkg, String cls) {
		boolean has = true;
		Intent intent = new Intent();
		intent.setClassName(pkg, cls);
		if (context.getPackageManager().resolveActivity(intent, 0) == null) {
			// 说明系统中不存在这个activity
			has = false;
		}
		return has;
	}

	
	/**
	 * 跳转到某个activity,并把这个activity关掉
	 * @param mActivity
	 * @param cls
	 */
	@SuppressWarnings("rawtypes")
	public static void startOneActivityByContext(Context mActivity, Class cls){
		Intent intent = new Intent(mActivity, cls);
		mActivity.startActivity(intent);
		((Activity) mActivity).finish();
	}
	
}
