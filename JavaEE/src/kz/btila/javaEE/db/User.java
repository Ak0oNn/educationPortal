package kz.btila.javaEE.db;

public class User {
    private int id;
    private String name;
    private String surname;
    private String Department;
    private int salary;

    public User() {
    }

    public User(int id,String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        Department = department;
        this.salary = salary;
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
