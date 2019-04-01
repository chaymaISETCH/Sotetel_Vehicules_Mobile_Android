package com.example.chayma.sotetel_vehicule;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;

import java.util.List;

public class MaintenanceAdapter extends ArrayAdapter<Maintenance> {
    Animation scaleUp;

    public MaintenanceAdapter(Context c,List<Maintenance> p){

        super(c,0,p);


    }
    @Override
    public View getView(int position,View recup,ViewGroup parent)
    {
        MaintenanceView vueItem =(MaintenanceView) recup;
        if(vueItem == null)
            vueItem = MaintenanceView.create(parent);

        vueItem.display(super.getItem(position));
        return vueItem;


    }


}
