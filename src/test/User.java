package test;

public class User {
    private int age;
    private String department;

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public User setDepartment(String department) {
        this.department = department;
        return this;
    }
}
