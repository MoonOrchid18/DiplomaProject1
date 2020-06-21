package com.example.cityguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class sign_up_activity extends AppCompatActivity implements View.OnClickListener
{

    private EditText EmailUser, PasswordUser;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_activity);

      init();


        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.signbtn).setOnClickListener(this);
        findViewById(R.id.signinswitch).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null)
        {
            Toast.makeText(this, "User not null", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "User null", Toast.LENGTH_SHORT).show();
        }
    }

    private void init()
    {
        EmailUser = findViewById(R.id.EmailUser);
        PasswordUser = findViewById(R.id.PasswordUser);
        mAuth = FirebaseAuth.getInstance();
    }

    private void signup()
    {
        if(!TextUtils.isEmpty(EmailUser.getText().toString()) && !TextUtils.isEmpty(PasswordUser.getText().toString()))
        {
            mAuth.createUserWithEmailAndPassword(EmailUser.getText().toString(),PasswordUser.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Intent intent = new Intent(sign_up_activity.this, successlogin.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "User SignIn failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signinswitch:
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.signbtn:
                signup();
                break;



        }
    }
}