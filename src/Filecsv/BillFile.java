package Filecsv;

import model.bill.Bill;
import model.employee.Employee;
import model.employee.EmployeeFullTime;
import model.product.Product;
import service.ManageBill;
import service.ManageProduct;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillFile implements WriteReadFile<Bill> {
    @Override
    public void writeToFile(String path, List<Bill> list) throws IOException {

        FileWriter fw = new FileWriter(path);
        BufferedWriter bf = new BufferedWriter(fw);
        String str = "Ngày nhập hóa đơn,mã hóa đơn,tên kh,sdt kh,mã SP,Tên sp,số lượng,tổng giá\n";
        for (Bill e : list) {
            str += e.getDate() + "," + e.getId() + "," + e.getNameCustomer() + "," + e.getNumberPhoneCus() + ",";
            for (int i = 0; i < e.getProducts().size() - 1; i++) {
                str += e.getProducts().get(i).getMaSp() + "/";
            }
            str += e.getProducts().get(e.getProducts().size() - 1).getMaSp();
            str += ",";
            for (int i = 0; i < e.getProducts().size() - 1; i++) {
                str += e.getProducts().get(i).getName() + "/";
            }
            str += e.getProducts().get(e.getProducts().size() - 1).getName();
            str += ",";
            for (int i = 0; i < e.getQuantity().size() - 1; i++) {
                str += e.getQuantity().get(i) + "/";
            }
            str += e.getQuantity().get(e.getQuantity().size() - 1);
            str += "," + e.getTotal() + "\n";
        }
        bf.write(str);
        bf.close();
        fw.close();
    }

    @Override
    public List<Bill> readFromFile(String path) throws IOException {

        List<Bill> billList = new ArrayList<>();
        ManageProduct manageProduct = new ManageProduct();
        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);
        String line = bf.readLine();
        while ((line = bf.readLine()) != null) {
            String[] value = line.split(",");
            String[] date = value[0].split("-");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            String[] product1 = value[4].split("/");
            List<Product> productList = new ArrayList<>();
            List<Integer> integerList = new ArrayList<>();

            for (int i = 0; i < product1.length; i++) {
                Product product = manageProduct.searchById(product1[i]);
                productList.add(product);
            }
            String[] quantity = value[6].split("/");
            for (int i = 0; i < quantity.length; i++) {
                Integer integer = Integer.parseInt(quantity[i]);
                integerList.add(integer);
            }
            billList.add(new Bill(LocalDate.of(year, month, day), value[1], value[2], value[3], productList, integerList, Double.parseDouble(value[7])));
        }
        return billList;
    }
}

