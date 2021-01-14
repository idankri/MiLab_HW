package com.example.quotenotificationdispatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button subscribeButton = (Button)findViewById(R.id.subscribe_button);
        subscribeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText symbolText = (EditText)findViewById(R.id.editTextStockSymbol);
                String symbol = symbolText.getText().toString();
                updateSymbolInServer(symbol);
            }
        });
    }

    private void sendSymbol(String symbol, String token){
        JSONObject reqObject = new JSONObject();
        try {
            reqObject.put("token", token);
        } catch (JSONException e) {
            return;
        }
        String server_address = getResources().getString(R.string.server_address);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, server_address +
                "symbol/" + symbol,
                reqObject, response -> Log.i("updateSymbolInServer", "Symbol updated successfully"),
                error -> Log.e("updateSymbolInServer", "Failed to save symbol - " + error)
        );
        RequestQueueSingleton.getInstance(this).getRequestQueue().add(req);
    }

    private void updateSymbolInServer(String symbol){
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this,  new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String token = instanceIdResult.getToken();
                sendSymbol(symbol, token);
            }
        });
    }
}