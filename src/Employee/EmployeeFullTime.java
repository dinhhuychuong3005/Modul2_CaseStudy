package Employee;

public class EmployeeFullTime extends Employee {
    private final String typeEmployee = "FullTime";
    private final long salaryBonus = 1000000;
    private long actualSalary;

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

    @Override
    public String toString() {
        return super.toString() +
                "typeEmployee='" + typeEmployee + '\'' +
                ", salaryBonus=" + salaryBonus +
                ", actualSalary=" + actualSalary ;
    }
}
