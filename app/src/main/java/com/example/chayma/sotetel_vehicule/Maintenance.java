package com.example.chayma.sotetel_vehicule;

public class Maintenance{
    //"num":"1","des":"fjhfhjf","date":"2017-12-01","type":"panne","matricule":"tunis1998"
    private int num;
    private String des;
    private String date;
    private String type;
    private String mat;
    public Maintenance(){}


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }
}