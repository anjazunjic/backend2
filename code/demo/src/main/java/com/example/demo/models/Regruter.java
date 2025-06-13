package com.example.demo.models;

import java.sql.Date;


public class Regruter {

    private int id;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private String lozinka;
    private String username;
    private int firma_id;

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



    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdFirme() {
        return firma_id;
    }

    public void setIdFirme(int firma_id) {
        this.firma_id = firma_id;
    }


    public Regruter(int id, String ime, String prezime, String email, String telefon, String lozinka, String username, int firma_id) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email=email;
        this.telefon = telefon;
        this.lozinka = lozinka;
        this.username = username;
        this.firma_id = firma_id;
    }



}
