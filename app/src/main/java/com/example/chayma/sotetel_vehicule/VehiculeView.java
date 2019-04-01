package com.example.chayma.sotetel_vehicule;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VehiculeView extends LinearLayout {

    private TextView tvmat, tvgrise;
    private ImageView tvImg;

    public VehiculeView(Context c, AttributeSet attrs) {
        super(c, attrs);

    }


    public static VehiculeView create(ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        VehiculeView itemView = (VehiculeView) li.inflate(R.layout.item, parent, false);
        itemView.findViews();
        return itemView;

    }

    private void findViews() {
        tvmat = (TextView) findViewById(R.id.item_mat);
        tvgrise = (TextView) findViewById(R.id.item_grise);
        tvImg = (ImageView) findViewById(R.id.item_image);
    }

    public void display(final Vehicule p) {
        tvmat.setText("Matricule : "+p.getMatricule());
        tvgrise.setText("N° carte grise : "+p.getGrise());

        tvImg.setImageBitmap(p.getImage());


    }

}