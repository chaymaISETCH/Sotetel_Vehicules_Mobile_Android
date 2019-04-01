package com.example.chayma.sotetel_vehicule;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;

import java.text.ParseException;
import java.util.List;

public class AssuranceAdapter extends ArrayAdapter<Assurance> {
    Animation scaleUp;

    public AssuranceAdapter(Context c,List<Assurance> p){

        super(c,0,p);


    }
    @Override
    public View getView(int position,View recup,ViewGroup parent)
    {
        AssuranceView vueItem =(AssuranceView) recup;
        if(vueItem == null)
            vueItem = AssuranceView.create(parent);

        try {
            vueItem.display(super.getItem(position));
        } catch (ParseException e) {

        }
        return vueItem;


    }


}
