package com.example.chayma.sotetel_vehicule;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;

import java.util.List;

public class VisiteAdapter extends ArrayAdapter<Visite> {
    Animation scaleUp;

    public VisiteAdapter(Context c,List<Visite> p){

        super(c,0,p);


    }
    @Override
    public View getView(int position,View recup,ViewGroup parent)
    {
        VisiteView vueItem =(VisiteView) recup;
        if(vueItem == null)
            vueItem = VisiteView.create(parent);

        vueItem.display(super.getItem(position));
        return vueItem;


    }


}
