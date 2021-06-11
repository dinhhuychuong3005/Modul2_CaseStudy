package model.employee;

import model.employee.Employee;

import java.io.Serializable;

public class EmployeeFullTime extends Employee implements Serializable {
    private String typeEmployee = "FullTime";
    private final long salaryBonus = 1000000;
    private final long salary = 7000000;
    private long actualSalary;
    private long hour;

    public EmployeeFullTime(String id, String name, String gender, int age, String email, String numberPhone, long salary, String status, String typeEmployee, long actualSalary) {
        super(id, name, gender, age, email, numberPhone, salary, status);
        this.typeEmployee = typeEmployee;
        this.actualSalary = actualSalary;
    }

    public EmployeeFullTime(String typeEmployee, long actualSalary) {
        this.typeEmployee = typeEmployee;
        this.actualSalary = actualSalary;
    }


    public EmployeeFullTime() {
        super();

    }

    public long getHour() {
        return hour;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }

    @Override
    public long getSalary() {
        return salary;
    }

    public long getActualSalary() {
        return actualSalary;
    }

    public void setActualSalary(long actualSalary) {
        this.actualSalary = actualSalary;
    }

    @Override
    public long calculateSalary() {
        this.actualSalary = salary + salaryBonus + ((hour * 30) * 1000);

        return this.actualSalary;
    }


    public String toString1() {
        return super.toString() +
                ", typeEmployee='" + typeEmployee + " | " ;
    }
    public String toString3() {
        return "Employee: " + " | " + ", Id="  + getId() + " | " +
                ", name=" + getName() + " | " +
                ", typeEmployee='" + typeEmployee + " | "  +
                "actualSalary"  + calculateSalary();
    }
}
