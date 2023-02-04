package com.solvd.pharmacyservice;

import com.solvd.pharmacyservice.models.*;
import com.solvd.pharmacyservice.models.builders.CustomerBuilder;
import com.solvd.pharmacyservice.sql.IBaseDAO;
import com.solvd.pharmacyservice.sql.mybatis.*;
import com.solvd.pharmacyservice.utils.DBFactoryGenerator;
import com.solvd.pharmacyservice.utils.enums.DBConnectionType;
import org.apache.logging.log4j.*;
import java.sql.Date;


import java.util.List;

public class MyBatisMain {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);

    public static void main(String[] args) {
        AppointmentTypeDAO appointmentTypeDAO = new AppointmentTypeDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        IBaseDAO customerDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("customer");
        // CustomerDAO customerDAO = new CustomerDAO();
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

        /* Customer daniel = new Customer(1, "Daniel", "Andrews","12343234123", 25,
                "12 Main Ave");*/
        Customer daniel = new CustomerBuilder(1, "Daniel", "Andrews")
                .withPhoneNumber("12343234123").withAge(25).withAddress("12 Main Ave").build();
        customerDAO.createEntity(daniel);
        daniel.setAddress("12 East Road");
        customerDAO.updateEntity(daniel);
        List<Customer> customers = customerDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + customers);
        LOGGER.log(MENU_LOG, "Testing out id" + customerDAO.getEntityById(1));
        // LOGGER.log(MENU_LOG, "Testing out last name" + customerDAO.getCustomerByLastName("Andrews"));

        EmployeeType clerk = new EmployeeType(1, "Clerk");
        employeeTypeDAO.createEntity(clerk);
        clerk.setEmployeeTypeName("Counter clerk");
        employeeTypeDAO.updateEntity(clerk);
        List<EmployeeType> employeeTypes = employeeTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + employeeTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + employeeTypeDAO.getEntityById(1));

        Employee michael = new Employee(1, "Michael", "Morris",
                "123443223", 1);
        employeeDAO.createEntity(michael);
        michael.setLastName("Adams");
        employeeDAO.updateEntity(michael);
        List<Employee> employees = employeeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + employees);
        LOGGER.log(MENU_LOG, "Testing out id" + employeeDAO.getEntityById(1));

        AppointmentType vaccine = new AppointmentType(1, "Vaccine");
        appointmentTypeDAO.createEntity(vaccine);
        vaccine.setAppointmentTypeName("COVID vaccine");
        appointmentTypeDAO.updateEntity(vaccine);
        List<AppointmentType> appointmentTypes = appointmentTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + appointmentTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + appointmentTypeDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out name" +
                appointmentTypeDAO.getAppointmentTypeByName("Vaccine"));

        ExaminationType covidTest = new ExaminationType(1, "COVID Test");
        examinationTypeDAO.createEntity(covidTest);
        List<ExaminationType> examinationTypes = examinationTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + examinationTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + examinationTypeDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out by name" +
                examinationTypeDAO.getExaminationTypeByName("COVID Test"));

        PaymentType cash = new PaymentType(1, "Cash");
        paymentTypeDAO.createEntity(cash);
        List<PaymentType> paymentTypes = paymentTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + paymentTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + paymentTypeDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out id" + paymentTypeDAO.getPaymentTypeByName("Cash"));

        Recipe levofloxacin = new Recipe(1, 20);
        recipeDAO.createEntity(levofloxacin);
        levofloxacin.setRecipeSize(50);
        List<Recipe> recipes = recipeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + recipes);
        LOGGER.log(MENU_LOG, "Testing out id" + recipeDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out id" + recipeDAO.getRecipeFromRecipeSize(50));

        Category antibiotic = new Category(1, "Antibiotic");
        categoryDAO.createEntity(antibiotic);
        antibiotic.setCategoryName("Antibiotics");
        categoryDAO.updateEntity(antibiotic);
        List<Category> categories = categoryDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + categories);
        LOGGER.log(MENU_LOG, "Testing out id" + categoryDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out name" + categoryDAO.getCategoryByName("Antibiotics"));

        Inventory advil = new Inventory(1, "Advil", 2, 100,
                1, 8.25);
        inventoryDAO.createEntity(advil);
        advil.setPriceOfMedicine(13.99);
        inventoryDAO.updateEntity(advil);
        List<Inventory> inventory = inventoryDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + inventory);
        LOGGER.log(MENU_LOG, "Testing out id" + inventoryDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out medicine name" + inventoryDAO.getInventoryByMedicineName("Advil"));
        advil.setAmountTaken(98);
        advil.setAmountLeft(0);
        LOGGER.log(MENU_LOG, "Testing out id" + inventoryDAO.getEntityById(1));
        inventoryDAO.removeInventoryWithAmountLeft(0);
        LOGGER.log(MENU_LOG, "Testing out get all " + inventory);


        CustomerOrder orderForDaniel = new CustomerOrder(1, 18.25, 1,
                Date.valueOf("2022-12-24"), 1, 1);
        customerOrderDAO.createEntity(orderForDaniel);
        List<CustomerOrder> customerOrders = customerOrderDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + customerOrders);
        LOGGER.log(MENU_LOG, "Testing out id" + customerOrderDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out id" + customerOrderDAO.getCustomerOrderByProductID(1));

        Prescription prescriptionForDaniel = new Prescription(1, "1234543", 25.13,
                50, Date.valueOf("2022-12-26"), 1, 1, 1);
        prescriptionDAO.createEntity(prescriptionForDaniel);
        List<Prescription> prescriptions = prescriptionDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + prescriptions);
        LOGGER.log(MENU_LOG, "Testing out id" + prescriptionDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out id" + prescriptionDAO.getPrescriptionByCustomerID(1));
        LOGGER.log(MENU_LOG, "Testing out id" + prescriptionDAO.getPrescriptionByRxNumber("1234543"));


        Appointment danielAppointment = new Appointment(1, Date.valueOf("2022-12-27"),
                1, 1, 1);
        appointmentDAO.createEntity(danielAppointment);
        List<Appointment> appointments = appointmentDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + appointments);
        LOGGER.log(MENU_LOG, "Testing out id" + appointmentDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out " + appointmentDAO.getAppointmentByCustomerID(1));

        Examination danielExamination = new Examination(1, "Positive", 1,
                1, 1);
        examinationDAO.createEntity(danielExamination);
        danielExamination.setExamResult("Negative");
        examinationDAO.updateEntity(danielExamination);
        List<Examination> examinations = examinationDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + examinations);
        LOGGER.log(MENU_LOG, "Testing out id" + examinationDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out " + examinationDAO.getExaminationByResult("Positive"));

        examinationDAO.removeEntity(1);
        appointmentDAO.removeEntity(1);
        prescriptionDAO.removeEntity(1);
        customerOrderDAO.removeEntity(1);
        inventoryDAO.removeEntity(1);
        categoryDAO.removeEntity(1);
        recipeDAO.removeEntity(1);
        paymentTypeDAO.removeEntity(1);
        examinationTypeDAO.removeEntity(1);
        appointmentTypeDAO.removeEntity(1);
        employeeDAO.removeEntity(1);
        employeeTypeDAO.removeEntity(1);
        customerDAO.removeEntity(1);
    }
}
