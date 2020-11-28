package com.example.hw3;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class QuoteIntentService extends IntentService {

    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_QUOTE = "com.example.hw3.action.quote";

    private static int arrLoc = 0;
    private static String[] quotes = {"Hi there", "Hello"};
    // TODO: Rename parameters
    //private static final String EXTRA_PARAM1 = "com.example.hw3.extra.PARAM1";
    //private static final String EXTRA_PARAM2 = "com.example.hw3.extra.PARAM2";

    public QuoteIntentService() {
        super("QuoteIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionQuote(Context context, String param1, String param2) {
        Intent intent = new Intent(context, QuoteIntentService.class);
        intent.setAction(ACTION_QUOTE);
        //intent.putExtra(EXTRA_PARAM1, param1);
        //intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_QUOTE.equals(action)) {
                //final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                //final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionQuote();
            }
        }
    }

    private void handleActionQuote(){

        arrLoc = (arrLoc + 1) % quotes.length;
    }
    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    /**
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }*/

}