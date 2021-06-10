package Filecsv;

import Employee.Employee;
import Product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFile {
    public static void writeToFile(String path, List<Product> list) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bf = new BufferedWriter(fw);
        String str = "maSp,name,số lượng,price,nsx,hsd,brand,số ngày còn lại\n";
        for (Product e : list) {
            str += e.getMaSp() + "," + e.getName() + "," + e.getQuantity() + "," + e.getPrice() + "," +
                    e.getNsx() + "," + e.getHsd() + "," + e.getBrand() + "," + e.getSoNgayConLai();
        }
        bf.write(str);
        bf.close();
        fw.close();
    }
    public static List<Product> readFromFile(String path) throws IOException {
        List<Product> list = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while ((line = br.readLine()) != null){
            String [] value = line.split(",");
            list.add(new Product(value[0],value[1],Integer.parseInt(value[2]),Double.parseDouble(value[3]),value[4],value[5],value[6],Long.parseLong(value[7])));
        }
        return list;
    }
}
