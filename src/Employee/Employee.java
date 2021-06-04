package Employee;

public class Employee {
    private String id;
    private String name;
    private int age;
    private String email;
    private String numberPhone;
    private long salary;
    private String status;

    public Employee() {
    }

    public Employee(String id, String name, int age, String email, String numberPhone, long salary, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.numberPhone = numberPhone;
        this.salary = salary;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "Employee: " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", basic salary=" + salary +
                ", status='" + status + '\'';
    }
}
