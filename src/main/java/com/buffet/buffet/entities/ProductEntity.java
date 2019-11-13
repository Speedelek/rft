package com.buffet.buffet.entities;

import javax.persistence.*;

@Entity
@Table(name = "termek")
public class ProductEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "termek_id")
    private int id;
    @Column(name = "nev")
    private String name;
    @Column(name = "ar")
    private int price;
    @Column(name = "kategoria_id")
    private int category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
