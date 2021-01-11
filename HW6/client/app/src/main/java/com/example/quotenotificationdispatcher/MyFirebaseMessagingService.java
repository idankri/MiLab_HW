package com.example.quotenotificationdispatcher;

import android.util.Log;

import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String SERVER_ADDRESS = "http://10.0.2.2:8080/newtoken/";
    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onNewToken(@NonNull String s) {
        // this is the new implementation of 'onTokenRefresh' (which is deprecated)
        super.onNewToken(s);
        sendRegistrationToServer(s);
    }

    /**
     * Registers the token to the server
     * @param token
     */
    private void sendRegistrationToServer(String token){
        JSONObject reqObject = new JSONObject();
        try{
            reqObject.put("token", token);
        }
        catch(JSONException e){return;}

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, SERVER_ADDRESS,
                reqObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "Token saved successfully");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Failed to save token - " + error);
                    }
                });
        // add request to the request queue
        RequestQueueSingleton.getInstance(this).getRequestQueue().add(req);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {

            // should generate appropriate notification now

        }
    }
}
