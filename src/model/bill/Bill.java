package model.bill;

import model.product.Product;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill implements Serializable {
    private LocalDate date;
    private String id;
    private String nameCustomer;
    private String numberPhoneCus;
    private List<Product> products ;
    private List<Integer> quantity;
    private double total;

    public Bill() {
    }

    public Bill(LocalDate date, String id, String nameCustomer, String numberPhoneCus, List<Product> products, List<Integer> quantity, double total) {
        this.id = id;
        this.products = products;
        this.nameCustomer = nameCustomer;
        this.numberPhoneCus = numberPhoneCus;

        this.quantity = quantity;
        this.total = total;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<Integer> quantity) {
        this.quantity = quantity;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String str = "Bill: | " + "Ngày nhập hóa đơn: " + date + " | " + "mã bill: " + id + " | " +
                "tên KH: " + nameCustomer + " | " + " number phone: " + numberPhoneCus + " | " + "mã sản phẩm: ";
        for (int i = 0; i < this.products.size() - 1; i++) {
            str += this.products.get(i).getMaSp() + "/";
        }
        str += this.products.get(this.products.size() - 1).getMaSp();
        str += " | " + "Tên sản phẩm: ";
        for (int i = 0; i < this.products.size() - 1; i++) {
            str += this.products.get(i).getName() + "/";
        }
        str += this.products.get(this.products.size() - 1).getName();
        str += " | " + "số lượng: ";
        for (int i = 0; i < this.quantity.size() - 1; i++) {
            str += this.quantity.get(i) + "/";
        }
        str += this.quantity.get(this.products.size() - 1);
        str += " | " + "tổng giá: " + getTotal();
        return str;

    }
}
