package Product;

public class Product {
    private String maSp;
    private String name;
    private String quantity;
    private double price;
    private String nsx;
    private String hsd;
    private String brand;
    private String soNgayConLai;

    public Product() {
    }

    public Product(String maSp, String name, String quantity, double price, String nsx, String hsd, String brand, String soNgayConLai) {
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
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

    public String getSoNgayConLai() {
        return soNgayConLai;
    }

    public void setSoNgayConLai(String soNgayConLai) {
        this.soNgayConLai = soNgayConLai;
    }

    public String toStringAll(){
        return "Thông tin: | " + "Mã: " + String.format("%-8s|",maSp) + " Tên : " + String.format("%-16s|",name) + " Số lượng: " + String.format("%-6s|",quantity) + " Đơn giá: " + String.format("%-12s|",price) + " Nguồn gốc: " + String.format("%-12s|",brand) + " Ngày sản xuất: " + String.format("%-11s|",nsx) + " Hạn sử dụng: " + String.format("%-11s|",hsd);
    }

    public String toStringEXP(){
        return "Thông tin: | " + "Mã: " + String.format("%-8s|",maSp) + " Tên: " + String.format("%-14s|",name) + " Ngày sản xuất: " + String.format("%-11s|",nsx) + " Hạn sử dụng: " + String.format("%-11s|",hsd) + " Còn lại: " + String.format("%-5s",soNgayConLai) + " ngày " + " |";
    }

    @Override
    public String toString() {
        return "Thông tin: | " + "Mã: " + String.format("%-8s|",maSp) + " Tên : " + String.format("%-16s|",name) + " Số lượng: " + String.format("%-6s|",quantity) + " Đơn giá: " + String.format("%-12s|",price) + " Nguồn gốc: " + String.format("%-12s|",brand);
    }

    public String toStringCSV(){
        return maSp+","+name+","+quantity+","+price+","+nsx+","+hsd+","+brand+","+soNgayConLai+"\n";
    }
}