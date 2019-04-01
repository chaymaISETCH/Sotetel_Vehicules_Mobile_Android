package com.example.chayma.sotetel_vehicule;

import android.graphics.Bitmap;

/**
 * Created by imen on 17/11/17.
 */

public class Vehicule {
    private String matricule;
    private String modele;
    private String marque;
    private int puissance;
    private int nb_place;
    private String carburant;
    private Bitmap image;

    private String grise;
    private String date;
    private String couleur;
    private String categorie;

    public Vehicule(String s) {
 setMatricule(s);
    }

    public Vehicule() {
    }
public String toString()
{return this.matricule;}


    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getGrise() {
        return grise;
    }

    public void setGrise(String grise) {
        this.grise = grise;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}