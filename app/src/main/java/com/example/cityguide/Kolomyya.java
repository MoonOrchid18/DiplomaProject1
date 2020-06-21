package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kolomyya extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolomyya);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.kolomyya:
                startActivity(new Intent(this, kolomyya_places.class));
                break;
        }

    }
}