package com.example.chayma.sotetel_vehicule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CarteInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte_info);
Carte e = Cartes.carte;
        Toast.makeText(CarteInfo.this,e.getNum(), Toast.LENGTH_LONG).show();

    }
}
