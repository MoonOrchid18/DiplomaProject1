package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class choose_city_activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city_activity);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.kolomyya:
                startActivity(new Intent(this, Kolomyya.class));
                break;

             case R.id.kosiv:
                startActivity(new Intent(this, Kosiv.class));
                break;

                case R.id.franyk:
                startActivity(new Intent(this, Franyk.class));
                break;

                case R.id.vorokhta:
                startActivity(new Intent(this, Vorokhta.class));
                break;

                case R.id.yaremche:
                startActivity(new Intent(this, yaremche.class));
                break;

            case R.id.bukovel:
                startActivity(new Intent(this, bukovel.class));
                break;
        }

    }
}
