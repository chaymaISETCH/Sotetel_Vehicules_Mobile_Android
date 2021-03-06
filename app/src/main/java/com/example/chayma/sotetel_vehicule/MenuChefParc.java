package com.example.chayma.sotetel_vehicule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuChefParc extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_chef_parc);





        Intent msgIntent = new Intent(this, ServiceNotif.class);

        //msgIntent.putExtra(ServiceNotif.URL, "http://10.0.2.2/test/i.php");

        startService(msgIntent);

        Intent msgIntent2 = new Intent(this, ServiceNotifVisite.class);

        //msgIntent.putExtra(ServiceNotifVisite.URL, "http://10.0.2.2/test/i.php");

        startService(msgIntent2);



        ImageView v1,v2,v3,v4,v5,v6,v7,v8,v9;
        v1 = (ImageView) findViewById(R.id.assuc);

        v3=(ImageView)findViewById(R.id.main);
        v4=(ImageView)findViewById(R.id.carte);

        v7=(ImageView)findViewById(R.id.visite);

        v9=(ImageView)findViewById(R.id.vehicules);

        v9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_next = new Intent(MenuChefParc.this,ListVehicule.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
//***********************************************************************

        //***********************************************************
        v7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_next = new Intent(MenuChefParc.this,ListVisite.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
        //**************************************************
//************************************
        //******************************************************
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_next = new Intent(MenuChefParc.this,ListCarte.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
//***************************************************************
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_next = new Intent(MenuChefParc.this,ListMaintenance.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
//**********************************************************

//*************************************************************
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_next = new Intent(MenuChefParc.this,ListAssurance.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
//***********************************************************************


    }
}
