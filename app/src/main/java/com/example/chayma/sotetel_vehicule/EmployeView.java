package com.example.chayma.sotetel_vehicule;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

//Employe
public class EmployeView  extends LinearLayout{

        private TextView tvnom, tvprenom,tvservice;

        public EmployeView(Context c, AttributeSet attrs) {
            super(c, attrs);

        }


        public static EmployeView create(ViewGroup parent) {

            LayoutInflater li = LayoutInflater.from(parent.getContext());
            EmployeView itemView = (EmployeView) li.inflate(R.layout.employe_item, parent, false);
            itemView.findViews();
            return itemView;

        }

        private void findViews() {
            tvnom = (TextView) findViewById(R.id.nom);
            tvservice = (TextView) findViewById(R.id.service);




        }

        public void display(final Employe p) {
            tvnom.setText("Nom & Prenom: "+p.getNom()+" "+p.getPrenom());

            tvservice.setText("Service : "+p.getService());

            // private TextView tvmat, tvnum,tvdate,tvduree,tvobs;
        }
    }