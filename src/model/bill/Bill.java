package model.bill;

import model.product.Product;

import java.io.Serializable;

public class Bill implements Serializable {
    private String id;
    private String nameCustomer;
    private String numberPhoneCus;
    private Product product;
    private int quantity;
    private double total;

    public Bill() {
    }

    public Bill(String id, String nameCustomer, String numberPhoneCus, Product product, int quantity, double total) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.numberPhoneCus = numberPhoneCus;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getNumberPhoneCus() {
        return numberPhoneCus;
    }

    public void setNumberPhoneCus(String numberPhoneCus) {
        this.numberPhoneCus = numberPhoneCus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return this.quantity * product.getPrice();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Bill: | " + "mã bill: " + id + " | " +
        "tên KH: " + nameCustomer + " | "  + " number phone: " + numberPhoneCus + " | " +
                "tên sản phẩm: " + product.getName() +  " | " + "mã sản phẩm: " + product.getMaSp() + " | " +
                "số lượng: " + quantity +  " | " + "tổng giá: " + getTotal();
    }
}
