package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.Inventory;
import com.solvd.pharmacyservice.models.PaymentType;

public class PaymentTypeBuilder {
    private int paymentTypeId;
    private String paymentTypeName;

    public PaymentTypeBuilder(int paymentTypeId, String paymentTypeName) {
        if (paymentTypeId == 0 || (paymentTypeName == null)) {
            throw new IllegalArgumentException("Payment Type ID cannot be 0 and Payment Type Name cannot be null");
        }
        this.paymentTypeId = paymentTypeId;
        this.paymentTypeName = paymentTypeName;
    }

    public PaymentType build() {
        return new PaymentType(this);
    }

    public int getPaymentTypeId() {
        return this.paymentTypeId;
    }

    public String getPaymentTypeName() {
        return this.paymentTypeName;
    }
}
