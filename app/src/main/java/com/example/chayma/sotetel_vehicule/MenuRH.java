package com.example.chayma.sotetel_vehicule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuRH extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rh);









        ImageView v1,v2,v3,v4,v5,v6,v7,v8,v9;
        v2=(ImageView) findViewById(R.id.employe);
//**********************************************************
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_next = new Intent(MenuRH.this,ListEmploye.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });

//*************************************************************

//***********************************************************************


    }
}
