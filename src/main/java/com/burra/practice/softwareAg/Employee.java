package com.burra.practice.softwareAg;

public class Employee extends Person{
    private final String role;
    public Employee(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        return role.equals(employee.role);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
