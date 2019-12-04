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
    private int price;

    @Column(name = "kategoria_id")
    private int categoryId;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ar=" + price +
                ", kategoriaId=" + categoryId +
                '}';
    }
}
