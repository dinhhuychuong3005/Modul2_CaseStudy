package service;

import Filecsv.BillFile;
import model.bill.Bill;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ManageBill {
    BillFile billFile = new BillFile();
    private List<Bill> list = new ArrayList<>();

    public ManageBill(List<Bill> list) {
        this.list = list;
    }

    public List<Bill> getList() {
        return list;
    }

    public void setList(List<Bill> list) {
        this.list = list;
    }

    public ManageBill() {
        try {
            this.list = billFile.readFromFile("bill.csv");
        } catch (IOException e) {
            this.list = new ArrayList<>();
        }
    }

    public void display(List<Bill> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public int checkId(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public void add(Bill bill) {
        list.add(bill);
        try {
            billFile.writeToFile("bill.csv", this.list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Bill> searchByName() {
        Scanner scanner = new Scanner(System.in);
        List<Bill> list1 = new ArrayList<>();
        System.out.println("Nhập vào tên khách hàng cần tìm");
        String name = scanner.nextLine();
        for (Bill b : list) {
            if (b.getNameCustomer().equals(name)) {
                list1.add(b);
            }
        }
        return list1;
    }

    public void searchByNumberPhone() {
        boolean check = false;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số điện thoại khách hàng cần tìm");
        String numberPhone = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumberPhoneCus().equals(numberPhone)) {
                index = i;
                check = true;
            }
        }
        if (check == true) {
            System.out.println(list.get(index));
        } else {
            System.out.println("Số điện thoại không tồn tại");
        }
    }
    public void totalByMonth(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tháng cần tính doanh số");
        int month;
        do {
            month = scanner.nextInt();
            if (month<=0 || month >12){
                System.out.println("Mời nhập lại");
            }
        }while (month<=0 || month >12);
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            if (month == list.get(i).getDate().getMonthValue()){
                total += list.get(i).getTotal();
            }
        }
        System.out.println("Doanh thu của tháng " + month + " là: " + total);
    }
}
