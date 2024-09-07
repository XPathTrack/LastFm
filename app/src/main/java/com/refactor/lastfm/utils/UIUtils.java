package com.refactor.lastfm.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class UIUtils {

    private UIUtils() {
    }

    public static AlertDialog buildAlertDialog(Context context, String title, String msg, DialogInterface.OnClickListener callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("OK", callback);
        return builder.create();
    }
}