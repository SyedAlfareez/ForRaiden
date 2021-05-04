package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class CarDetActivity extends AppCompatActivity {

    TextView Home;
    private RecyclerView mRecyclerView;


    DatabaseReference databaseCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_det);

        databaseCars = FirebaseDatabase.getInstance().getReference("car");
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_cars);
        Home = findViewById(R.id.textView3);

        new FirebaseDatabaseHelper().rentCars(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Car> cars, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView, CarDetActivity.this, cars,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(CarDetActivity.this, HomeActivity.class);
                startActivity(intToMain);
            }
        });
    }

}