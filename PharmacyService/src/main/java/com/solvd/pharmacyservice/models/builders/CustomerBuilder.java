package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.Customer;

import java.util.Date;

public class CustomerBuilder {
    private int customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private Date dateOfBirth;
    private String address;

    public CustomerBuilder(int customerId, String firstName, String lastName) {
        if (customerId == 0 || (firstName == null) || (lastName == null)) {
            throw new IllegalArgumentException("Customer ID cannot be 0 and First Name and Last Name cannot be null");
        }

        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CustomerBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CustomerBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public CustomerBuilder withDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public CustomerBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public Customer build() {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhoneNumber(phoneNumber);
        customer.setAge(age);
        customer.setAddress(address);
        return customer;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int getAge() {
        return this.age;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getAddress() {
        return this.address;
    }
}
