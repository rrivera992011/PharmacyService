package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Appointment;

public interface IAppointmentDAO extends IBaseDAO<Appointment>{
    Appointment getAppointmentByCustomerID(int customerId);
}
