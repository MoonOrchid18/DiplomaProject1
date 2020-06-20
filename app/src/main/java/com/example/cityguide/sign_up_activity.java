package com.example.cityguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class sign_up_activity extends AppCompatActivity implements View.OnClickListener
{

    EditText EmailUser, PasswordUser;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_activity);

        EmailUser = (EditText) findViewById(R.id.EmailUser);
        PasswordUser = (EditText) findViewById(R.id.PasswordUser);


        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.signbtn).setOnClickListener(this);
        findViewById(R.id.signinswitch).setOnClickListener(this);
    }

    private void registerUser() {
        String email = EmailUser.getText().toString().trim();
        String password = PasswordUser.getText().toString().trim();

        if (email.isEmpty()) {
            EmailUser.setError("Email is required");
            EmailUser.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            EmailUser.setError("Please enter a valid email");
            EmailUser.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            PasswordUser.setError("Password is required");
            PasswordUser.requestFocus();
            return;
        }

        if (password.length() < 6) {
            PasswordUser.setError("Minimum lenght of password should be 6");
            PasswordUser.requestFocus();
            return;
        }



        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(sign_up_activity.this, successlogin.class));
                } else {
                    finish();
                    startActivity(new Intent(sign_up_activity.this, error.class));

                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }


    @Override
    public void onClick(View v) {

    }
}