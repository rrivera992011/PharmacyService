package com.solvd.pharmacyservice.models.builders;

import com.solvd.pharmacyservice.models.Recipe;

public class RecipeBuilder {

    private int recipeId;
    private double recipeSize;

    public RecipeBuilder(int recipeId, double recipeSize) {
        if (recipeId == 0 || (recipeSize == 0)) {
            throw new IllegalArgumentException("Recipe ID and Recipe Size cannot be 0");
        }
        this.recipeId = recipeId;
        this.recipeSize = recipeSize;
    }

    public Recipe build() {
        return new Recipe(this);
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    public double getRecipeSize() {
        return this.recipeSize;
    }
}
