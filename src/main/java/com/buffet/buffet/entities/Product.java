package com.buffet.buffet.entities;

import javax.persistence.*;

@Entity
@Table(name = "termek")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "termek_id")
    private long id;

    @Column(name = "nev")
    private String name;

    @Column(name = "ar")
    private int ar;

    @Column(name = "kategoria")
    private int kategoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getKategoria() {
        return kategoria;
    }

    public void setKategoria(int kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ar=" + ar +
                ", kategoria=" + kategoria +
                '}';
    }
}
