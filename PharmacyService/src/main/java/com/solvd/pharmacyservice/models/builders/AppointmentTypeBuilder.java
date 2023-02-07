package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.AppointmentType;

public class AppointmentTypeBuilder {

    private int appointmentTypeId;
    private String appointmentTypeName;

    public AppointmentTypeBuilder(int appointmentTypeId, String appointmentTypeName) {
        if (appointmentTypeId == 0 || (appointmentTypeName == null)) {
            throw new IllegalArgumentException("Appointment Type ID cannot be 0 and Appointment Type Name cannot be null");
        }
        this.appointmentTypeId = appointmentTypeId;
        this.appointmentTypeName = appointmentTypeName;
    }

    public AppointmentType build() {
        return new AppointmentType(this);
    }

    public int getAppointmentTypeId() {
        return this.appointmentTypeId;
    }

    public String getAppointmentTypeName() {
        return this.appointmentTypeName;
    }
}
