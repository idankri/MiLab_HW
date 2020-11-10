package com.example.milab_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button starks_button = (Button)findViewById(R.id.strarks_button);
        Button lannisters_button = (Button)findViewById(R.id.lanisters_button);

        starks_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "Hello!!!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}