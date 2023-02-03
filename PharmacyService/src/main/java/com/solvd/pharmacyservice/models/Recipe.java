package com.solvd.pharmacyservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "recipe")
@XmlType(propOrder = {"recipeId", "recipeSize"})
public class Recipe {
    @JsonProperty
    private int recipeId;
    @JsonProperty
    private double recipeSize;

    public Recipe(int recipeId, double recipeSize) {
        this.recipeId = recipeId;
        this.recipeSize = recipeSize;
    }

    public Recipe() {
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    @XmlAttribute(name = "id")
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public double getRecipeSize() {
        return this.recipeSize;
    }

    @XmlElement(name = "recipeSize")
    public void setRecipeSize(double recipeSize) {
        this.recipeSize = recipeSize;
    }

    @Override
    public String toString() {
        return "\nRecipe ID = " + recipeId +
                ", Recipe Size = " + recipeSize;
    }
}
