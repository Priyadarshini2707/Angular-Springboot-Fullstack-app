package com.lekwacious.employee_app.data.payloads.request;

import com.lekwacious.employee_app.data.models.Department;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.antlr.v4.runtime.misc.NotNull;

public class EmployeeRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String lastname;

    @NotNull
    private String phoneNumber;

    private String email;

    @NotNull
    private double salary;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Department department;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
