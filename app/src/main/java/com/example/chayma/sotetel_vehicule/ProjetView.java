package com.example.chayma.sotetel_vehicule;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ProjetView extends LinearLayout {

    private TextView tvmat, tvnum,tvdate,tvtype;
    private ImageView image;

    public ProjetView(Context c, AttributeSet attrs) {
        super(c, attrs);

    }



    public static ProjetView create(ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        ProjetView itemView = (ProjetView) li.inflate(R.layout.projets_item, parent, false);
        itemView.findViews();
        return itemView;




    }

    private void findViews() {
        tvmat = (TextView) findViewById(R.id.item_mat);
        tvnum = (TextView) findViewById(R.id.item_num);
        tvtype = (TextView) findViewById(R.id.type);
        tvdate = (TextView) findViewById(R.id.item_date);
        image=(ImageView) findViewById(R.id.info);


    }

    public void display(final Projet p) {
        tvmat.setText("Libelle : "+p.getLib());
        tvnum.setText("N° " + p.getCode());
        tvdate.setText("Date : "+p.getDate_deb());
        tvtype.setText("Durée : "+p.getDuree());
        // private TextView tvmat, tvnum,tvdate,tvduree,tvobs;



    }


}
