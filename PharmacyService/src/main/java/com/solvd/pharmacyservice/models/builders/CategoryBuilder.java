package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.AppointmentType;
import com.solvd.pharmacyservice.models.Category;

public class CategoryBuilder {

    private int categoryId;
    private String categoryName;

    public CategoryBuilder(int categoryId, String categoryName) {
        if (categoryId == 0 || (categoryName == null)) {
            throw new IllegalArgumentException("Category ID cannot be 0 and Category Name cannot be null");
        }
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category build() {
        return new Category(this);
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}
