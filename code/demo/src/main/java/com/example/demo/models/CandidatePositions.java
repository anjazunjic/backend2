package com.example.demo.models;

import java.sql.Date;


public class CandidatePositions {

    private String username;
    private String ime;
    private String prezime;
    private String naziv_pozicije;
    private String naziv_firme;
    private String lokacija;
    private String status_prijave;
    private Date datum_prijave;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIme() {return ime;}

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getStatus_prijave() {
        return status_prijave;
    }

    public void setStatus_prijave(String status_prijave) {
        this.status_prijave = status_prijave;
    }

    public Date getDatum_prijave() {
        return datum_prijave;
    }

    public void setDatum_prijave(Date datum_prijave) {
        this.datum_prijave = datum_prijave;
    }


    public CandidatePositions(String username, String ime, String prezime, String naziv_pozicije, String naziv_firme, String lokacija , String status_prijave, Date datum_prijave) {
        this.username = username;
        this.ime = ime;
        this.prezime = prezime;
        this.naziv_pozicije = naziv_pozicije;
        this.naziv_firme = naziv_firme;
        this.lokacija = lokacija;
        this.status_prijave = status_prijave;
        this.datum_prijave = datum_prijave;
    }



}
