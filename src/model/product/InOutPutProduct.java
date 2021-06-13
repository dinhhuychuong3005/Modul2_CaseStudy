package model.product;

import Validate.Validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InOutPutProduct {
    public static final Scanner scanner = new Scanner(System.in);

    public static Product inputProduct() {
        Product product = new Product();
        Date date1 = null;
        Date date2 = null;
        System.out.println("Nhập tên sản phẩm");
        String name = scanner.nextLine();
        product.setName(name);
        System.out.println("Nhập số lượng sản phẩm");
        int quantity = scanner.nextInt();
        product.setQuantity(quantity);
        scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double price = scanner.nextDouble();
        product.setPrice(price);
        scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nhập ngày sản xuất theo định dạng dd/mm/yyyy, dd-mm-yyyy hoặc dd.mm.yyyy");
        String nsx = null;

        do {
            nsx = scanner.nextLine();
            try {
                date1 = simpleDateFormat.parse(nsx);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (!Validate.valid(nsx, Validate.DATE_REGEX)) {
                System.out.println("Sai định dạng mời nhập lại");
            }
        } while (!Validate.valid(nsx, Validate.DATE_REGEX));


        product.setNsx(nsx);
        System.out.println(date1);
        System.out.println("Nhập Hạn sử dụng theo định dạng dd/mm/yyyy, dd-mm-yyyy hoặc dd.mm.yyyy");
        String hsd = null;
        do {
            hsd = scanner.nextLine();
            try {
                date2 = simpleDateFormat.parse(hsd);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(date2);
            if ((!Validate.valid(hsd, Validate.DATE_REGEX)) || (date2.getTime() < date1.getTime())) {
                System.out.println("Sai định dạng hoặc hsd nhỏ hơn nsx mời nhập lại");
            }
        } while ((!Validate.valid(hsd, Validate.DATE_REGEX)) || (date2.getTime() < date1.getTime()));
        product.setHsd(hsd);
        return product;
    }
    public static void outPutProduct(List<Product> arr){
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).toStringEXP());
        }
    }
    public static void outPut(List<Product> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).toString());
        }
    }

}
