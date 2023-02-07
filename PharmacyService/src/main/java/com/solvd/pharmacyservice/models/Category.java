package com.solvd.pharmacyservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.pharmacyservice.models.builders.CategoryBuilder;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "category")
@XmlType(propOrder = {"categoryId", "categoryName"})
public class Category {
    @JsonProperty
    private int categoryId;
    @JsonProperty
    private String categoryName;

    public Category(int categoryId, String categoryName) {
        if (categoryId == 0 || (categoryName == null)) {
            throw new IllegalArgumentException("Category ID cannot be zero and Category Name cannot be null");
        }

        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category() {
    }

    public Category(CategoryBuilder categoryBuilder) {
        this.categoryId = categoryBuilder.getCategoryId();
        this.categoryName = categoryBuilder.getCategoryName();
    }

    public int getCategoryId() {
        return categoryId;
    }

    @XmlAttribute(name = "id")
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @XmlElement(name = "categoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "\nCategory ID = " + categoryId +
                ", Category Name = '" + categoryName + '\'';
    }
}
