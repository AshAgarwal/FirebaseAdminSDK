package com.company;

public class FoodRecipe {
    private String cuisineType;
    private String foodName;
    private String foodDescription;
    private String prepTime;
    private String cookTime;
    private String totalTime;
    private String recipeYeild;
    private String category;

    public FoodRecipe() {}      // Default Constructor

    public FoodRecipe(String cuisineType, String foodName, String foodDescription, String prepTime, String cookTime, String totalTime, String recipeYeild, String category) {
        this.cuisineType = cuisineType;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.totalTime = totalTime;
        this.recipeYeild = recipeYeild;
        this.category = category;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public String getRecipeYeild() {
        return recipeYeild;
    }


    public String getCategory() {
        return category;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public void setRecipeYeild(String recipeYeild) {
        this.recipeYeild = recipeYeild;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
