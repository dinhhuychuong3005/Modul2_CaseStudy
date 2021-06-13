package model.employee;

import java.io.Serializable;

public class EmployeePartTime extends Employee implements Serializable {
    private String typeEmployee = "Part time";
    private final long salaryBonus = 500000;
    private long actualSalary;
    private long hour;

    public EmployeePartTime(String id, String name, String gender, int age, String email, String numberPhone, long salary, String status, String typeEmployee, long actualSalary) {
        super(id, name, gender, age, email, numberPhone, salary, status);
        this.typeEmployee = typeEmployee;
        this.actualSalary = actualSalary;
    }

    public EmployeePartTime(String typeEmployee, long actualSalary) {
        this.typeEmployee = typeEmployee;
        this.actualSalary = actualSalary;
    }

    public long getHour() {
        return hour;
    }

    public void setHour(long hour) {
        this.hour = hour;
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

    @Override
    public long calculateSalary() {
        this.actualSalary =  salaryBonus + (30 * hour * 1000);
        return this.actualSalary;
    }

    public String toString2() {
        return super.toString() +
                ", typeEmployee='" + typeEmployee + " | " ;
    }
    public String toString4() {
        return "Employee: " + " | " + ", Id="  + getId() + " | " +
                ", name=" + getName() + " | " +
                ", typeEmployee='" + typeEmployee + " | "  +
                "actualSalary"  + calculateSalary();
    }

}
