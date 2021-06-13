package controller;

import Filecsv.AccountFile;
import model.account.Account;
import model.account.InOutPutAccount;
import service.ManageAccount;
import service.ManageBill;

import java.io.IOException;
import java.util.Scanner;

public class MainPart {
    public static void main(String[] args) {
        AccountFile accountFile = new AccountFile();
        Scanner scanner = new Scanner(System.in);
        ManageAccount manageAccount = new ManageAccount();
        boolean isMenu = true;
        while (true){
            System.out.println("==============Ứng dụng quản lý siêu thị=============");
            System.out.println("Mời nhập lựa chọn");
            System.out.println("1.Đăng nhập");
            System.out.println("2.Đăng kí tài khoản");
            System.out.println("3.Quên mật khẩu");
            System.out.println("0.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:{
                   String username;
                   String password;
                    do {
                        System.out.println("Nhập username");
                        username = scanner.nextLine();
                        System.out.println("Nhập password");
                        password = scanner.nextLine();
                        if ((manageAccount.checkUserName(username)== -1) || (manageAccount.checkPassword(password) == -1)){
                            System.out.println("Sai mật khẩu hoặc tên tài khoản, mời nhập lại!");
                        }
                    }while ((manageAccount.checkUserName(username)== -1) || (manageAccount.checkPassword(password) == -1));
                    if ((manageAccount.checkUserName(username)!= -1) && (manageAccount.checkPassword(password) != -1)){
                        while (isMenu) {
                            System.out.println("==========HELLO==============");
                            System.out.println("Mời bạn nhập lựa chọn");
                            System.out.println("1.Quản lý nhân viên");
                            System.out.println("2.Quản lý sản phẩm");
                            System.out.println("3.Quản lý Bill");
                            System.out.println("0.Đăng xuất");
                            int line = scanner.nextInt();
                            scanner.nextLine();
                            switch (line){
                                case 1:{
                                    MainEmployee.mainEmployee();
                                    break;
                                }
                                case 2:{
                                    MainProduct.mainProduct();
                                    break;
                                }
                                case 3:{
                                    MainBill.mainBill();
                                    break;
                                }
                                case 0:{
                                    isMenu = false;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
                case 2:{
                    Account account = InOutPutAccount.input();
                    manageAccount.add(account);
                    try {
                        accountFile.writeToFile("account.csv",manageAccount.getAccounts());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3:{
                    System.out.println("Nhập vào tên tài khoản cần tìm");
                    String username = scanner.nextLine();
                    System.out.println("Nhập vào email xác thực tài khoản");
                    String email = scanner.nextLine();
                    manageAccount.findPassword(username,email);
                    break;
                }
                case 0:{
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Không có chức năng bạn cần tìm. Mời nhập lại!");
                    break;
            }
        }
    }
}
