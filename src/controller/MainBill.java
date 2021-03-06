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
    public static void mainBill() {
        BillFile billFile = new BillFile();
        ManageBill manageBill = new ManageBill();
        Scanner scanner = new Scanner(System.in);
        boolean isMenu = true;
        while (isMenu) {
            System.out.println("             Nhập lựa chọn của bạn         ");
            System.out.println("| 1.Thêm hóa đơn                                    |");
            System.out.println("| 2.Hiển thị tất cả hóa đơn                         |");
            System.out.println("| 3.Tìm kiếm hóa đơn theo tên khách hàng            |");
            System.out.println("| 4.Tìm kiếm hóa đơn theo số điện thoại khách hàng  |");
            System.out.println("| 5.Tính tổng doanh thu theo tháng:                 |");
            System.out.println("| 0.Thoát chương trình");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    Bill bill;
                    bill = InOutPutBill.input();
                    System.out.println("Nhập vào mã hóa đơn");
                    String maHd;
                    do {
                        maHd = scanner.nextLine();
                        if (manageBill.checkId(maHd) != -1){
                            System.out.println("Mã hóa đơn đã tồn tại, mời nhập mã khác");
                        }
                    }while (manageBill.checkId(maHd) != -1);
                    bill.setId(maHd);
                    manageBill.add(bill);
                    System.out.println("Đã thêm thành công");
                    break;
                }
                case 2: {
                    try {
                        billFile.readFromFile("bill.csv");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    manageBill.display(manageBill.getList());
                    break;
                }
                case 3: {
                    List<Bill> bill = new ArrayList<>();
                    bill = manageBill.searchByName();
                    System.out.println("Hóa đơn cần tìm là");
                    InOutPutBill.output(bill);
                    break;
                }
                case 4: {
                    manageBill.searchByNumberPhone();
                    break;
                }
                case 0: {
                    isMenu = false;
                    break;
                }
                case 5:{
                    manageBill.totalByMonth();
                    break;
                }
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
    }
}
