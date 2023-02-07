package com.solvd.pharmacyservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.pharmacyservice.models.builders.PaymentTypeBuilder;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "paymentType")
@XmlType(propOrder = {"paymentTypeId", "paymentTypeName"})
public class PaymentType {
    @JsonProperty
    private int paymentTypeId;
    @JsonProperty
    private String paymentTypeName;

    public PaymentType(int paymentTypeId, String paymentTypeName) {
        this.paymentTypeId = paymentTypeId;
        this.paymentTypeName = paymentTypeName;
    }

    public PaymentType() {
    }

    public PaymentType(PaymentTypeBuilder paymentTypeBuilder) {
        this.paymentTypeId = paymentTypeBuilder.getPaymentTypeId();
        this.paymentTypeName = paymentTypeBuilder.getPaymentTypeName();
    }

    public int getPaymentTypeId() {
        return this.paymentTypeId;
    }

    @XmlAttribute(name = "id")
    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeName() {
        return this.paymentTypeName;
    }

    @XmlElement(name = "paymentTypeName")
    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    @Override
    public String toString() {
        return "\nPayment Type ID = " + paymentTypeId +
                ", Payment Type = '" + paymentTypeName + '\'';
    }
}
