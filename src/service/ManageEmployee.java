package service;

import model.employee.Employee;
import Filecsv.EmployeeFile;
import Validate.Validate;
import model.employee.EmployeeFullTime;
import model.employee.EmployeePartTime;
import model.employee.InOutEmployee;

import java.io.IOException;
import java.util.*;

public class ManageEmployee {
    Scanner scanner = new Scanner(System.in);
    private List<Employee> list = new ArrayList<>();
    InOutEmployee inOutEmployee = new InOutEmployee();

    public ManageEmployee() {
        try {
            this.list = EmployeeFile.readFromFile("Employee.csv");
        } catch (IOException e) {
            this.list = new ArrayList<>();
        }
    }

    public ManageEmployee(List<Employee> list) {
        this.list = new ArrayList<Employee>();
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }


    public void addEmployPartTime() {
        System.out.println("Nhập mã nhân viên theo đinh dạng EMPXXX:");
        String id;
        do {
            id = scanner.nextLine();
            if ((!Validate.valid(id, Validate.ID_REGEX)) || checkById(id) != -1) {
                System.out.println("Sai định dạng or id trùng!Mời nhập lại id");
            }
        } while ((!Validate.valid(id, Validate.ID_REGEX)) || checkById(id) != -1);
        Employee employee = inOutEmployee.inputPartTime();
        employee.setId(id);
        list.add(employee);
        try {
            EmployeeFile.writeToFile("Employee.csv", list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addEmployFullTime() {
        System.out.println("Nhập mã nhân viên theo đinh dạng EMPXXX:");
        String id;
        do {
            id = scanner.nextLine();
            if ((!Validate.valid(id, Validate.ID_REGEX)) || checkById(id) != -1) {
                System.out.println("Sai định dạng or id trùng!Mời nhập lại id");
            }
        } while ((!Validate.valid(id, Validate.ID_REGEX)) || checkById(id) != -1);
        Employee employee = inOutEmployee.inputFullTime();
        employee.setId(id);
        list.add(employee);
        try {
            EmployeeFile.writeToFile("Employee.csv", list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display(List<Employee> employee) {
        inOutEmployee.outPut(employee);
    }

    public List<EmployeeFullTime> printListFullTime() {
        List<EmployeeFullTime> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof EmployeeFullTime) {
                EmployeeFullTime employeeFullTime = (EmployeeFullTime) list.get(i);
                list1.add(employeeFullTime);
            }
        }
        return list1;
    }

    public List<EmployeePartTime> printListPartTime() {
        List<EmployeePartTime> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof EmployeePartTime) {
                EmployeePartTime employeePartTime = (EmployeePartTime) list.get(i);
                list2.add(employeePartTime);
            }
        }
        return list2;
    }


    public int checkById(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public void editById() {
        System.out.println("Nhập vào mã nhân viên cần sửa");
        String id = scanner.nextLine();
        if (checkById(id) == -1) {
            System.out.println("Không tồn tại mã nhân viên này");
        } else if (checkById(id) != -1 && list.get(checkById(id)) instanceof EmployeeFullTime) {
            Employee employee = inOutEmployee.inputFullTime();
            employee.setId(id);
            list.set(checkById(id), employee);
            System.out.println("Done!");
        } else {
            Employee employee = inOutEmployee.inputPartTime();
            employee.setId(id);
            list.set(checkById(id), employee);
            System.out.println("Done!");
        }
        try {
            EmployeeFile.writeToFile("Employee.csv", list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editStatus() {
        System.out.println("Nhập vào mã nhân viên cần sửa");
        String id = scanner.nextLine();
        if (checkById(id) == -1) {
            System.out.println("Không tồn tại mã nhân viên này");
        } else {
            list.get(checkById(id)).setStatus("Đã nghỉ");
            System.out.println("Đã sửa xong");
        }
    }


    public void deleteById() {
        System.out.println("Nhập vào mã nhân viên cần xóa");
        String id = scanner.nextLine();
        if (checkById(id) == -1) {
            System.out.println("Không tồn tại mã nhân viên này");
        } else {
            System.out.println("Bạn có chắc muốn xóa không?");
            System.out.println("1.Có \t 2.Không");
            int op = scanner.nextInt();
            if (op == 1) {
                list.remove(checkById(id));
                System.out.println("Danh sách nhân viên sau khi xóa:");
                display(list);
                try {
                    EmployeeFile.writeToFile("Employee.csv", list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (op == 2) {
                System.out.println("Danh sách nhân viên vẫn giữ nguyên");
            } else System.out.println();
        }
    }

    public void deleteByStatus() {
        boolean check = false;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus().equals("Đã nghỉ")) {
                check = true;
                index = i;
            }
        }
        if (check == true) {
            System.out.println("Bạn có chắc muốn xóa không?");
            System.out.println("1.Có \t 2.Không");
            int op = scanner.nextInt();
            if (op == 1) {
                list.remove(index);
                System.out.println("Dánh sách nhân viên sau khi xóa các nhân viên đã nghỉ là:");
                display(list);
                try {
                    EmployeeFile.writeToFile("Employee.csv", list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (op == 2) {
                System.out.println("Danh sách nhân viên vẫn giữ nguyên");
            } else {
                System.out.println();
            }
        } else {
            System.out.println("Không có nhân viên nào nghỉ làm");
        }
    }

    public void sortByNameByAge() {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int n = o1.getName().compareTo(o2.getName());
                if (n == 0) {
                    return o1.getAge() - o2.getAge();
                } else
                    return n;
            }
        });
        try {
            EmployeeFile.writeToFile("Employee.csv", list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchByName() {
        List<Employee> employees = new ArrayList<>();
        System.out.println("Nhập vào tên nhân viên cần tìm");
        boolean check = false;
        String name = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).getName())) {
                employees.add(list.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Không có tên nhân viên cần tìm");
        } else {
            System.out.println("Thông tin nhân viên cần tìm là:");
            display(employees);
        }
    }

    public void calculateSalary() {

    }

}
