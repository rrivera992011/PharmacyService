package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.Appointment;
import com.solvd.pharmacyservice.models.Customer;

import java.sql.Date;

public class AppointmentBuilder {
    private int appointmentId;
    private Date appointmentDate;
    private int customerId;
    private int employeeId;
    private int appointmentTypeId;

    public AppointmentBuilder(int appointmentId, Date appointmentDate, int customerId) {
        if (appointmentId == 0 || (appointmentDate == null) || (customerId == 0)) {
            throw new IllegalArgumentException("Appointment ID and Customer ID cannot be 0 and Appointment Date" +
                    " cannot be null");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.customerId = customerId;

    }

    public AppointmentBuilder withEmployeeId(int employeeId){
        this.employeeId = employeeId;
        return this;
    }

    public AppointmentBuilder withAppointmentTypeId(int appointmentTypeId){
        this.appointmentTypeId = appointmentTypeId;
        return this;
    }

    public Appointment build() {
        return new Appointment(this);
    }

    public int getAppointmentId() {
        return this.appointmentId;
    }

    public Date getAppointmentDate() {
        return this.appointmentDate;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public int getAppointmentTypeId() {
        return this.appointmentTypeId;
    }
}
