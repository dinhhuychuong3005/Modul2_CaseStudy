package model.bill;

import Filecsv.ProductFile;
import Validate.Validate;
import model.product.Product;
import service.ManageBill;
import service.ManageProduct;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InOutPutBill {

    static final Scanner scanner = new Scanner(System.in);
    public static Bill input(){
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
            if (!Validate.valid(numberPhoneCus,Validate.PHONE_REGEX)){
                System.out.println("Mời nhập lại");
            }
        }while (!Validate.valid(numberPhoneCus,Validate.PHONE_REGEX));
        bill.setNumberPhoneCus(numberPhoneCus);
        System.out.println("Nhập vào mã sản phẩm ");
        String id ;
        do {
            id = scanner.nextLine();
            if (manageProduct.searchID(id) == -1){
                System.out.println("Không tồn tại mã sản phẩm này");
            }else {
                bill.setProduct(manageProduct.getProductList().get(manageProduct.searchID(id)));
            }
        }while (manageProduct.searchID(id) == -1);
        System.out.println("Nhập vào số lượng sản phẩm");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        bill.setQuantity(quantity);
        int a = (manageProduct.getProductList().get(manageProduct.searchID(id)).getQuantity() - quantity);
        manageProduct.getProductList().get(manageProduct.searchID(id)).setQuantity(a);
        try {
            productFile.writeToFile("Product.csv",manageProduct.getProductList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDate date = LocalDate.now();
        bill.setDate(date);
        return bill;
    }
    public static void output(List<Bill> arr){
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
