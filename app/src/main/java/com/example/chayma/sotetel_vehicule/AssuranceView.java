package com.example.chayma.sotetel_vehicule;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AssuranceView extends LinearLayout {

    private TextView tvmat, tvnum,tvdate1,tvdate2,tvcom,tvtype,jours;

    public AssuranceView(Context c, AttributeSet attrs) {
        super(c, attrs);

    }


    public static AssuranceView create(ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        AssuranceView itemView = (AssuranceView) li.inflate(R.layout.assurance_item, parent, false);
        itemView.findViews();
        return itemView;

    }

    private void findViews() {
        tvmat = (TextView) findViewById(R.id.item_mat);
        tvnum = (TextView) findViewById(R.id.item_num);
        tvtype = (TextView) findViewById(R.id.type);
        tvdate1 = (TextView) findViewById(R.id.item_date_deb);
        tvdate2 = (TextView) findViewById(R.id.item_date_fin);
        tvcom=(TextView) findViewById(R.id.item_com);
jours = (TextView) findViewById(R.id.jours);

    }

    public void display(final Assurance p) throws ParseException {
        tvmat.setText("Matricule : "+p.getMat());
        tvnum.setText("N° de Contrat : " + p.getNum());
        tvdate1.setText("Date Début : "+p.getDate_deb());
        tvdate2.setText("Date Fin : "+p.getDate_fin());
        tvcom.setText("Compagnie d'assurance : "+p.getLib());
tvtype.setText("Type : "+p.getType());

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        Date currentTime = Calendar.getInstance().getTime();
        String formatted = format1.format(currentTime.getTime());
        Date result =  format1.parse(p.getDate_fin());
        long ms1 = result.getTime();
        long ms2 = currentTime.getTime();
        long  diff = ms1 - ms2;


        //Find number of days by dividing the mili seconds
        int diffInDays = (int) (diff / (24 * 60 * 60 * 1000));

        // private TextView tvmat, tvnum,tvdate,tvduree,tvobs;
        if(diffInDays<=7 && diffInDays>=0){
  jours.setText(diffInDays+" jours restant");
}
    else if(diffInDays<0){
            jours.setText("expiré");


        }
        else
        {
            jours.setText("");

        }
    }}