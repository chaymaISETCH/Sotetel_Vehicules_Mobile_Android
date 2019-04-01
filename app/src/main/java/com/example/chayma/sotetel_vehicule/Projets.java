package com.example.chayma.sotetel_vehicule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;



public class Projets extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static String matricule;
    ListView list;
    List<Projet> mliste;
    Button ht,alim;
    Button bt1;
    Intent shareIntent ;
    ImageView image;

    public static Projet projet = new Projet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projets);

        ArrayList<Projet> mliste;

        mliste = ListProjet.liste;

        ArrayAdapter<Projet> a = new ArrayAdapter<Projet>(this,android.R.layout.simple_list_item_1,mliste);
        ListView lv =(ListView) findViewById(R.id.list);
        lv.setAdapter(a);
        a = new ProjetAdapter(this, mliste);
        lv.setAdapter(a);
        LayoutAnimationController controller
                = AnimationUtils.loadLayoutAnimation(
                this, R.anim.list_layout_controller);
        lv.setLayoutAnimation(controller);
        lv.setOnItemClickListener(this);

        registerForContextMenu(lv);

/*

        ht = (Button) findViewById(R.id.ht);
        ht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Produit> l = new ArrayList<Produit>();

                for(int i=0;i<ListAct.listePro.size();i++)
                {
                    if(ListAct.listePro.get(i).getIdcateg()==2)
                        l.add(ListAct.listePro.get(i));
                }

                a = new ProduitAdapter(Produits.this, l);

                ListView lv = (ListView) findViewById(R.id.list);

                lv.setAdapter(a);

            }
        });

  alim = (Button) findViewById(R.id.alim);
        alim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Produit> l = new ArrayList<Produit>();

                for(int i=0;i<ListAct.listePro.size();i++)
                {
                    if(ListAct.listePro.get(i).getIdcateg()==1)
                        l.add(ListAct.listePro.get(i));
                }

                a = new ProduitAdapter(Produits.this, l);

                ListView lv = (ListView) findViewById(R.id.list);

                lv.setAdapter(a);

            }
        });

*/

    }





    //*****************************************************************


    public void onItemClick(AdapterView<?> l, View v, int position, long id) {

        projet = ListProjet.liste.get(position);
        Intent i = new Intent( Projets.this, ListMission.class);
        i.putExtra("code",projet.getCode());
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);

    }


    //*********************************************************************

    //******************************************************
    public void all(View v){}






    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        //index
        int i= item.getItemId();

        Toast.makeText(Projets.this, "index : "+i, Toast.LENGTH_LONG).show();
        if(i==0)
        {
            Intent intent = new Intent(Projets.this,MainActivity.class) ;
            startActivity(intent);
            finish();
        }else if(i==1){

        }else if(i==2)
        {

        }
        else{

        }
        return true;
    }

}


