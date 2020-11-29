package com.example.hw3;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.example.hw3.App.CHANNEL_ID;

public class AlarmReceiver extends BroadcastReceiver {
    private static int arrLoc = 0; // current quote to be notified
    private String[] quotes;
    private NotificationManagerCompat notificationManager;

    public AlarmReceiver(){
        super();
        notificationManager = null;
        quotes = null;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        // as broadcast receiver doesn't have an "onCreate" method, this is a workaround that
        // initiates quotes and notificationManager fields in the first time "onReceive" is called
        if(notificationManager == null){
            notificationManager = NotificationManagerCompat.from(context);
        }
        if(quotes == null){
            quotes = context.getResources().getStringArray(R.array.tarantino_movie_quotes);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Quote")
                .setContentText(quotes[arrLoc]);

        notificationManager.notify(1, builder.build());
        arrLoc = (arrLoc + 1) % quotes.length;
    }
}