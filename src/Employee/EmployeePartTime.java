package Employee;

import java.io.Serializable;

public class EmployeePartTime extends Employee implements Serializable {
    private String typeEmployee = "Part time";
    private final long salaryBonus = 500000;
    private long actualSalary;

    public EmployeePartTime(String id, String name, String gender, int age, String email, String numberPhone, long salary, String status, String typeEmployee, long actualSalary) {
        super(id, name, gender, age, email, numberPhone, salary, status);
        this.typeEmployee = typeEmployee;
        this.actualSalary = actualSalary;
    }

    public EmployeePartTime(String typeEmployee, long actualSalary) {
        this.typeEmployee = typeEmployee;
        this.actualSalary = actualSalary;
    }


    public EmployeePartTime() {
        super();

    }


    public long getActualSalary() {
        return actualSalary;
    }

    public void setActualSalary(long actualSalary) {
        this.actualSalary = actualSalary;
    }


    public long calculateSalary(){
        this.actualSalary = super.getSalary() + salaryBonus;
        return this.actualSalary;
    }

    public String toString2() {
        return super.toString() +
                ", typeEmployee='" + typeEmployee + '\'' +
                ", salaryBonus=" + salaryBonus +
                ", actualSalary=" + calculateSalary() ;
    }
}
