package model.employee;

import Validate.Validate;

import java.util.List;
import java.util.Scanner;

public class InOutEmployee {
    Scanner scanner = new Scanner(System.in);

    public EmployeeFullTime inputFullTime() {
        EmployeeFullTime employeeFullTime = new EmployeeFullTime();
        System.out.println("Nhập vào tên nhân viên:");
        String name;
        do {
            name = scanner.nextLine();
            if ((!Validate.valid(name, Validate.NAME_REGEX)) || name == null) {
                System.out.println("Sai định dạng!Mời nhập lại");
            }
        } while ((!Validate.valid(name, Validate.NAME_REGEX)) || name == null);
        employeeFullTime.setName(name);
        System.out.println("Nhập vào giới tính nhân viên:");
        System.out.println("1.Male + \t + 2.Female");
        String gender = null;
        int line = scanner.nextInt();
        while (true) {
            switch (line) {
                case 1:
                    gender = "Male";
                    break;
                case 2:
                    gender = "Female";
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
            break;
        }
        scanner.nextLine();
        employeeFullTime.setGender(gender);
        System.out.println("Nhập vào tuổi của nhân viên:");
        System.out.println("Nhân viên không vượt quá 50 tuổi");
        int age;
        do {
            age = scanner.nextInt();
            if (age < 0 || age >= 50) {
                System.out.println("Mời nhập lại đúng tuổi của nhân viên");
            }
        } while (age < 0 || age >= 50);
        employeeFullTime.setAge(age);
        scanner.nextLine();
        System.out.println("Nhập vào email của nhân viên theo định dạng tên.họ@gmail.com");
        String email;
        do {
            email = scanner.nextLine();
            if (!Validate.valid(email, Validate.EMAIL_REGEX)) {
                System.out.println("Sai định dạng!Mời nhập lại email");
            }
        } while (!Validate.valid(email, Validate.EMAIL_REGEX));
        employeeFullTime.setEmail(email);
        System.out.println("Nhập vào số điện thoại của nhân viên theo định dạng 0xxxxxxxxx(có 9 số x sau số 0");
        String numberPhone;
        do {
            numberPhone = scanner.nextLine();
            if (!Validate.valid(numberPhone, Validate.PHONE_REGEX)) {
                System.out.println("Sai định dạng!Mời nhập lại số điện thoại");
            }
        } while (!Validate.valid(numberPhone, Validate.PHONE_REGEX));
        employeeFullTime.setNumberPhone(numberPhone);
        String status = "Đang làm";

        employeeFullTime.setStatus(status);
        return employeeFullTime;
    }

    public EmployeePartTime inputPartTime() {
        EmployeePartTime employeePartTime = new EmployeePartTime();

        System.out.println("Nhập vào tên nhân viên:");
        String name;
        do {
            name = scanner.nextLine();
            if ((!Validate.valid(name, Validate.NAME_REGEX)) || name == null) {
                System.out.println("Sai định dạng!Mời nhập lại");
            }
        } while ((!Validate.valid(name, Validate.NAME_REGEX)) || name == null);
        employeePartTime.setName(name);
        System.out.println("Nhập vào giới tính nhân viên:");
        System.out.println("1.Male  \t  2.Female");
        String gender = null;
        int line = scanner.nextInt();
        while (true) {
            switch (line) {
                case 1:
                    gender = "Male";
                    break;
                case 2:
                    gender = "Female";
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
            break;
        }
        scanner.nextLine();
        employeePartTime.setGender(gender);
        System.out.println("Nhập vào tuổi của nhân viên:");
        System.out.println("Nhân viên không vượt quá 50 tuổi");
        int age;

        do {
            age = scanner.nextInt();
            if (age < 0 || age >= 50) {
                System.out.println("Mời nhập lại đúng tuổi của nhân viên");
            }
        } while (age < 0 || age >= 50);
        employeePartTime.setAge(age);
        scanner.nextLine();
        System.out.println("Nhập vào email của nhân viên theo định dạng tên.họ@gmail.com");
        String email;
        do {
            email = scanner.nextLine();
            if (!Validate.valid(email, Validate.EMAIL_REGEX)) {
                System.out.println("Sai định dạng!Mời nhập lại email");
            }
        } while (!Validate.valid(email, Validate.EMAIL_REGEX));
        employeePartTime.setEmail(email);
        System.out.println("Nhập vào số điện thoại của nhân viên theo định dạng 0xxxxxxxxx(có 9 số x sau số 0");
        String numberPhone;
        do {
            numberPhone = scanner.nextLine();
            if (!Validate.valid(numberPhone, Validate.PHONE_REGEX)) {
                System.out.println("Sai định dạng!Mời nhập lại số điện thoại");
            }
        } while (!Validate.valid(numberPhone, Validate.PHONE_REGEX));
        employeePartTime.setNumberPhone(numberPhone);
        String status = "Đang làm";
        employeePartTime.setStatus(status);
        return employeePartTime;
    }

    public void outPut(List<Employee> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) instanceof EmployeeFullTime) {
                EmployeeFullTime employeePartTime = (EmployeeFullTime) arr.get(i);
                System.out.println(employeePartTime.toString1());
            } else if (arr.get(i) instanceof EmployeePartTime) {
                EmployeePartTime employeePartTime = (EmployeePartTime) arr.get(i);
                System.out.println(employeePartTime.toString2());
            } else
                System.out.println("danh sách trống");
        }
    }
}
