package com.id.ac.ukdw.a2pay;

import java.io.Serializable;

public class Index implements Serializable{
    private String username;
    private String noHp;

    public Index(){}

    public Index(String username, String noHp) {
        this.username = username;
        this.noHp = noHp;
    }

    public String getUsername() {
        return username;
    }

    public String getNoHp() {
        return noHp;
    }
}
