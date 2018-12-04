package com.id.ac.ukdw.a2pay;

public class User {

    private String nama;
    private String username;
    private String password;
    private String email;
    private String alamat;
    private String noHp;
    private int saldo;

    public User() {}

    public User(String nama, String username, String password, String email, String alamat, String noHp, int saldo) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.email = email;
        this.alamat = alamat;
        this.noHp = noHp;
        this.saldo = saldo;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public int getSaldo() {
        return saldo;
    }
}