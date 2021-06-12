package model.product;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product implements Serializable {
    private String maSp;
    private String name;
    private int quantity;
    private double price;
    private String nsx;
    private String hsd;
    private String brand;
    private long soNgayConLai;

    public Product() {
    }

    public Product(String maSp, String name, int quantity, double price, String nsx, String hsd, String brand, long soNgayConLai) {
        this.maSp = maSp;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.nsx = nsx;
        this.hsd = hsd;
        this.brand = brand;
        this.soNgayConLai = soNgayConLai;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String getHsd() {
        return hsd;
    }

    public void setHsd(String hsd) {
        this.hsd = hsd;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getSoNgayConLai() {
        Date date1 = new Date();
        Date date2 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date2 = simpleDateFormat.parse(getHsd());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long value = date2.getTime() - date1.getTime();
        this.soNgayConLai = (value / (24 * 60 * 60 * 1000));
        return soNgayConLai;
    }

    public void setSoNgayConLai(long soNgayConLai) {
        this.soNgayConLai = soNgayConLai;
    }

    public String toStringAll(){
        return "Thông tin: | " + "Mã: " + String.format("%-8s|",maSp) + " Tên : " + String.format("%-16s|",name) + " Số lượng: " + String.format("%-6s|",quantity) + " Đơn giá: " + String.format("%-12s|",price) + " Hãng sản xuất: " + String.format("%-12s|",brand) + " Ngày sản xuất: " + String.format("%-11s|",nsx) + " Hạn sử dụng: " + String.format("%-11s|",hsd);
    }

    public String toStringEXP(){
        return "Thông tin: | " + "Mã: " + String.format("%-8s|",maSp) + " Tên: " + String.format("%-14s|",name) + " Ngày sản xuất: " + String.format("%-11s|",nsx) + " Hạn sử dụng: " + String.format("%-11s|",hsd) + " Còn lại: " + String.format("%-5s",getSoNgayConLai()) + " ngày " + " |";
    }

    @Override
    public String toString() {
        return "Thông tin: | " + "Mã: " + String.format("%-8s|",maSp) + " Tên : " + String.format("%-16s|",name) + " Số lượng: " + String.format("%-6s|",quantity) + " Đơn giá: " + String.format("%-12s|",price) + " Hãng sản xuất: " + String.format("%-12s|",brand);
    }

    public String toStringCSV(){
        return maSp+","+name+","+quantity+","+price+","+nsx+","+hsd+","+brand+","+soNgayConLai+"\n";
    }
}