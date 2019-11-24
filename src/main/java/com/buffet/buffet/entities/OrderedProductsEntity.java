package com.buffet.buffet.entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "ordered_product")
public class OrderedProductsEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "bufe_id")
    private int buffet_id;

    @Column(name = "termek_id")
    private int product_id;

    @Column(name = "db")
    private int quantity;

    @Column(name = "hatarido")
    private int takeoverTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBuffet_id() {
        return buffet_id;
    }

    public void setBuffet_id(int buffet_id) {
        this.buffet_id = buffet_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTakeoverTime() {
        return takeoverTime;
    }

    public void setTakeoverTime(int takeoverTime) {
        this.takeoverTime = takeoverTime;
    }
}
