package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class vorokhta_places extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vorokhta_places);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.vorokhta:
                startActivity(new Intent(this, vorokhta_places.class));
                break;
        }

    }
}