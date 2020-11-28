package com.example.hw3;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CHANNEL_ID = "quote_channel";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels(){
        // On some android version we are required to use notification channels in ordder
        // to display notification.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel quotes_channel = new NotificationChannel(CHANNEL_ID,
                    "Quote Channel",
                    NotificationManager.IMPORTANCE_HIGH);
            quotes_channel.setDescription("This is the quotes channel");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(quotes_channel);
        }
    }
}
