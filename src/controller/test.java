package controller;

import model.employee.EmployeeFullTime;
import model.employee.EmployeePartTime;
import Filecsv.EmployeeFile;
import service.ManageEmployee;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        ManageEmployee manageEmployee = new ManageEmployee();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("================Menu===============");
            System.out.println("Mời bạn nhập lựa chọn");
            System.out.println("1.Hiển thị danh sách nhân viên.");
            System.out.println("2.Thêm nhân viên");
            System.out.println("3.Cập nhật trạng thái nhân viên");
            System.out.println("4.Sửa thông tin nhân viên theo mã nhân viên");
            System.out.println("5.Xóa nhân viên theo trạng thái");
            System.out.println("6.Xóa nhân viên theo mã nhân viên");
            System.out.println("7.Sắp xếp nhân viên theo tên và theo tuổi");
            System.out.println("8.Tìm kiếm nhân viên theo mã nhân viên");
            System.out.println("9.Tìm kiếm nhân viên theo tên");
            System.out.println("10.Tính lương theo mã nhân viên");
            System.out.println("0.Exit");
            boolean isMenu = true;
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1: {

                    while (isMenu){
                        System.out.println("1.Hiển thị tất cả nhân viên");
                        System.out.println("2.Hiển thị nhân viên fulltime");
                        System.out.println("3.Hiển thị tất cả parttime");
                        System.out.println("0.Quay lại menu chính");
                        int line = s.nextInt();

                        switch (line) {
                            case 1: {
                                manageEmployee.display(manageEmployee.getList());
                                break;
                            }
                            case 2: {
                                System.out.println("Danh sách nhân viên full time");
                                List<EmployeeFullTime> employeeFullTimes = manageEmployee.printListFullTime();
                                if (employeeFullTimes != null) {
                                    for (EmployeeFullTime e : manageEmployee.printListFullTime()) {
                                        System.out.println(e.toString1());
                                    }
                                } else {
                                    System.out.println("Không có nhân viên full time");
                                }
                                break;
                            }
                            case 3: {
                                System.out.println("Danh sách nhân viên part time");
                                List<EmployeePartTime> employeePartTime = manageEmployee.printListPartTime();
                                if (employeePartTime != null) {
                                    for (EmployeePartTime e : manageEmployee.printListPartTime()) {
                                        System.out.println(e.toString2());
                                    }
                                } else {
                                    System.out.println("Không có nhân viên part time");
                                }
                                break;
                            }
                            case 0:
                                isMenu = false;
                                break;
                            default:
                                System.out.println("Mời nhập lại");
                                break;
                        }
                    } break;
                }
                case 2: {
                    while (isMenu){
                        System.out.println("1.Thêm nhân viên fulltime");
                        System.out.println("2.Thêm nhân viên parttime");
                        System.out.println("0.Quay lại menu chính");
                        int a = s.nextInt();
                        s.nextLine();
                        switch (a) {
                            case 1: {
                                manageEmployee.addEmployFullTime();
                                System.out.println("Dánh sách nhân viên sau khi thêm");
                                manageEmployee.display(manageEmployee.getList());
                                break;
                            }
                            case 2: {
                                manageEmployee.addEmployPartTime();
                                System.out.println("Dánh sách nhân viên sau khi thêm");
                                manageEmployee.display(manageEmployee.getList());
                                break;
                            }
                            case 0: {
                                isMenu = false;
                                break;
                            }
                            default:
                                System.out.println("Mời nhập lại");
                                break;
                        }
                    } break;
                }

                case 3: {
                    manageEmployee.editStatus();
                    break;
                }
                case 4: {
                    manageEmployee.editById();
                    break;
                }
                case 5:
                    manageEmployee.deleteByStatus();
                    break;
                case 6:
                    manageEmployee.deleteById();
                    break;
                case 7:
                    System.out.println("Danh sách nhân viên sau khi sắp xếp là:");
                    manageEmployee.sortByNameByAge();
                    manageEmployee.display(manageEmployee.getList());
                    try {
                        EmployeeFile.writeToFile("Employee.csv",manageEmployee.getList());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8: {
                    System.out.println("Nhập vào mã nhân viên cần tìm");
                    String id = s.nextLine();
                    if (manageEmployee.checkById(id) == -1) {
                        System.out.println("Mã nhân viên không tồn tại");
                    } else {
                        System.out.println("Thông tin nhân viên cần tìm là:");
                        if (manageEmployee.getList().get(manageEmployee.checkById(id)) instanceof EmployeeFullTime) {
                            EmployeeFullTime employeeFullTime = (EmployeeFullTime) manageEmployee.getList().get(manageEmployee.checkById(id));
                            System.out.println(employeeFullTime.toString1());
                        } else if (manageEmployee.getList().get(manageEmployee.checkById(id)) instanceof EmployeePartTime) {
                            EmployeePartTime employeePartTime = (EmployeePartTime) manageEmployee.getList().get(manageEmployee.checkById(id));
                            System.out.println(employeePartTime.toString2());
                        }
                    }
                    break;
                }
                case 9: {
                    manageEmployee.searchByName();
                    break;
                }
                case 10: {
                    System.out.println("Nhập mã nhân viên cần tính lương");
                    String id = s.nextLine();
                    if (manageEmployee.checkById(id) == -1) {
                        System.out.println("Không có nhân viên này");
                    } else {
                        System.out.println("Nhập vào số giờ làm thêm của nhân viên");
                        long hour = s.nextLong();
                        if (manageEmployee.getList().get(manageEmployee.checkById(id)) instanceof EmployeeFullTime) {
                            EmployeeFullTime employeeFullTime = (EmployeeFullTime) manageEmployee.getList().get(manageEmployee.checkById(id));
                            employeeFullTime.setHour(hour);
                            System.out.println(employeeFullTime.toString3());
                            try {
                                EmployeeFile.writeToFile("Employee.csv", manageEmployee.getList());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if (manageEmployee.getList().get(manageEmployee.checkById(id)) instanceof EmployeePartTime) {
                            EmployeePartTime employeePartTime = (EmployeePartTime) manageEmployee.getList().get(manageEmployee.checkById(id));
                            employeePartTime.setHour(hour);
                            System.out.println(employeePartTime.toString4());
                            try {
                                EmployeeFile.writeToFile("Employee.csv", manageEmployee.getList());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                }
                case 0: {
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


