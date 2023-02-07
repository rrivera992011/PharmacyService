package com.solvd.pharmacyservice.models;

import com.solvd.pharmacyservice.models.builders.CustomerOrderBuilder;

import java.sql.Date;

public class CustomerOrder {
    private int customerOrderId;
    private double orderTotal;
    private int customerId;
    private Date orderDate;
    private int paymentTypeId;
    private int productId;

    public CustomerOrder(int customerOrderId, double orderTotal, int customerId, Date orderDate, int paymentTypeId,
                         int productId) {
        this.customerOrderId = customerOrderId;
        this.orderTotal = orderTotal;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.paymentTypeId = paymentTypeId;
        this.productId = productId;
    }

    public CustomerOrder() {
    }

    public CustomerOrder(CustomerOrderBuilder customerOrderBuilder) {
        this.customerOrderId = customerOrderBuilder.getCustomerOrderId();
        this.orderTotal = customerOrderBuilder.getOrderTotal();
        this.customerId = customerOrderBuilder.getCustomerId();
        this.orderDate = customerOrderBuilder.getOrderDate();
        this.paymentTypeId = customerOrderBuilder.getPaymentTypeId();
        this.productId = customerOrderBuilder.getProductId();

    }

    public int getCustomerOrderId() {
        return this.customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public double getOrderTotal() {
        return this.orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public int getPaymentTypeId() {
        return this.paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "\nCustomer Order ID = " + customerOrderId +
                ", Order Total = " + orderTotal +
                ", Customer ID = " + customerId +
                ", Order Date = " + orderDate +
                ", Payment Type ID=" + paymentTypeId +
                ", Product ID = " + productId;
    }
}
