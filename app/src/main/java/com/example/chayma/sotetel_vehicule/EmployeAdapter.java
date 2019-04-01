package com.example.chayma.sotetel_vehicule;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;

import java.util.List;

public class EmployeAdapter extends ArrayAdapter<Employe> {
    Animation scaleUp;

    public EmployeAdapter(Context c,List<Employe> p){

        super(c,0,p);


    }
    @Override
    public View getView(int position,View recup,ViewGroup parent)
    {
        EmployeView vueItem =(EmployeView) recup;
        if(vueItem == null)
            vueItem = EmployeView.create(parent);

        vueItem.display(super.getItem(position));
        return vueItem;


    }


}