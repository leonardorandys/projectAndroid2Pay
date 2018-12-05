package com.id.ac.ukdw.a2pay;

import java.io.Serializable;

public class Product implements Serializable {

    private String idProduk;
    private String deskripsi;
    private int harga;

    public Product() {}

    public Product(String nama, String deskripsi, int harga) {
        this.idProduk = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String id) { this.idProduk = id;}

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getHarga() {
        return harga;
    }
}
