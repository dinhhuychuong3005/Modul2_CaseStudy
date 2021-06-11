package controller;

import Filecsv.BillFile;
import model.bill.Bill;
import model.bill.InOutPutBill;
import service.ManageBill;
import service.ManageProduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBill {
    public static void main(String[] args) {
        ManageBill manageBill = new ManageBill();
        ManageProduct manageProduct = new ManageProduct();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập lựa chọn của bạn");
            System.out.println("1.Thêm hóa đơn");
            System.out.println("2.Hiển thị tất cả hóa đơn");
            System.out.println("3.Tìm kiếm hóa đơn theo tên khách hàng");
            System.out.println("4.Tìm kiếm hóa đơn theo số điện thoại khách hàng");
            System.out.println("0.Thoát chương trình");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:{
                    Bill bill = new Bill();
                    bill = InOutPutBill.input();
                    System.out.println("Nhập vào mã hóa đơn");
                    String maSp = scanner.nextLine();
                    bill.setId(maSp);
                    manageBill.add(bill);

                    break;
                }
                case 2:{
                    try {
                        BillFile.readFromFile("bill.csv");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    manageBill.display(manageBill.getList());
                    break;
                }
                case 3:{
                    List<Bill> bill = new ArrayList<>();
                    System.out.println("Nhập vào tên khách hàng cần tìm");
                    String name = scanner.nextLine();
                    bill =  manageBill.searchByName(name);
                    System.out.println("Hóa đơn cần tìm là");
                    InOutPutBill.output(bill);
                    break;
                }
                case 4:{
                    manageBill.searchByNumberPhone();
                    break;
                }
                case 0:{
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
    }
}
