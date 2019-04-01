package com.example.chayma.sotetel_vehicule;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VisiteView extends LinearLayout {

    private TextView tvmat, tvnum,tvdate,tvduree,tvobs;

    public VisiteView(Context c, AttributeSet attrs) {
        super(c, attrs);

    }


    public static VisiteView create(ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        VisiteView itemView = (VisiteView) li.inflate(R.layout.visite_item, parent, false);
        itemView.findViews();
        return itemView;

    }

    private void findViews() {
        tvmat = (TextView) findViewById(R.id.item_mat);
        tvnum = (TextView) findViewById(R.id.item_num);
        tvduree = (TextView) findViewById(R.id.item_duree);
        tvdate = (TextView) findViewById(R.id.item_date);
        tvobs = (TextView) findViewById(R.id.obs);


    }

    public void display(final Visite p) {
        tvmat.setText("Matricule : "+p.getMat());
        tvnum.setText("N° " + p.getNum());
        tvdate.setText("Date : "+p.getDate());
        tvduree.setText("Durée : "+p.getDuree()+ " Jours");
        tvobs.setText("Observation : " + p.getObs());
       // private TextView tvmat, tvnum,tvdate,tvduree,tvobs;



    }

}