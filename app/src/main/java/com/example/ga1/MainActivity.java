package com.example.ga1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText email, password;
        Button b1, b2;

        email = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        password = findViewById(R.id.editTextTextPassword);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        Bundle bund = getIntent().getExtras();
        if(bund!=null) {
            String emal = bund.getString("Email");
            String pswd = bund.getString("Password");

            email.setText(emal);
            password.setText(pswd);
        }
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String emailToText = email.getText().toString();
                String passwordInput = password.getText().toString();
                final Pattern PASSWORD_PATTERN =
                        Pattern.compile("^" +

                                ".{8,}" +
                                "$");


                if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
                    if (PASSWORD_PATTERN.matcher(passwordInput).matches()) {
                        Toast.makeText(getApplicationContext(), "You have been Logged in Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Passwords should be min 8 characters", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Enter valid Email address !", Toast.LENGTH_SHORT).show();
                }
            }


        });





        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });



    }
}

