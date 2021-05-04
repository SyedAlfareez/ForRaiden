package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CarRecActivity extends AppCompatActivity {

    TextView Home;
    Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rec);
        Home = findViewById(R.id.textView3);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(CarRecActivity.this, HomeActivity.class);
                startActivity(intToMain);
            }
        });
        btnLogout = findViewById(R.id.logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                .signOut();
                Intent intToMain = new Intent(CarRecActivity.this, MainActivity.class);
                startActivity(intToMain);
            }
        });
    }
}