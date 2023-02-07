package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.Prescription;

import java.sql.Date;

public class PrescriptionBuilder {
    private int prescriptionId;
    private String rxNumber;
    private double priceOfPrescription;
    private int amountOfMedicine;
    private Date dateFilled;
    private int customerId;
    private int inventoryId;
    private int recipeId;

    public PrescriptionBuilder(int prescriptionId, String rxNumber, double priceOfPrescription) {
        if (prescriptionId == 0 || (rxNumber == null) || (priceOfPrescription == 0)) {
            throw new IllegalArgumentException("Prescription ID and Price of Prescription cannot be 0 and" +
                    " Rx Number cannot be null");
        }

        this.prescriptionId = prescriptionId;
        this.rxNumber = rxNumber;
        this.priceOfPrescription = priceOfPrescription;
    }

    public PrescriptionBuilder withAmountOfMedicine(int amountOfMedicine){
        this.amountOfMedicine = amountOfMedicine;
        return this;
    }

    public PrescriptionBuilder withDateFilled(Date dateFilled){
        this.dateFilled = dateFilled;
        return this;
    }

    public PrescriptionBuilder withCustomerId(int customerId){
        this.customerId = customerId;
        return this;
    }

    public PrescriptionBuilder withInventoryId(int inventoryId){
        this.inventoryId = inventoryId;
        return this;
    }

    public PrescriptionBuilder withRecipeId(int recipeId){
        this.recipeId = recipeId;
        return this;
    }

    public Prescription build() {
        return new Prescription(this);
    }

    public int getPrescriptionId() {
        return this.prescriptionId;
    }

    public String getRxNumber() {
        return this.rxNumber;
    }

    public double getPriceOfPrescription() {
        return this.priceOfPrescription;
    }

    public int getAmountOfMedicine() {
        return this.amountOfMedicine;
    }

    public Date getDateFilled() {
        return this.dateFilled;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public int getInventoryId() {
        return this.inventoryId;
    }

    public int getRecipeId() {
        return this.recipeId;
    }
}
