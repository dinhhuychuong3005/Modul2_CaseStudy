package model.account;

import Validate.Validate;
import service.ManageAccount;

import java.util.Scanner;

public class InOutPutAccount {
    public static Account input(){
        ManageAccount manageAccount = new ManageAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào username có độ tài từ 6 đến 12 ký tự, không có khoảng trắng và không dấu");
        String username;
        do {
            username = scanner.nextLine();
            if ((!Validate.valid(username,Validate.USERNAME_REGEX)) || (manageAccount.checkUserName(username) != -1)){
                System.out.println("Username sai định dạng hoặc đã tồn tại, xin vui lòng nhập lại!");
            }
        }while ((!Validate.valid(username,Validate.USERNAME_REGEX)) || (manageAccount.checkUserName(username) != -1));
        System.out.println("Nhập vào password");
        System.out.println(" ! (có ít nhất 1 kí tự @#$%! , 1 số,1 chữ cái thường, 1 chữ cái hoa)");
        String password;
        do {
            password = scanner.nextLine();
            if (!Validate.valid(password,Validate.PASSWORD_REGEX)){
                System.out.println("password sai định dạng, xin vui lòng nhập lại!");
            }
        }while (!Validate.valid(password,Validate.PASSWORD_REGEX));
        System.out.println("Nhập vào email của bạn theo định dang ten.ho@gmail.com");
        String email;
        do {
            email = scanner.nextLine();
            if (!Validate.valid(email,Validate.EMAIL_REGEX)){
                System.out.println("Email sai định dạng mời nhập lại!");
            }
        }while (!Validate.valid(email,Validate.EMAIL_REGEX));
        return new Account(username,password,email);
    }
}
