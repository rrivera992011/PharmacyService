package com.solvd.pharmacyservice;

import com.solvd.pharmacyservice.models.*;
import com.solvd.pharmacyservice.sql.mybatis.*;
import org.apache.logging.log4j.*;
import java.sql.Date;


import java.util.List;

public class MyBatisMain {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);

    public static void main(String[] args) {
        AppointmentTypeDAO appointmentTypeDAO = new AppointmentTypeDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        CustomerOrderDAO customerOrderDAO = new CustomerOrderDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        EmployeeTypeDAO employeeTypeDAO = new EmployeeTypeDAO();
        ExaminationDAO examinationDAO = new ExaminationDAO();
        ExaminationTypeDAO examinationTypeDAO = new ExaminationTypeDAO();
        InventoryDAO inventoryDAO = new InventoryDAO();
        PaymentTypeDAO paymentTypeDAO = new PaymentTypeDAO();
        PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        RecipeDAO recipeDAO = new RecipeDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        Customer daniel = new Customer(1, "Daniel", "Andrews","12343234123", 25,
                "12 Main Ave");
        customerDAO.createEntity(daniel);
        Customer adam = new Customer(2, "Adam", "Jones", "5467896543", 17,
                "12 Easy Street" );
        customerDAO.createEntity(adam);
        adam.setAddress("12 East Road");
        customerDAO.updateEntity(adam);
        List<Customer> customers = customerDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + customers);
        LOGGER.log(MENU_LOG, "Testing out id" + customerDAO.getEntityById(2));
        LOGGER.log(MENU_LOG, "Testing out last name" + customerDAO.getCustomerByLastName("Jones"));

        EmployeeType clerk = new EmployeeType(1, "Clerk");
        employeeTypeDAO.createEntity(clerk);
        EmployeeType doctor = new EmployeeType(2, "Doctor");
        employeeTypeDAO.createEntity(doctor);
        clerk.setEmployeeTypeName("Counter clerk");
        employeeTypeDAO.updateEntity(clerk);
        List<EmployeeType> employeeTypes = employeeTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + employeeTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + employeeTypeDAO.getEntityById(1));

        Employee michael = new Employee(1, "Michael", "Morris",
                "123443223", 1);
        employeeDAO.createEntity(michael);
        Employee antonio = new Employee(2, "Antonio", "Mayor",
                "212344553", 2);
        employeeDAO.createEntity(antonio);
        antonio.setLastName("Adams");
        employeeDAO.updateEntity(antonio);
        List<Employee> employees = employeeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + employees);
        LOGGER.log(MENU_LOG, "Testing out id" + employeeDAO.getEntityById(2));

        AppointmentType vaccine = new AppointmentType(1, "Vaccine");
        appointmentTypeDAO.createEntity(vaccine);
        AppointmentType recommendation = new AppointmentType(2, "Recommendation");
        appointmentTypeDAO.createEntity(recommendation);
        recommendation.setAppointmentTypeName("Clinic recommendation");
        appointmentTypeDAO.updateEntity(recommendation);
        List<AppointmentType> appointmentTypes = appointmentTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + appointmentTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + appointmentTypeDAO.getEntityById(2));
        LOGGER.log(MENU_LOG, "Testing out name" +
                appointmentTypeDAO.getAppointmentTypeByName("Vaccine"));

        ExaminationType covidTest = new ExaminationType(1, "COVID Test");
        examinationTypeDAO.createEntity(covidTest);
        ExaminationType measlesTest = new ExaminationType(2, "Measles Test");
        examinationTypeDAO.createEntity(measlesTest);
        List<ExaminationType> examinationTypes = examinationTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + examinationTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + examinationTypeDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out by name" +
                examinationTypeDAO.getExaminationTypeByName("Measles Test"));

        PaymentType cash = new PaymentType(1, "Cash");
        paymentTypeDAO.createEntity(cash);
        PaymentType creditCard = new PaymentType(2, "Credit Card");
        paymentTypeDAO.createEntity(creditCard);
        List<PaymentType> paymentTypes = paymentTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + paymentTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + paymentTypeDAO.getEntityById(2));
        LOGGER.log(MENU_LOG, "Testing out id" + paymentTypeDAO.getPaymentTypeByName("Cash"));

        Recipe levofloxacin = new Recipe(1, 20);
        recipeDAO.createEntity(levofloxacin);
        levofloxacin.setRecipeSize(50);
        Recipe genpril = new Recipe(2, 100);
        recipeDAO.createEntity(genpril);
        List<Recipe> recipes = recipeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + recipes);
        LOGGER.log(MENU_LOG, "Testing out id" + recipeDAO.getEntityById(2));
        LOGGER.log(MENU_LOG, "Testing out id" + recipeDAO.getRecipeFromRecipeSize(100));

        Category antibiotic = new Category(1, "Antibiotic");
        categoryDAO.createEntity(antibiotic);
        Category ibuprofen = new Category(2, "Ibuprofen");
        categoryDAO.createEntity(ibuprofen);
        ibuprofen.setCategoryName("headache medicine");
        categoryDAO.updateEntity(ibuprofen);
        List<Category> categories = categoryDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + categories);
        LOGGER.log(MENU_LOG, "Testing out id" + categoryDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out name" + categoryDAO.getCategoryByName("Ibuprofen"));

        Inventory advil = new Inventory(1, "Advil", 2, 100,
                2, 8.25);
        inventoryDAO.createEntity(advil);
        Inventory amoxil = new Inventory(2, "Amoxil", 1, 99,
                1, 12.99);
        inventoryDAO.createEntity(amoxil);
        amoxil.setPriceOfMedicine(13.99);
        inventoryDAO.updateEntity(amoxil);
        List<Inventory> inventory = inventoryDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + inventory);
        LOGGER.log(MENU_LOG, "Testing out id" + inventoryDAO.getEntityById(2));
        LOGGER.log(MENU_LOG, "Testing out medicine name" + inventoryDAO.getInventoryByMedicineName("Advil"));
        amoxil.setAmountTaken(99);
        amoxil.setAmountLeft(0);
        LOGGER.log(MENU_LOG, "Testing out id" + inventoryDAO.getEntityById(2));
        inventoryDAO.removeInventoryWithAmountLeft(0);
        LOGGER.log(MENU_LOG, "Testing out get all " + inventory);


        CustomerOrder orderForDaniel = new CustomerOrder(1, 18.25, 1,
                Date.valueOf("2022-12-24"), 1, 1);
        customerOrderDAO.createEntity(orderForDaniel);
        CustomerOrder orderForAdam = new CustomerOrder(2, 13.57, 2,
                Date.valueOf("2023-01-19"), 2, 2);
        customerOrderDAO.createEntity(orderForAdam);
        List<CustomerOrder> customerOrders = customerOrderDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + customerOrders);
        LOGGER.log(MENU_LOG, "Testing out id" + customerOrderDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out id" + customerOrderDAO.getCustomerOrderByProductID(1));

        Prescription prescriptionForDaniel = new Prescription(1, "1234543", 25.13,
                50, Date.valueOf("2022-12-26"), 1, 1, 1);
        prescriptionDAO.createEntity(prescriptionForDaniel);
        Prescription prescriptionForAdam = new Prescription(2, "12343432", 30.79,
                100, Date.valueOf("2023-1-20"), 2, 2, 2);
        prescriptionDAO.createEntity(prescriptionForAdam);
        List<Prescription> prescriptions = prescriptionDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + prescriptions);
        LOGGER.log(MENU_LOG, "Testing out id" + prescriptionDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out id" + prescriptionDAO.getPrescriptionByCustomerID(1));
        LOGGER.log(MENU_LOG, "Testing out id" + prescriptionDAO.getPrescriptionByRxNumber("12343432"));


        Appointment danielAppointment = new Appointment(1, Date.valueOf("2022-12-27"),
                1, 2, 1);
        appointmentDAO.createEntity(danielAppointment);
        Appointment adamAppointment = new Appointment(2, Date.valueOf("2023-01-3"),
                2, 2, 1);
        appointmentDAO.createEntity(adamAppointment);
        List<Appointment> appointments = appointmentDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + appointments);
        LOGGER.log(MENU_LOG, "Testing out id" + appointmentDAO.getEntityById(2));
        LOGGER.log(MENU_LOG, "Testing out " + appointmentDAO.getAppointmentByCustomerID(2));

        Examination danielExamination = new Examination(1, "Positive", 2,
                1, 1);
        examinationDAO.createEntity(danielExamination);
        danielExamination.setExamResult("Negative");
        examinationDAO.updateEntity(danielExamination);
        Examination adamExamination = new Examination(2, "Positive", 2,
                2, 2);
        examinationDAO.createEntity(adamExamination);
        List<Examination> examinations = examinationDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + examinations);
        LOGGER.log(MENU_LOG, "Testing out id" + examinationDAO.getEntityById(2));
        LOGGER.log(MENU_LOG, "Testing out " + examinationDAO.getExaminationByResult("Negative"));

        examinationDAO.removeEntity(1);
        examinationDAO.removeEntity(2);
        appointmentDAO.removeEntity(1);
        appointmentDAO.removeEntity(2);
        prescriptionDAO.removeEntity(1);
        prescriptionDAO.removeEntity(2);
        customerOrderDAO.removeEntity(1);
        customerOrderDAO.removeEntity(2);
        inventoryDAO.removeEntity(1);
        inventoryDAO.removeEntity(2);
        categoryDAO.removeEntity(1);
        categoryDAO.removeEntity(2);
        recipeDAO.removeEntity(1);
        recipeDAO.removeEntity(2);
        paymentTypeDAO.removeEntity(1);
        paymentTypeDAO.removeEntity(2);
        examinationTypeDAO.removeEntity(1);
        examinationTypeDAO.removeEntity(2);
        appointmentTypeDAO.removeEntity(1);
        appointmentTypeDAO.removeEntity(2);
        employeeDAO.removeEntity(1);
        employeeDAO.removeEntity(2);
        employeeTypeDAO.removeEntity(1);
        employeeTypeDAO.removeEntity(2);
        customerDAO.removeEntity(1);
        customerDAO.removeEntity(2);
    }
}
