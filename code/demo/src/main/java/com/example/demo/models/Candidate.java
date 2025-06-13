package com.example.demo.models;

import java.sql.Date;


public class Candidate {

    private int id;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private int radno_iskustvo_godine;
    private String obrazovanje;
    private String sertifikati;
    private String jezici;
    private Date datum_registracije;
    private String status_prijave;
    private String lozinka;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {this.telefon = telefon; }

    public int getRadno_iskustvo_godine() {
        return radno_iskustvo_godine;
    }

    public void setRadno_iskustvo_godine(int radno_iskustvo_godine) { this.radno_iskustvo_godine = radno_iskustvo_godine; }

    public String getObrazovanje() {return obrazovanje;}

    public void setObrazovanje(String obrazovanje) {
        this.obrazovanje = obrazovanje;
    }

    public String getSertifikati() {
        return sertifikati;
    }

    public void setSertifikati(String sertifikati) {
        this.sertifikati = sertifikati;
    }

    public String getJezici() {
        return jezici;
    }

    public void setJezici(String jezici) {
        this.jezici = jezici;
    }

    public Date getDatum_registracije() {
        return datum_registracije;
    }

    public void setDatum_registracije(Date datum_registracije) {
        this.datum_registracije = datum_registracije;
    }

    public String getStatus_prijave() {
        return status_prijave;
    }

    public void setStatus_prijave(String status_prijave) {
        this.status_prijave = status_prijave;
    }

    public String getLozinka() { return lozinka; }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Candidate(int id,String ime,String prezime,String email, String telefon,int radno_iskustvo_godine,String obrazovanje, String sertifikati, String jezici, Date datum_registracije, String status_prijave, String lozinka,String username) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email=email;
        this.telefon = telefon;
        this.radno_iskustvo_godine = radno_iskustvo_godine;
        this.obrazovanje = obrazovanje;
        this.sertifikati = sertifikati;
        this.jezici = jezici;
        this.datum_registracije = datum_registracije;
        this.status_prijave = status_prijave;
        this.lozinka = lozinka;
        this.username = username;

    }



}
