package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.Customer;

import java.util.Date;

public class CustomerBuilder {
    public int customerId;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public int age;
    public Date dateOfBirth;
    public String address;

    public CustomerBuilder(int customerId, String firstName, String lastName) {
        if (customerId == 0 || (firstName == null) || (lastName == null)) {
            throw new IllegalArgumentException("Customer ID cannot be zero and name cannot be null");
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
        return new Customer(this);
    }

}
