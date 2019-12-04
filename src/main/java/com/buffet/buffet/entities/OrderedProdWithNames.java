package com.buffet.buffet.entities;

public class OrderedProdWithNames {

    private String buffetName;
    private String productName;
    private int productQuantity;
    private int price;
    private String orderDate;
    private String orderTime;

    public OrderedProdWithNames() {
    }

    public OrderedProdWithNames(String buffetName, String productName, int productQuantity, int price, String orderDate, String orderTime) {
        this.buffetName = buffetName;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.price = price;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public String getBuffetName() {
        return buffetName;
    }

    public void setBuffetName(String buffetName) {
        this.buffetName = buffetName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        return "OrderedProdWithNames{" +
                "buffetName='" + buffetName + '\'' +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", price='" + price + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                '}';
    }
}
