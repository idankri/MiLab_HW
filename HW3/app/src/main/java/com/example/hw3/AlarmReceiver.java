package com.example.hw3;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver(){
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        QuoteIntentService.startActionQuote(context);
    }
}
