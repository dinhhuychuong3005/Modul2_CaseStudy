package Employee;

import java.io.Serializable;

public class EmployeeFullTime extends Employee implements Serializable {
    private String typeEmployee = "FullTime";
    private final long salaryBonus = 1000000;
    private long actualSalary;

    public EmployeeFullTime(String id, String name, int age, String email, String numberPhone, long salary, String status) {
        super(id, name, age, email, numberPhone, salary, status);
    }

    public EmployeeFullTime(long actualSalary) {
        this.actualSalary = actualSalary;
    }

    public EmployeeFullTime() {
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


    public String toString1() {
        return super.toString() +
                ", typeEmployee='" + typeEmployee + '\'' +
                ", salaryBonus=" + salaryBonus +
                ", actualSalary=" + calculateSalary() ;
    }
}
