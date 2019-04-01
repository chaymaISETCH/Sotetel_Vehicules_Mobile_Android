package com.example.chayma.sotetel_vehicule;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MaintenanceView extends LinearLayout {

    private TextView tvmat, tvnum,tvdate,tvtype;

    public MaintenanceView(Context c, AttributeSet attrs) {
        super(c, attrs);

    }


    public static MaintenanceView create(ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        MaintenanceView itemView = (MaintenanceView) li.inflate(R.layout.maintenances_item, parent, false);
        itemView.findViews();
        return itemView;

    }

    private void findViews() {
        tvmat = (TextView) findViewById(R.id.item_mat);
        tvnum = (TextView) findViewById(R.id.item_num);
        tvtype = (TextView) findViewById(R.id.type);
        tvdate = (TextView) findViewById(R.id.item_date);


    }

    public void display(final Maintenance p) {
        tvmat.setText("Matricule : "+p.getMat());
        tvnum.setText("N° " + p.getNum());
        tvdate.setText("Date : "+p.getDate());
        tvtype.setText("Type : "+p.getType());
        // private TextView tvmat, tvnum,tvdate,tvduree,tvobs;



    }

}