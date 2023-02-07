package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.ExaminationType;
import com.solvd.pharmacyservice.models.Inventory;

public class InventoryBuilder {

    private int inventoryId;
    private String medicineName;
    private int amountLeft;
    private int amountTaken;
    private int categoryId;
    private double priceOfMedicine;

    public InventoryBuilder(int inventoryId, String medicineName) {
        if (inventoryId == 0 || (medicineName == null)) {
            throw new IllegalArgumentException("Inventory ID cannot be 0 and Medicine Name cannot be null");
        }
        this.inventoryId = inventoryId;
        this.medicineName = medicineName;
    }

    public InventoryBuilder withAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
        return this;
    }

    public InventoryBuilder withAmountTaken(int amountTaken) {
        this.amountTaken = amountTaken;
        return this;
    }

    public InventoryBuilder withCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }
    public InventoryBuilder withPriceOfMedicine(double priceOfMedicine) {
        this.priceOfMedicine = priceOfMedicine;
        return this;
    }

    public Inventory build() {
        return new Inventory(this);
    }

    public int getInventoryId() {
        return this.inventoryId;
    }

    public String getMedicineName() {
        return this.medicineName;
    }

    public int getAmountLeft() {
        return this.amountLeft;
    }

    public int getAmountTaken() {
        return this.amountTaken;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public double getPriceOfMedicine() {
        return this.priceOfMedicine;
    }
}
