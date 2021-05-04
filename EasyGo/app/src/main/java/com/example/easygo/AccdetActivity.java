package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AccdetActivity extends AppCompatActivity {
    TextView Home;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accdet);
        Home = findViewById(R.id.textView3);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(AccdetActivity.this, HomeActivity.class);
                startActivity(intToMain);
            }
        });

    }
}