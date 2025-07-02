package com.example.demo.models;

import java.sql.Date;


public class CandidateInterview {
    private String ime;
    private String prezime;
    private String username;
    private String naziv_pozicije;
    private String status_prijave;
    private Date datum_prijave;


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

    public String getUsername() {return username;}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNaziv_pozicije() {
        return naziv_pozicije;
    }

    public void setNaziv_pozicije(String naziv_pozicije) {
        this.naziv_pozicije = naziv_pozicije;
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


    public CandidateInterview(String ime, String prezime, String username,String naziv_pozicije,String status_prijave, Date datum_prijave) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.naziv_pozicije = naziv_pozicije;
        this.status_prijave = status_prijave;
        this.datum_prijave = datum_prijave;
    }



}
