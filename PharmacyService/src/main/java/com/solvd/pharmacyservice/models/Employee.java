package com.solvd.pharmacyservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.pharmacyservice.models.builders.EmployeeBuilder;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employee")
@XmlType(propOrder = {"employeeId", "firstName", "lastName", "employeeNumber", "employeeTypeId"})
public class Employee {
    @JsonProperty
    private int employeeId;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String employeeNumber;
    @JsonProperty
    private int employeeTypeId;

    public Employee(int employeeId, String firstName, String lastName, String employeeNumber, int employeeTypeId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.employeeTypeId = employeeTypeId;
    }

    public Employee() {
    }

    public Employee(EmployeeBuilder employeeBuilder) {
        this.employeeId = employeeBuilder.getEmployeeId();
        this.firstName = employeeBuilder.getFirstName();
        this.lastName = employeeBuilder.getLastName();
        this.employeeNumber = employeeBuilder.getEmployeeNumber();
        this.employeeTypeId = employeeBuilder.getEmployeeTypeId();
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    @XmlAttribute(name = "id")
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    @XmlElement(name = "firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @XmlElement(name = "lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeNumber() {
        return this.employeeNumber;
    }

    @XmlElement(name = "employeeNumber")
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getEmployeeTypeId() {
        return this.employeeTypeId;
    }

    @XmlElement(name = "employeeTypeId")
    public void setEmployeeTypeId(int employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    @Override
    public String toString() {
        return "\nEmployee ID = " + employeeId +
                ", First Name = '" + firstName + '\'' +
                ", Last Name = '" + lastName + '\'' +
                ", Employee Number = '" + employeeNumber + '\'' +
                ", Employee Type ID = " + employeeTypeId;
    }
}
