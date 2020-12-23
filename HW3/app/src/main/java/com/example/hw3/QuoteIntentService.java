package com.example.hw3;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.example.hw3.App.CHANNEL_ID;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class QuoteIntentService extends IntentService {
    private static final String ACTION_QUOTE = "com.example.hw3.action.quote";

    public QuoteIntentService() {
        super("QuoteIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionQuote(Context context) {
        Intent intent = new Intent(context, QuoteIntentService.class);
        intent.setAction(ACTION_QUOTE);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_QUOTE.equals(action)) {
                handleActionQuote();
            }
        }
    }

    private void handleActionQuote(){
        startAlarm(this);
    }

    /**
     * Start an alarm that spawns quote notifications
     * @param context - context for the alarm
     */
    private void startAlarm(Context context){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 1, intent, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
                5*60*1000, alarmIntent);
    }

}