package com.example.chayma.sotetel_vehicule;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;

import java.util.List;

public class CarteAdapter extends ArrayAdapter<Carte> {
    Animation scaleUp;

    public CarteAdapter(Context c,List<Carte> p){

        super(c,0,p);


    }
    @Override
    public View getView(int position,View recup,ViewGroup parent)
    {
        CarteView vueItem =(CarteView) recup;
        if(vueItem == null)
            vueItem = CarteView.create(parent);

        vueItem.display(super.getItem(position));
        return vueItem;


    }


}