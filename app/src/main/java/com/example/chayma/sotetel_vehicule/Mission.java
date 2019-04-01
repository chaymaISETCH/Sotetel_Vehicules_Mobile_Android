package com.example.chayma.sotetel_vehicule;
public class Mission {

    private int num;
    private String des;
    private String date_deb;
    private int duree;
    private int code;

    public Mission(int num, String des, String date_deb, int duree, int code) {
        this.num = num;
        this.des = des;
        this.date_deb = date_deb;
        this.duree = duree;
        this.code = code;
    }


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

    public String getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(String date_deb) {
        this.date_deb = date_deb;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


public Mission(){}


}
