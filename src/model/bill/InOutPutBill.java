package model.bill;

import Filecsv.ProductFile;
import Validate.Validate;
import model.product.Product;
import service.ManageBill;
import service.ManageProduct;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InOutPutBill {

    static final Scanner scanner = new Scanner(System.in);

    public static Bill input() {
        ProductFile productFile = new ProductFile();
        ManageProduct manageProduct = new ManageProduct();
        Bill bill = new Bill();
        System.out.println("Nhập tên khách hàng");
        String name = scanner.nextLine();
        bill.setNameCustomer(name);
        System.out.println("Nhập số điện thoại khách hàng");
        String numberPhoneCus = null;
        do {
            numberPhoneCus = scanner.nextLine();
            if (!Validate.valid(numberPhoneCus, Validate.PHONE_REGEX)) {
                System.out.println("Mời nhập lại");
            }
        } while (!Validate.valid(numberPhoneCus, Validate.PHONE_REGEX));
        bill.setNumberPhoneCus(numberPhoneCus);
        System.out.println("Nhập vào số lượng sản phẩm khách mua:");
        int size = scanner.nextInt();
        scanner.nextLine();
        List<Product> products = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập vào mã sản phẩm " + (i + 1));
            String id;
            do {
                id = scanner.nextLine();
                if (manageProduct.searchID(id) == -1) {
                    System.out.println("Không tồn tại mã sản phẩm này");
                } else {
                    products.add(manageProduct.getProductList().get(manageProduct.searchID(id)));
                }
            } while (manageProduct.searchID(id) == -1);
            System.out.println("Nhập vào số lượng của sản phẩm " + (i + 1));
            int quantity;
            do {
                quantity = scanner.nextInt();
                if (quantity > manageProduct.getProductList().get(manageProduct.searchID(id)).getQuantity()){
                    System.out.println("Số lượng sản phẩm trong kho không đủ");
                }
            }while (quantity > manageProduct.getProductList().get(manageProduct.searchID(id)).getQuantity());
            integerList.add(quantity);
            scanner.nextLine();

            int a = (manageProduct.getProductList().get(manageProduct.searchID(id)).getQuantity() - quantity);
            manageProduct.getProductList().get(manageProduct.searchID(id)).setQuantity(a);
            try {
                productFile.writeToFile("Product.csv", manageProduct.getProductList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bill.setQuantity(integerList);
        bill.setProducts(products);
        long total = 0;
        for (int i = 0; i < products.size(); i++) {
            total += (products.get(i).getPrice() * integerList.get(i));
        }
        bill.setTotal(total);
        LocalDate date = LocalDate.now();
        bill.setDate(date);
        return bill;
    }

    public static void output(List<Bill> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
