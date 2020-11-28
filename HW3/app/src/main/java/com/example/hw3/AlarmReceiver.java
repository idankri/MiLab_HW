package com.example.hw3;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
    private static int currentQuote;
    private static String[] quotes = {"Hi", "Hello there"};
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle()

    }
}
