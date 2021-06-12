package Filecsv;

import model.bill.Bill;
import model.employee.Employee;
import model.employee.EmployeeFullTime;
import model.product.Product;
import service.ManageBill;
import service.ManageProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BillFile {
    public static void writeToFile(String path, List<Bill> list) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bf = new BufferedWriter(fw);
        String str = "MãHóaĐơn,Tenkhachhang,sốđiệnthoại,tênsp,sốlượng,tổngtiền\n";
        for (Bill e : list) {
            str += e.getId() + "," + e.getNameCustomer() + "," + e.getNumberPhoneCus() + "," + e.getProduct().getMaSp() +
                    "," + e.getProduct().getName() + "," + e.getQuantity() + "," + e.getTotal() + "\n";
        }
        bf.write(str);
        bf.close();
        fw.close();
    }

    public static List<Bill> readFromFile(String path) throws IOException, ClassNotFoundException {
        List<Bill> billList = new ArrayList<>();
        ManageProduct manageProduct = new ManageProduct();
        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);
        String line = bf.readLine();
        while ((line = bf.readLine()) != null) {
            String[] value = line.split(",");
            Product product1 = manageProduct.searchById(value[3]);
            billList.add(new Bill(value[0], value[1], value[2], product1, Integer.parseInt(value[5]), Double.parseDouble(value[6])));
        }
        return billList;
    }
}
