package com.example.chayma.sotetel_vehicule;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;

import java.util.List;

public class VehiculeAdapter extends ArrayAdapter<Vehicule> {
    Animation scaleUp;

    public VehiculeAdapter(Context c,List<Vehicule> p){

        super(c,0,p);


    }
    @Override
    public View getView(int position,View recup,ViewGroup parent)
    {
        VehiculeView vueItem =(VehiculeView) recup;
        if(vueItem == null)
            vueItem = VehiculeView.create(parent);

        vueItem.display(super.getItem(position));
        return vueItem;


    }


}