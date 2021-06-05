package Employee;

import Validate.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        InOutEmployee inOutEmployee = new InOutEmployee();
        ManageEmployee manageEmployee = new ManageEmployee();
        Scanner s = new Scanner(System.in);


        while (true) {
            System.out.println("1.EmployeeFullTime");
            System.out.println("2.EmployeePartTime");
            System.out.println("3.print");
            System.out.println("4.Xóa nhân viên theo mã nhân viên");
            System.out.println("5.Sửa thông tin nhân viên theo mã nhân viên");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1: {
                    manageEmployee.addEmployFullTime();
                    break;
                }
                case 2: {
                    manageEmployee.addEmployPartTime();
                    break;
                }
                case 3: {
                    manageEmployee.display(manageEmployee.getList());
                    break;
                }
                case 4:{
                    manageEmployee.editById();
                    break;
                }
                case 5:
                    manageEmployee.deleteById();
                    break;
            }
//                default:
//                    System.out.println("nhập lại");
//                 break;
        }


//        EmployeeFullTime employee1 = (EmployeeFullTime) employee;
//        System.out.println(employee);
//        System.out.println(employee1.toString1());

    }
}

