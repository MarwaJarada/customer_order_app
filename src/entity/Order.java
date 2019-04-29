package entity;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    Customer customer;
    Date date;
    int quantity;
    Double price;
    ArrayList<Product> products=new ArrayList<>();

    public Order(Customer customer, Date date, int quantity, Double price, ArrayList<Product> products) {
        this.customer = customer;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.products = products;
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
        this.price = price;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
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

    public Double getPrice() {
        return price;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}

