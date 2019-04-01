package com.example.chayma.sotetel_vehicule;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class EmployeInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
Employe e = Employes.emp;
        setContentView(R.layout.activity_employe_info);

        TextView t1 = (TextView) findViewById(R.id.nom);
        TextView t2 = (TextView) findViewById(R.id.prenom);
        TextView t4 = (TextView) findViewById(R.id.cin);
        TextView t5 = (TextView) findViewById(R.id.fonction);
        TextView t6 = (TextView) findViewById(R.id.tel);
        TextView t7 = (TextView) findViewById(R.id.email);
        TextView t8 = (TextView) findViewById(R.id.service);
        TextView t9 = (TextView) findViewById(R.id.sexe);
        TextView t10 = (TextView) findViewById(R.id.login);
        TextView t11 = (TextView) findViewById(R.id.pass);
        t1.setText(e.getNom());
        t2.setText(e.getPrenom());
        t4.setText(e.getCin());
        t5.setText(e.getFonction());
        t6.setText(e.getTel());
        t7.setText(e.getEmail());
        t8.setText(e.getService());
        t9.setText(e.getSexe());
        t10.setText(e.getLogin());
        t11.setText(e.getPass());



    }
}
