package com.fandy.learn.listview_image.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by lixiaoniu on 2018/1/3.
 */

public class NetWorkUtil {
    public static boolean IsNetWorkEnable(Context context) {
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity == null) {
//                ToastUtil.showMessage(context, "无法连接网络");
                return false;
            }

            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 判断当前网络是否已经连接
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        ToastUtil.showMessage(context, "无法连接网络");
        return false;
    }
}
