package com.example.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.text.format.Formatter;
/**
 * 这个类主要是对wifi的检查，联网的操�?
 * @author ding
 *
 */
public class NetUtil {

	public static final int IP = 0;
	public static final int MAC = 1;
	/**
	 * �?��网络是否可用
	 * 
	 * @return 网络可用的话返回true，不可用的话返回false
	 */
	public static boolean isNetworkAvaiable(Context context,
			final Handler handler, final int what) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		NetworkInfo wifiNetInfo = cm
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (wifiNetInfo == null || wifiNetInfo.isConnected() == false
				|| info == null) {
			// conNet(context);
			reConnect(context, handler, what);
		}
		if (info == null) {
			return false;
		}
		// System.out.println("--------isNetworkAvaiable");

		// �?��手机的漫游状�?info.isRoaming()
		return (wifiNetInfo != null && wifiNetInfo.isConnected());
	}

	/**
	 * 将wifi关闭后再连接
	 * 
	 * @param context
	 */
	public static void reConnect(Context context, final Handler handler,
			final int what) {
		final WifiManager wifi = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (!wifi.isWifiEnabled()) { // 如果wifi没有�?��，则�?���?

					while (!wifi.isWifiEnabled()) {
						try {
							wifi.setWifiEnabled(true);
							sleep(10000);
							if (wifi.isWifiEnabled()) {
								handler.sendEmptyMessage(what);
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
//							new MyException(e);//只记录，不用抛�?
						}

					}
				} else {
					try {
						wifi.setWifiEnabled(false);
						sleep(3000);
						while (!wifi.isWifiEnabled()) {
							wifi.setWifiEnabled(true);
							sleep(7000);
							if (wifi.isWifiEnabled()) {
								handler.sendEmptyMessage(what);
							}
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
//						new MyException(e);//只记录，不用抛�?
					}
				}
				super.run();
			}

		}.start();

	}

	/**
	 * 断网的时候的连接
	 */
	public static void conNet(Context context,String ssid,String pwd) {
		WifiManager wifi = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		if (!wifi.isWifiEnabled()) { // 如果wifi没有�?��，则�?���?
			wifi.setWifiEnabled(true);
		}
		WifiConfiguration wc = new WifiConfiguration();
//		wc.SSID = "\"hxtx\""; // 配置wifi的SSID，即该热点的名称，如�?hxtx"
		wc.SSID = "\""+ssid+"\""; // 配置wifi的SSID，即该热点的名称，如�?hxtx"
		wc.preSharedKey = "\""+pwd+"\""; // 该热点的密码 "5432167890"
		wc.hiddenSSID = true;
		wc.status = WifiConfiguration.Status.ENABLED;
		wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
		wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
		wc.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
		wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
		wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
		wc.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
	}
	
	/**
	 * 得到平板的wifi设置参数
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getWifiParameter(Context context,int style) {
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		String parameter = "";
		if(style == IP){
			int ipAddress = wifiInfo.getIpAddress();
			parameter = Formatter.formatIpAddress(ipAddress);
		}else if(style == MAC){
			parameter = wifiInfo.getMacAddress();
		}
		return parameter;
	}
	
	/**
	 * �?��wifi是否连接�?
	 * @param inContext
	 * @return
	 */
	public static boolean isWiFiConnect(Context inContext) {
        Context context = inContext.getApplicationContext();
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getTypeName().equals("WIFI") && info[i].isConnected()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
	
}
