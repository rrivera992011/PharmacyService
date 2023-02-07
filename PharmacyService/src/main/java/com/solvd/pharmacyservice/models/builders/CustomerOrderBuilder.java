package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.Customer;
import com.solvd.pharmacyservice.models.CustomerOrder;

import java.sql.Date;

public class CustomerOrderBuilder {

    private int customerOrderId;
    private double orderTotal;
    private int customerId;
    private Date orderDate;
    private int paymentTypeId;
    private int productId;

    public CustomerOrderBuilder(int customerOrderId, double orderTotal, int customerId) {

        if (customerOrderId == 0 || (orderTotal == 0) || (customerId == 0)) {
            throw new IllegalArgumentException("Customer Order ID, Order Total, and Customer ID cannot be 0");
        }
        this.customerOrderId = customerOrderId;
        this.orderTotal = orderTotal;
        this.customerId = customerId;
    }

    public CustomerOrderBuilder withOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public CustomerOrderBuilder withPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
        return this;
    }

    public CustomerOrderBuilder withProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public CustomerOrder build() {
        return new CustomerOrder(this);
    }

    public int getCustomerOrderId() {
        return this.customerOrderId;
    }

    public double getOrderTotal() {
        return this.orderTotal;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public int getPaymentTypeId() {
        return this.paymentTypeId;
    }

    public int getProductId() {
        return this.productId;
    }
}
