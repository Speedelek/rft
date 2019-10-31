package com.buffet.buffet.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductEntity  {

    @Id
    private int id;
    private String name;
    private int price;
    private int quantity;

    private ProductEntity(){}

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
