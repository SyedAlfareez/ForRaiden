package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    ImageView ivSearch, ivCarRec, ivAccdet, ivAddCar;
    Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ivAddCar = findViewById(R.id.imageView7);
        ivSearch = findViewById(R.id.imageView);
        ivCarRec = findViewById(R.id.imageView3);
        ivAccdet = findViewById(R.id.imageView4);
        btnLogout = findViewById(R.id.logout);

        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToSearch = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intToSearch);
            }
        });

        ivCarRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToCarRec = new Intent(HomeActivity.this, CarRecActivity.class);
                startActivity(intToCarRec);
            }
        });

        ivAccdet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToAccDet = new Intent(HomeActivity.this, AccdetActivity.class);
                startActivity(intToAccDet);
            }
        });

        ivAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToCarAdd = new Intent(HomeActivity.this, AddCarActivity.class);
                startActivity(intToCarAdd);
            }
        });


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intToMain);
            }
        });
    }
}