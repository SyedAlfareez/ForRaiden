package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddCarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editTextDate, editTextNumber;
    Button btnMyvi, btnAlza, btnWira, btnsubmit;
    ImageView Car;
    TextView Home;
    Spinner spinnerTransmission;

    DatabaseReference databaseCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        databaseCars = FirebaseDatabase.getInstance().getReference("car");

        btnMyvi = findViewById(R.id.buttonMyvi);
        btnAlza = findViewById(R.id.buttonAlza);
        btnWira = findViewById(R.id.buttonWira);
        editTextDate = findViewById(R.id.editTextDate);
        editTextNumber = findViewById(R.id.editTextNumber);
        btnsubmit = findViewById(R.id.button8);
        Car = findViewById(R.id.imageView2);
        Home = findViewById(R.id.textView3);
        spinnerTransmission = (Spinner) findViewById(R.id.spinner);


        btnMyvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car.setImageResource(R.drawable.myvi);
            }
        });

        btnAlza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car.setImageResource(R.drawable.sewaalza);
            }
        });

        btnWira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car.setImageResource(R.drawable.wira);
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(AddCarActivity.this, HomeActivity.class);
                startActivity(intToMain);
            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCar();

            }
        });


    }

    private void addCar(){
        String date = editTextDate.getText().toString().trim();
        String transmission = spinnerTransmission.getSelectedItem().toString();
        String rentprice = editTextNumber.getText().toString().trim();

        if(TextUtils.isEmpty(date)){
            editTextDate.setError("Please enter date");
            editTextDate.requestFocus();

        }else if(TextUtils.isEmpty(rentprice)){
            editTextNumber.setError("Please enter price");
            editTextNumber.requestFocus();
        } else if(TextUtils.isEmpty(date) && TextUtils.isEmpty(rentprice)) {
            editTextDate.setError("Please enter date");
            editTextDate.requestFocus();
            editTextNumber.setError("Please enter price");
            editTextNumber.requestFocus();
        }
        else{
            String id = databaseCars.push().getKey();
            Car car = new Car(id, date, transmission, rentprice);

            databaseCars.child(id).setValue(car);
            Intent intToCarDet = new Intent(AddCarActivity.this, CarDetActivity.class);
            startActivity(intToCarDet);
            Toast.makeText(this, "Car added", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}