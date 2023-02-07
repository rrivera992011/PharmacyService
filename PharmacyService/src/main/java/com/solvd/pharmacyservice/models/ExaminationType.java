package com.solvd.pharmacyservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.pharmacyservice.models.builders.ExaminationTypeBuilder;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "examinationType")
@XmlType(propOrder = {"examinationTypeId", "examinationTypeName"})
public class ExaminationType {
    @JsonProperty
    private int examinationTypeId;
    @JsonProperty
    private String examinationTypeName;

    public ExaminationType(int examinationTypeId, String examinationTypeName) {
        this.examinationTypeId = examinationTypeId;
        this.examinationTypeName = examinationTypeName;
    }

    public ExaminationType() {
    }

    public ExaminationType(ExaminationTypeBuilder examinationTypeBuilder) {
        this.examinationTypeId = examinationTypeBuilder.getExaminationTypeId();
        this.examinationTypeName = examinationTypeBuilder.getExaminationTypeName();
    }

    public int getExaminationTypeId() {
        return this.examinationTypeId;
    }

    @XmlAttribute(name = "id")
    public void setExaminationTypeId(int examinationTypeId) {
        this.examinationTypeId = examinationTypeId;
    }

    public String getExaminationTypeName() {
        return this.examinationTypeName;
    }

    @XmlElement(name = "examinationTypeName")
    public void setExaminationTypeName(String examinationTypeName) {
        this.examinationTypeName = examinationTypeName;
    }

    @Override
    public String toString() {
        return "\nExamination Type ID = " + examinationTypeId +
                ", Examination Type Name = '" + examinationTypeName + '\'';
    }
}
