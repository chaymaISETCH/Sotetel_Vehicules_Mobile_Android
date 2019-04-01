package com.example.chayma.sotetel_vehicule;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;

import java.util.List;

public class MissionAdapter extends ArrayAdapter<Mission> {
        Animation scaleUp;

public MissionAdapter(Context c, List<Mission> p){

        super(c,0,p);


        }
@Override
public View getView(int position, View recup, ViewGroup parent)
        {
        MissionView vueItem =(MissionView) recup;
        if(vueItem == null)
        vueItem = MissionView.create(parent);

        vueItem.display(super.getItem(position));
        return vueItem;


        }

        }
