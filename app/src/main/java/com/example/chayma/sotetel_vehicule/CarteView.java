package com.example.chayma.sotetel_vehicule;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CarteView extends LinearLayout {

    private TextView tvmat, tvnum,tvsolde;

    public CarteView(Context c, AttributeSet attrs) {
        super(c, attrs);

    }


    public static CarteView create(ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        CarteView itemView = (CarteView) li.inflate(R.layout.carte_item, parent, false);
        itemView.findViews();
        return itemView;

    }

    private void findViews() {
        tvmat = (TextView) findViewById(R.id.item_mat);
        tvnum = (TextView) findViewById(R.id.item_num);
        tvsolde = (TextView) findViewById(R.id.item_solde);



    }

    public void display(final Carte p) {
        tvmat.setText("Matricule : "+p.getMat());
        tvnum.setText("N° de Carte : " + p.getNum());
        tvsolde.setText("Solde : "+p.getSolde()+" DT");

    }
}