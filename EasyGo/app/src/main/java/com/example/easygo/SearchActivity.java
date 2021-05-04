package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    TextView Home;
    ImageView ivCarRec;
    Button btnLogout;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ivCarRec = findViewById(R.id.imageView5);
        Home = findViewById(R.id.textView3);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(SearchActivity.this, HomeActivity.class);
                startActivity(intToMain);
            }
        });

        ivCarRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(SearchActivity.this, CarRecActivity.class);
                startActivity(intToMain);
            }
        });

        btnLogout = findViewById(R.id.logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                .getInstance().signOut();
                Intent intToMain = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intToMain);
            }
        });
    }
}