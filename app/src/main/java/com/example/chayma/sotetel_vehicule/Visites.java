package com.example.chayma.sotetel_vehicule;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;




import java.util.List;

public class Visites extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static String matricule;
    ListView list;
    List<Visite> mliste;
    Button ht, alim;
    Button bt1;
    VisiteAdapter a;
    Intent shareIntent;

    public static Visite vehicule = new Visite();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            //**********************************************
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Visites.this);
            String f = preferences.getString("fonction", "");
//String f = obj.getString("fonction");
            if(f.equalsIgnoreCase("Chef Projet")) {
                Intent intent_next = new Intent(Visites.this, MenuChefProjet.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
            else   if(f.equalsIgnoreCase("Chef Parc")) {
                Intent intent_next = new Intent(Visites.this, MenuChefParc.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
            else   if(f.equalsIgnoreCase("responsable RH")) {
                Intent intent_next = new Intent(Visites.this, MenuRH.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
            else   if(f.equalsIgnoreCase("Directeur")) {
                Intent intent_next = new Intent(Visites.this, MenuDirecteur.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }









            //************************************************
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_visites);

        List<Visite> mliste;

        Visite v = new Visite();


        mliste = ListVisite.liste;

        ArrayAdapter<Visite> a = new ArrayAdapter<Visite>(this, android.R.layout.simple_list_item_1, mliste);
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(a);
        a = new VisiteAdapter(this, mliste);
        lv.setAdapter(a);
        LayoutAnimationController controller
                = AnimationUtils.loadLayoutAnimation(
                this, R.anim.list_layout_controller);
        lv.setLayoutAnimation(controller);
        lv.setOnItemClickListener(this);


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

    }


    //*********************************************************************

    //******************************************************
    public void all(View v) {
    }


}

/*}
String text = "Look at my awesome picture";
Uri pictureUri = Uri.parse("file://my_picture");
Intent shareIntent = new Intent();
shareIntent.setAction(Intent.ACTION_SEND);
shareIntent.putExtra(Intent.EXTRA_TEXT, text);
shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
shareIntent.setType("image/*");
shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
startActivity(Intent.createChooser(shareIntent, "Share images..."));
 */
