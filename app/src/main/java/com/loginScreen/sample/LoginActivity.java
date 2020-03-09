package com.loginScreen.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FloatingActionButton backButton = findViewById(R.id.loginBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        TextView Register = findViewById(R.id.LoginToRegisterLink);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.password);
        TextView submit = findViewById(R.id.login);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(LoginActivity.this,"Enter Valid Email",Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(LoginActivity.this,"Enter Valid Password",Toast.LENGTH_SHORT).show();
                }
                else if(password.getText().toString().length()<6){
                    Toast.makeText(LoginActivity.this,"Password length has to be more than 6",Toast.LENGTH_SHORT).show();
                }
                else{
                    //login code
                }
            }
        });
    }
}
