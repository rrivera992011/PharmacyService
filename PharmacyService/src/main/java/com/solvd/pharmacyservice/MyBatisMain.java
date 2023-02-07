package com.solvd.pharmacyservice;

import com.solvd.pharmacyservice.models.*;
import com.solvd.pharmacyservice.models.builders.*;
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
        IBaseDAO appointmentTypeDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("appointmentType");
        IBaseDAO categoryDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("category");
        IBaseDAO customerDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("customer");
        IBaseDAO customerOrderDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("customerOrder");
        IBaseDAO employeeDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("employee");
        IBaseDAO employeeTypeDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("employeeType");
        IBaseDAO examinationDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("examination");
        IBaseDAO examinationTypeDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("examinationType");
        IBaseDAO inventoryDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("inventory");
        IBaseDAO paymentTypeDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("paymentType");
        IBaseDAO prescriptionDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("prescription");
        IBaseDAO recipeDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("recipe");
        IBaseDAO appointmentDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("appointment");

        Customer daniel = new CustomerBuilder(1, "Daniel", "Andrews")
                .withPhoneNumber("12343234123").withAge(25).withAddress("12 Main Ave").build();
        customerDAO.createEntity(daniel);
        daniel.setAddress("12 East Road");
        customerDAO.updateEntity(daniel);
        List<Customer> customers = customerDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + customers);
        LOGGER.log(MENU_LOG, "Testing out id" + customerDAO.getEntityById(1));

        EmployeeType clerk = new EmployeeTypeBuilder(1, "Clerk").build();
        employeeTypeDAO.createEntity(clerk);
        clerk.setEmployeeTypeName("Counter clerk");
        employeeTypeDAO.updateEntity(clerk);
        List<EmployeeType> employeeTypes = employeeTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + employeeTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + employeeTypeDAO.getEntityById(1));

        Employee michael = new EmployeeBuilder(1, "Michael", "Morris")
                .withEmployeeNumber("123443223").withEmployeeTypeId(1).build();
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

        ExaminationType covidTest = new ExaminationTypeBuilder(1, "COVID Test").build();
        examinationTypeDAO.createEntity(covidTest);
        List<ExaminationType> examinationTypes = examinationTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + examinationTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + examinationTypeDAO.getEntityById(1));

        PaymentType cash = new PaymentTypeBuilder(1, "Cash").build();
        paymentTypeDAO.createEntity(cash);
        List<PaymentType> paymentTypes = paymentTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + paymentTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + paymentTypeDAO.getEntityById(1));

        Recipe levofloxacin = new RecipeBuilder(1, 20).build();
        recipeDAO.createEntity(levofloxacin);
        levofloxacin.setRecipeSize(50);
        List<Recipe> recipes = recipeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + recipes);
        LOGGER.log(MENU_LOG, "Testing out id" + recipeDAO.getEntityById(1));

        Category antibiotic = new CategoryBuilder(1, "Antibiotic").build();
        categoryDAO.createEntity(antibiotic);
        antibiotic.setCategoryName("Antibiotics");
        categoryDAO.updateEntity(antibiotic);
        List<Category> categories = categoryDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + categories);
        LOGGER.log(MENU_LOG, "Testing out id" + categoryDAO.getEntityById(1));

        Inventory advil = new InventoryBuilder(1, "Advil").withAmountLeft(100).withAmountTaken(2)
                .withCategoryId(1).withPriceOfMedicine(8.25).build();
        inventoryDAO.createEntity(advil);
        advil.setPriceOfMedicine(13.99);
        inventoryDAO.updateEntity(advil);
        List<Inventory> inventory = inventoryDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + inventory);
        LOGGER.log(MENU_LOG, "Testing out id" + inventoryDAO.getEntityById(1));
        advil.setAmountTaken(8);
        advil.setAmountLeft(92);
        LOGGER.log(MENU_LOG, "Testing out id" + inventoryDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out get all " + inventory);


        CustomerOrder orderForDaniel = new CustomerOrderBuilder(1, 18.25, 1)
                .withOrderDate(Date.valueOf("2022-12-24")).withPaymentTypeId(1).withProductId(1).build();
        customerOrderDAO.createEntity(orderForDaniel);
        List<CustomerOrder> customerOrders = customerOrderDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + customerOrders);
        LOGGER.log(MENU_LOG, "Testing out id" + customerOrderDAO.getEntityById(1));

        Prescription prescriptionForDaniel = new PrescriptionBuilder(1, "1234543", 25.13)
                .withAmountOfMedicine(50).withDateFilled(Date.valueOf("2022-12-26")).withCustomerId(1).withInventoryId(1)
        .withRecipeId(1).build();
        prescriptionDAO.createEntity(prescriptionForDaniel);
        List<Prescription> prescriptions = prescriptionDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + prescriptions);
        LOGGER.log(MENU_LOG, "Testing out id" + prescriptionDAO.getEntityById(1));


        Appointment danielAppointment = new AppointmentBuilder(1, Date.valueOf("2022-12-27"), 1)
        .withEmployeeId(1).withAppointmentTypeId(1).build();
        appointmentDAO.createEntity(danielAppointment);
        List<Appointment> appointments = appointmentDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + appointments);
        LOGGER.log(MENU_LOG, "Testing out id" + appointmentDAO.getEntityById(1));

        Examination danielExamination = new ExaminationBuilder(1, "Positive", 1)
                .withExaminationTypeId(1).withCustomerId(1).build();
        examinationDAO.createEntity(danielExamination);
        danielExamination.setExamResult("Negative");
        examinationDAO.updateEntity(danielExamination);
        List<Examination> examinations = examinationDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + examinations);
        LOGGER.log(MENU_LOG, "Testing out id" + examinationDAO.getEntityById(1));

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
