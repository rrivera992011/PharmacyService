package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.Examination;

public class ExaminationBuilder {
    private int examinationId;
    private String examResult;
    private int employeeId;
    private int examinationTypeId;
    private int customerId;

    public ExaminationBuilder(int examinationId, String examResult, int employeeId) {
        if (examinationId == 0 || (examResult == null) || (employeeId == 0)) {
            throw new IllegalArgumentException("Examination ID and Employee ID cannot be 0 and Exam Result cannot be null");
        }

        this.examinationId = examinationId;
        this.examResult = examResult;
        this.employeeId = employeeId;
    }

    public ExaminationBuilder withExaminationTypeId(int examinationTypeId) {
        this.examinationTypeId = examinationTypeId;
        return this;
    }

    public ExaminationBuilder withCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public Examination build() {
        return new Examination(this);
    }

    public int getExaminationId() {
        return examinationId;
    }

    public String getExamResult() {
        return examResult;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getExaminationTypeId() {
        return examinationTypeId;
    }

    public int getCustomerId() {
        return customerId;
    }
}
