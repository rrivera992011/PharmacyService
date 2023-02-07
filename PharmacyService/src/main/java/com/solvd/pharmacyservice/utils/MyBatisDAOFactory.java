package com.solvd.pharmacyservice.utils;

import com.solvd.pharmacyservice.sql.IBaseDAO;
import com.solvd.pharmacyservice.sql.jdbc.*;

public class MyBatisDAOFactory extends AbstractDAOFactory{
    @Override
    public IBaseDAO getDAO(String model) {
        switch (model) {
            case "appointment":
                return new AppointmentDAO();
            case "appointmentType":
                return new AppointmentTypeDAO();
            case "category":
                return new CategoryDAO();
            case "customer":
                return new CustomerDAO();
            case "customerOrder":
                return new CustomerOrderDAO();
            case "employee":
                return new EmployeeDAO();
            case "employeeType":
                return new EmployeeTypeDAO();
            case "examination":
                return new ExaminationDAO();
            case "examinationType":
                return new ExaminationTypeDAO();
            case "inventory":
                return new InventoryDAO();
            case "paymentType":
                return new PaymentTypeDAO();
            case "prescription":
                return new PrescriptionDAO();
            case "recipe":
                return new RecipeDAO();
            default:
                throw new UnsupportedFactoryException("Unsupported model");

        }
    }
}