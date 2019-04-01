package com.example.chayma.sotetel_vehicule;
public class Projet {
   private int code;
    private String lib;
    private String date_deb;
    private int duree;
    private String login_chef_de_projet;

    public Projet(){};

    public Projet(int code, String lib, String date_deb, int duree, String login_chef_de_projet) {
        this.code = code;
        this.lib = lib;
        this.date_deb = date_deb;
        this.duree = duree;
        this.login_chef_de_projet = login_chef_de_projet;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
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

    public String getLogin_chef_de_projet() {
        return login_chef_de_projet;
    }

    public void setLogin_chef_de_projet(String login_chef_de_projet) {
        this.login_chef_de_projet = login_chef_de_projet;
    }
}
