package com.loginScreen.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private final String TAG = RegisterActivity.this.getLocalClassName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();

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
                    signUp(email.getText().toString(),password.getText().toString());
                }
            }
        });
    }


    private void signUp(String email,String password){
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                    }
                });
    }
    private void updateUI(FirebaseUser firebaseUser){
        if(firebaseUser != null){
            Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
