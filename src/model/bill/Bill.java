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
    private List<Product> products;
    private List<Integer> quantity;
    private double total;

    public Bill() {
    }

    public Bill(LocalDate date,String id, String nameCustomer, String numberPhoneCus, List<Product> products, List<Integer> quantity, double total) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.numberPhoneCus = numberPhoneCus;
        this.products = new ArrayList<>();
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
        for (int i = 0; i < this.products.size(); i++) {
            total += (this.products.get(i).getPrice() * this.quantity.get(i));
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String str = "Bill: | " + "Ngày nhập hóa đơn: " + date + " | " + "mã bill: " + id + " | " +
        "tên KH: " + nameCustomer + " | "  + " number phone: " + numberPhoneCus + " | " + "mã sản phẩm: ";
        for (Product product : this.products) {
            str += product.getMaSp() + "/";
        }
        str += " | " + "Tên sản phẩm: ";
        for (Product p: this.products) {
            str += p.getName() + "/";
        }
        str += " | " + "số lượng: ";
        for (Integer i : this.quantity) {
            str += i  + "/";
        }
        str +=   " | " + "tổng giá: " + getTotal();
        return str;
    }
}
