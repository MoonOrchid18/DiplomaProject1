package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Franyk extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_franyk);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.franyk:
                startActivity(new Intent(this, franyk_places.class));
                break;
        }

    }
}