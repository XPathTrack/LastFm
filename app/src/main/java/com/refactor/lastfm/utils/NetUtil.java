package com.refactor.lastfm.utils;


import android.content.Context;
import android.net.ConnectivityManager;

public class NetUtil {

    private NetUtil() {
    }

    public static boolean isNetWorkConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return manager.getActiveNetwork() != null;
    }
}
