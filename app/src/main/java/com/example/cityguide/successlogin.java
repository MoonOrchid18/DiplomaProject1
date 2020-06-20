package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class successlogin extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successlogin);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                startActivity(new Intent(this, choose_city_activity.class));
                break;
        }
    }}

