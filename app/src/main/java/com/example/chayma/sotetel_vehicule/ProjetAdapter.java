package com.example.chayma.sotetel_vehicule;




import android.content.Context;
import android.view.View;
import java.util.List;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;



public class ProjetAdapter extends ArrayAdapter<Projet> {
    Animation scaleUp;

    public ProjetAdapter(Context c,List<Projet> p){

        super(c,0,p);


    }
    @Override
    public View getView(int position,View recup,ViewGroup parent)
    {
        ProjetView vueItem =(ProjetView) recup;
        if(vueItem == null)
            vueItem = ProjetView.create(parent);

        vueItem.display(super.getItem(position));
        return vueItem;


    }




}
