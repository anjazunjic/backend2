package com.example.demo.models;

import java.sql.Date;


public class Position{
    private int id;
    private int firma_id;
    private String naziv_firme;
    private String naziv_pozicije;
    private String opis_posla;
    private int zahtijevano_iskustvo;
    private String potrebne_kvalifikacije;
    private String lokacija;
    private Date datum_objave;
    private Date datum_isteka;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFirme() {
        return firma_id;
    }

    public void setIdFirme(int firma_id) {
        this.firma_id = firma_id;
    }

    public String getNaziv_pozicije() {
        return naziv_pozicije;
    }

    public void setNaziv_pozicije(String naziv_pozicije) {
        this.naziv_pozicije = naziv_pozicije;
    }

    public String getNaziv_firme() {
        return naziv_firme;
    }

    public void setNaziv_firme(String naziv_firme) {
        this.naziv_firme = naziv_firme;
    }

    public String getOpis_posla() {
        return opis_posla;
    }

    public void setOpis_posla(String opis_posla) {
        this.opis_posla = opis_posla;
    }


    public int getZahtijevano_iskustvo(){
        return zahtijevano_iskustvo;
    }

    public void setZahtijevano_iskustvo(int zahtijevano_iskustvo){
        this.zahtijevano_iskustvo = zahtijevano_iskustvo;
    }

    public String getPotrebne_kvalifikacije() {
        return potrebne_kvalifikacije;
    }

    public void setPotrebne_kvalifikacije(String potrebne_kvalifikacije) {
        this.potrebne_kvalifikacije = potrebne_kvalifikacije;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }


    public Date getDatum_objave() {
        return datum_objave;
    }

    public void setDatum_objave(Date datum_objave) {
        this.datum_objave = datum_objave;
    }

    public Date getDatum_isteka() {
        return datum_isteka;
    }

    public void setDatum_isteka(Date datum_isteka) {
        this.datum_isteka = datum_isteka;
    }

    public Position(int id,int firma_id,String naziv_firme, String naziv_pozicije, String opis_posla, int zahtijevano_iskustvo, String potrebne_kvalifikacije, String lokacija,Date datum_objave, Date datum_isteka) {
        this.id = id;
        this.firma_id = firma_id;
        this.naziv_firme = naziv_firme;
        this.naziv_pozicije = naziv_pozicije;
        this.opis_posla = opis_posla;
        this.zahtijevano_iskustvo = zahtijevano_iskustvo;
        this.potrebne_kvalifikacije = potrebne_kvalifikacije;
        this.lokacija = lokacija;
        this.datum_objave = datum_objave;
        this.datum_isteka = datum_isteka;
    }



}
