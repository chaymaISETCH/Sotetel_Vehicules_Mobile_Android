package com.example.chayma.sotetel_vehicule;

public class Assurance {
    //{"num":"1","type":"tous risques","date_deb":"2016-01-03","date_fin":"2018-05-01","matricule":"tunis1998","num_com":"1","lib":"Assurance STAR","adresse":"Tunis"},
    private int num;
    private String type;
    private String date_deb;
    private String date_fin;
private String mat;
    private int num_com;
    private String lib;
    private String adresse;
public Assurance(){}
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(String date_deb) {
        this.date_deb = date_deb;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public int getNum_com() {
        return num_com;
    }

    public void setNum_com(int num_com) {
        this.num_com = num_com;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}