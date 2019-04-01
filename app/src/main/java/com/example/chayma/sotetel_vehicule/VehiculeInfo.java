package com.example.chayma.sotetel_vehicule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class VehiculeInfo extends AppCompatActivity {
Vehicule v = Vehicules.vehicule;
    TextView mat,grise,couleur,carburant,categorie,date,marque,modele,puissance;
    ImageView i1;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicule_info);

mat=(TextView) findViewById(R.id.mat);
        grise=(TextView) findViewById(R.id.grise);
        couleur=(TextView) findViewById(R.id.couleur);
        carburant=(TextView) findViewById(R.id.carburant);
        categorie=(TextView) findViewById(R.id.categorie);
        date=(TextView) findViewById(R.id.date);
        marque=(TextView) findViewById(R.id.marque);
        modele=(TextView) findViewById(R.id.modele);
        puissance=(TextView) findViewById(R.id.puissance);

        i1=(ImageView) findViewById(R.id.img);
        mat.setText("Matricule : "+v.getMatricule());
        grise.setText("N° carte grise : "+v.getGrise());
        couleur.setText("Couleur : "+v.getCouleur());
        carburant.setText("Carburant : "+v.getCarburant());
        categorie.setText("Catégorie : "+v.getCategorie());
        date.setText("Date : "+v.getDate());
        marque.setText("Marque : "+v.getMarque());
        modele.setText("Modele : "+v.getModele());
        puissance.setText("Puissance : " + v.getPuissance());

        i1.setImageBitmap(v.getImage());
    }
}


