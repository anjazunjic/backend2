package com.example.demo.models;

import java.sql.Date;


public class Application {
    private int id;
    private int kandidat_id;
    private int pozicija_id;
    private String status_prijave;
    private Date datum_prijave;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKandidata() {
        return kandidat_id;
    }

    public void setIdKandidata(int kandidat_id) {
        this.kandidat_id = kandidat_id;
    }

    public int getIdPozicije() {
        return pozicija_id;
    }

    public void setIdPozicije(int pozicija_id) {
        this.pozicija_id = pozicija_id;
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

    public Application(int id, int kandidat_id, int pozicija_id,String status_prijave, Date datum_prijave) {
        this.id = id;
        this.kandidat_id = kandidat_id;
        this.pozicija_id = pozicija_id;
        this.status_prijave = status_prijave;
        this.datum_prijave = datum_prijave;
    }



}
