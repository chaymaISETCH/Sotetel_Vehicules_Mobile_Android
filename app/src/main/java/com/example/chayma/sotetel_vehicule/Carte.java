package com.example.chayma.sotetel_vehicule;

public class Carte  {
    private int num;
    private Double solde;
    private String mat;
public Carte(){}
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }
}