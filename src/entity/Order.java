package entity;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    Customer customer;
    Date date;
    int quantity;
    Double price;
    Double totalPrice;
    Product product;

    public Order(Customer customer, Date date, int quantity, Double totalPrice, Product product) {
        this.customer = customer;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    public Order(Customer customer, Product product, int quantity, Double totalPrice) {
        this.customer = customer;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    public Order(Customer customer, Product product, int quantity,double price, Double totalPrice) {
        this.customer = customer;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    public Order(){

    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.totalPrice = price;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public Double getPrice() {
        return price;
    }
}

