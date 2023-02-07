package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.ExaminationType;

public class ExaminationTypeBuilder {
    private int examinationTypeId;
    private String examinationTypeName;

    public ExaminationTypeBuilder(int examinationTypeId, String examinationTypeName) {
        if (examinationTypeId == 0 || (examinationTypeName == null)) {
            throw new IllegalArgumentException("Examination Type ID cannot be 0 and Examination Type Name cannot be null");
        }
        this.examinationTypeId = examinationTypeId;
        this.examinationTypeName = examinationTypeName;
    }

    public ExaminationType build() {
        return new ExaminationType(this);
    }
    public int getExaminationTypeId() {
        return this.examinationTypeId;
    }

    public String getExaminationTypeName() {
        return this.examinationTypeName;
    }
}
