package com.example.chayma.sotetel_vehicule;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MissionView extends LinearLayout {

    private TextView tvmat, tvnum,tvdate,tvtype;

    public MissionView(Context c, AttributeSet attrs) {
        super(c, attrs);

    }


    public static MissionView create(ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        MissionView itemView = (MissionView) li.inflate(R.layout.missions_item, parent, false);
        itemView.findViews();
        return itemView;

    }

    private void findViews() {
        tvmat = (TextView) findViewById(R.id.item_mat);
        tvnum = (TextView) findViewById(R.id.item_num);
        tvtype = (TextView) findViewById(R.id.type);
        tvdate = (TextView) findViewById(R.id.item_date);


    }

    public void display(final Mission p) {
        tvmat.setText("Des: "+p.getDes());
        tvnum.setText("N° " + p.getNum());
        tvdate.setText("Date : "+p.getDate_deb());
        tvtype.setText("Durée : "+p.getDuree());
        // private TextView tvmat, tvnum,tvdate,tvduree,tvobs;



    }

}
