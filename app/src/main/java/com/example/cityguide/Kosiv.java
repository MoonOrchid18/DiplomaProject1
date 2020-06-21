package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kosiv extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kosiv);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.kosiv:
                startActivity(new Intent(this, kosiv_places.class));
                break;
        }
    }
}