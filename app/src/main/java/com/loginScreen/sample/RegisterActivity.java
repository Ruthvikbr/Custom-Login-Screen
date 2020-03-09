package com.loginScreen.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FloatingActionButton backButton = findViewById(R.id.signUpBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final EditText email = findViewById(R.id.signEmail);
        final EditText password = findViewById(R.id.signPassword);
        final EditText phone = findViewById(R.id.signPhone);
        final EditText name = findViewById(R.id.signName);
        TextView Register = findViewById(R.id.signRegister);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if (TextUtils.isEmpty(name.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Enter Valid Name", Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(email.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Enter Valid Password", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(phone.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Enter Valid Phone", Toast.LENGTH_SHORT).show();
                } else if (phone.getText().toString().length() != 10) {
                    Toast.makeText(RegisterActivity.this, "Phone length has to be 10", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().length() < 6) {
                    Toast.makeText(RegisterActivity.this, "Password length has to be more than 6", Toast.LENGTH_SHORT).show();
                } else {
                    //Register Code
                }
            }
        });
    }
}
