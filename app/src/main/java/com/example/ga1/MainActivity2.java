package com.example.ga1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ga1.databinding.ActivityMain2Binding;

import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText fn, ln, mob, ml, psw;
        Button b1;

        fn = findViewById(R.id.editTextText3);
        ln = findViewById(R.id.editTextText4);
        mob = findViewById(R.id.editTextNumber);
        ml = findViewById(R.id.editTextText);
        psw = findViewById(R.id.editTextTextPassword2);

        b1 = findViewById(R.id.button3);








        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag = 0;

                String First_name = fn.getText().toString().trim();
                String Last_name = ln.getText().toString().trim();

                if(First_name.length() == 0){
                    Toast.makeText(getApplicationContext(), "First Name cannot be null", Toast.LENGTH_SHORT).show();
                    flag = 1;
                    return;
                }
                if(!First_name.matches("[a-zA-Z]+")){
                    Toast.makeText(getApplicationContext(), "First Name should be in characters only", Toast.LENGTH_SHORT).show();
                    flag = 1;
                    return;
                }
                if(Last_name.length()==0){
                    Toast.makeText(getApplicationContext(), "Last Name cannot be null", Toast.LENGTH_SHORT).show();
                    flag  = 1;
                    return;
                }

                if(!Last_name.matches("[a-zA-Z]+")){
                    Toast.makeText(getApplicationContext(), "Last Name should be in characters only", Toast.LENGTH_SHORT).show();
                    flag = 1;
                    return;
                }

                String mobileNumber = mob.getText().toString().trim();
                if(mobileNumber.length() != 10){
                    Toast.makeText(getApplicationContext(), "Enter valid mobile number", Toast.LENGTH_SHORT).show();
                    flag = 1;
                    return;
                }

                String mail = ml.getText().toString();
                String password = psw.getText().toString();
                final Pattern PASSWORD_PATTERN =
                        Pattern.compile("^" +

                                ".{8,}" +
                                "$");

                if (mail.isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                    Toast.makeText(getApplicationContext(), "Enter the valid email address", Toast.LENGTH_SHORT).show();
                    flag = 1;
                    return;
                }

                if(password.length() == 0){
                    Toast.makeText(getApplicationContext(), "Enter the password", Toast.LENGTH_SHORT).show();
                    flag = 1;
                    return;
                }

                if ((!PASSWORD_PATTERN.matcher(password).matches())) {
                        Toast.makeText(getApplicationContext(), "Password should have min 8 chars", Toast.LENGTH_SHORT).show();
                        flag = 1;
                    return;
                    }

                if(flag != 1) {


                    Bundle bun = new Bundle();
                    bun.putString("Email", mail);
                    bun.putString("Password", password);
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    intent.putExtras(bun);

                    startActivity(intent);
                }


            }
        });





    }
}
