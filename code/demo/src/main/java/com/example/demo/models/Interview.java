package com.example.demo.models;


import java.sql.Date;
import java.sql.Timestamp;

public class Interview {

    private int id;
    private String naziv_pozicije;
    private String kandidat_username;
    private String regruter_username;
    private Timestamp datum_intervjua;
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv_pozicije() {
        return naziv_pozicije;
    }

    public void setNaziv_pozicije(String naziv_pozicije) {
        this.naziv_pozicije = naziv_pozicije;
    }

    public String getUsernameKandidata() {
        return kandidat_username;
    }

    public void setUsernameKandidata(String kandidat_username) {
        this.kandidat_username = kandidat_username;
    }

    public String getUsernameRegrutera() {
        return regruter_username;
    }

    public void setUsernameRegrutera(String regruter_username) {
        this.regruter_username = regruter_username;
    }

    public Timestamp getDatum_intervjua() { return datum_intervjua; }
    public void setDatum_intervjua(Timestamp datum_intervjua) { this.datum_intervjua = datum_intervjua; }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Interview(int id, String naziv_pozicije, String kandidat_username, String regruter_username, Timestamp datum_intervjua, String link) {
        this.id = id;
        this.naziv_pozicije = naziv_pozicije;
        this.kandidat_username = kandidat_username;
        this.regruter_username = regruter_username;
        this.datum_intervjua = datum_intervjua;
        this.link = link;
    }



}
