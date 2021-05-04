package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RegisterActivity extends AppCompatActivity {
    EditText emailId, password, fullname, phoNo;
    Button btnSignUp;
    TextView tvSignIn;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBar = findViewById(R.id.progressBar);

        fullname = findViewById(R.id.editTextFullname);
        phoNo = findViewById(R.id.editTextPhone);
        emailId = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignUp = findViewById(R.id.button2);
        tvSignIn = findViewById(R.id.textView);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                String name = fullname.getText().toString();
                String number = phoNo.getText().toString();

                if(email.isEmpty()){
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (name.isEmpty()) {
                    fullname.setError("Please enter your name");
                    fullname.requestFocus();
                } else if (number.isEmpty()) {
                    phoNo.setError("Please enter your phone number");
                    phoNo.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty() && name.isEmpty() && number.isEmpty()){
                    Toast.makeText(RegisterActivity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                    password.setError("Please enter your password");
                    password.requestFocus();
                    fullname.setError("Please enter your name");
                    fullname.requestFocus();
                    phoNo.setError("Please enter your phone number");
                    phoNo.requestFocus();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty() && name.isEmpty() && number.isEmpty())){
                    progressBar.setVisibility(View.VISIBLE);
                    .createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}

