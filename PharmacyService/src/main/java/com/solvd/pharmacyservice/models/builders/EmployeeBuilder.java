package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.CustomerOrder;
import com.solvd.pharmacyservice.models.Employee;

public class EmployeeBuilder {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private int employeeTypeId;

    public EmployeeBuilder(int employeeId, String firstName, String lastName) {
        if (employeeId == 0 || (firstName == null) || (lastName == null)) {
            throw new IllegalArgumentException("Employee ID cannot be 0 and First Name and Last Name cannot be null");
        }

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public EmployeeBuilder withEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
        return this;
    }

    public EmployeeBuilder withEmployeeTypeId(int employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
        return this;
    }

    public Employee build() {
        return new Employee(this);
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmployeeNumber() {
        return this.employeeNumber;
    }

    public int getEmployeeTypeId() {
        return this.employeeTypeId;
    }
}
