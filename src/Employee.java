public class Employee {
    private String name;
    private int departmentId;
    private int age;
    private double salary;

    public Employee(String name, int dept, int age, double salary) {
        setName(name);
        setDepartmentId(dept);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}