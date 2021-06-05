package Employee;

import Manage.Manage;
import Validate.Validate;

import java.util.*;

public class ManageEmployee {
    Scanner scanner = new Scanner(System.in);
    private List<Employee> list = new ArrayList<>();
    InOutEmployee inOutEmployee = new InOutEmployee();

    public ManageEmployee() {
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
    }

    public void display(List<Employee> employee) {
        inOutEmployee.outPut(employee);
    }

    public void printListFullTime() {
        System.out.println("Danh sách các nhân viên làm full time là:");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof EmployeeFullTime) {
                EmployeeFullTime employeePartTime = (EmployeeFullTime) list.get(i);
                System.out.println(employeePartTime.toString1());
            }
        }
    }

    public void printListPartTime() {
        System.out.println("Danh sách các nhân viên làm part time là:");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof EmployeePartTime) {
                EmployeePartTime employeePartTime = (EmployeePartTime) list.get(i);
                System.out.println(employeePartTime.toString2());
            }
        }
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
        } else {
            Employee employee = inOutEmployee.inputPartTime();
            employee.setId(id);
            list.set(checkById(id), employee);
        }
    }

    public void editStatus() {
        System.out.println("Nhập vào mã nhân viên cần sửa");
        String id = scanner.nextLine();
        if (checkById(id) == -1) {
            System.out.println("Không tồn tại mã nhân viên này");
        } else if (checkById(id) != -1 && list.get(checkById(id)) instanceof EmployeeFullTime) {
            Employee employee = inOutEmployee.inputFullTime();
            employee.setId(id);
            list.set(checkById(id), employee);
        } else {
            Employee employee = inOutEmployee.inputPartTime();
            employee.setId(id);
            employee.setStatus("Đã nghỉ");
            list.set(checkById(id), employee);
        }
    }


    public void deleteById() {
        System.out.println("Nhập vào mã nhân viên cần xóa");
        String id = scanner.nextLine();
        if (checkById(id) == -1) {
            System.out.println("Không tồn tại mã nhân viên này");
        } else {
            list.remove(checkById(id));
            System.out.println("Danh sách nhân viên sau khi xóa:");
            display(list);
        }
    }

    public void changeStatus() {
        boolean check = false;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus().equals("Đã nghỉ")) {
                check = true;
                index = i;
            }
        }
        if (check == true) {
            list.remove(index);
            System.out.println("Dánh sách nhân viên sau khi xóa các nhân viên đã nghỉ là:");
            display(list);
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
    }

    public void sortBySalary() {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        });
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

    public void searchBySalary() {
        List<Employee> employees = new ArrayList<>();
        boolean check = false;
        System.out.println("Nhập vào mức lương cơ bản cần tìm");
        System.out.println("Khoảng từ bao nhiêu?");
        Long minSalary = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Đến bao nhiêu?");
        Long maxSalary = scanner.nextLong();
        scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (minSalary <= list.get(i).getSalary() && list.get(i).getSalary() <= maxSalary) {
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Không có dữ liệu bạn cần tìm");
        } else {
            System.out.println("Thông tin nhân viên cần tìm là:");
            display(employees);
        }
    }
}
