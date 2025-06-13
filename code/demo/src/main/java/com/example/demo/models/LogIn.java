package com.example.demo.models;

import java.sql.Date;


public class LogIn {
    private String username;
    private String lozinka;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }


    public LogIn(String username, String lozinka) {
       this.username = username;
       this.lozinka = lozinka;
    }



}
