package Employee;

import Validate.Validate;

import java.util.Scanner;

public class InOutEmployee {
    private final static Scanner scanner = new Scanner(System.in);

     static void input() {
        System.out.println("Nhập mã nhân viên:");
        String id;
        do {
            id = scanner.nextLine();
            if (!Validate.valid(id,Validate.ID_REGEX)){
                System.out.println("Sai định dạng or id trùng!Mời nhập lại id");
            }
        }while (!Validate.valid(id,Validate.ID_REGEX));
        System.out.println("Nhập vào tên nhân viên:");
        String name;
         do {
             name = scanner.nextLine();
             if ((!Validate.valid(name,Validate.NAME_REGEX)) || name == null){
                 System.out.println("Sai định dạng!Mời nhập lại");
             }
         }while ((!Validate.valid(name,Validate.NAME_REGEX)) || name == null);
         System.out.println("Nhập vào tuổi của nhân viên:");
         System.out.println("Nhân viên không vượt quá 50 tuổi");
         int age;
         do {
             age = scanner.nextInt();
             if (age<0||age>=50){
                 System.out.println("Mời nhập lại đúng tuổi của nhân viên");
             }
         }while (age<0||age>=50);
         scanner.nextLine();
         System.out.println("Nhập vào email của nhân viên theo định dạng tên.họ@gmail.com");
         String email;
         do {
             email = scanner.nextLine();
             if (!Validate.valid(email,Validate.EMAIL_REGEX)){
                 System.out.println("Sai định dạng!Mời nhập lại email");
             }
         }while (!Validate.valid(email,Validate.EMAIL_REGEX));
         System.out.println("Nhập vào số điện thoại của nhân viên theo định dạng 0xxxxxxxxx(có 9 số x sau số 0");
         String numberPhone;
         do {
             numberPhone = scanner.nextLine();
             if (!Validate.valid(numberPhone,Validate.PHONE_REGEX)){
                 System.out.println("Sai định dạng!Mời nhập lại số điện thoại");
             }
         }while (!Validate.valid(numberPhone,Validate.PHONE_REGEX));
    }
}
