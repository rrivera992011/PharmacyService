package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.EmployeeType;

public class EmployeeTypeBuilder {
    private int employeeTypeId;
    private String employeeTypeName;

    public EmployeeTypeBuilder(int employeeTypeId, String employeeTypeName) {
        if (employeeTypeId == 0 || (employeeTypeName == null)) {
            throw new IllegalArgumentException("Employee Type ID cannot be 0 and Employee Type Name cannot be null");
        }

        this.employeeTypeId = employeeTypeId;
        this.employeeTypeName = employeeTypeName;
    }

    public EmployeeType build() {
        return new EmployeeType(this);
    }

    public int getEmployeeTypeId() {
        return this.employeeTypeId;
    }

    public String getEmployeeTypeName() {
        return this.employeeTypeName;
    }
}
