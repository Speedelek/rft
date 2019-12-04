package com.buffet.buffet.entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "ordered_products")
public class OrderedProductsEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "bufe_id")
    private int buffet_id;

    @Column(name = "termek_id")
    private int product_id;

    @Column(name = "db")
    private int quantity;

    @Column(name = "hatarido")
    private int takeoverTime;

    @Column(name = "rendeles_datum")
    private String orderDate;

    @Column(name = "rendeles_ido")
    private String orderTime;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "OrderedProductsEntity{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", buffet_id=" + buffet_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", takeoverTime=" + takeoverTime +
                ", orderDate=" + orderDate +
                ", orderTime=" + orderTime +
                ", username=" + username +
                '}';
    }
}
