package com.example.Recipe.Recipedemo.dto;

import com.example.Recipe.Recipedemo.entity.Recipe;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RecipeDTO {
    Integer recipeid;
    String recipename;

    String recipetype;
    Integer serve;
    String ingredients;
    String instructions;

    public RecipeDTO() {

    }

    public Integer getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(Integer recipeid) {
        this.recipeid = recipeid;
    }

    public String getRecipename() {
        return recipename;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public String getRecipetype() {
        return recipetype;
    }

    public void setRecipetype(String recipetype) {
        this.recipetype = recipetype;
    }

    public Integer getServe() {
        return serve;
    }

    public void setServe(Integer serve) {
        this.serve = serve;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public static RecipeDTO valueOf(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setRecipeid(recipe.getRecipeid());
        recipeDTO.setRecipename(recipe.getRecipename());
        recipeDTO.setRecipetype(recipe.getRecipetype());
        recipeDTO.setServe(recipe.getServe());
        recipeDTO.setIngredients(recipe.getIngredients());
        recipeDTO.setInstructions(recipe.getInstructions());
        return recipeDTO;
    }

    public Recipe createEntity() {
        Recipe recipe = new Recipe();
        recipe.setRecipeid(this.getRecipeid());
        recipe.setRecipename(this.getRecipename());
        recipe.setRecipetype(this.getRecipetype());
        recipe.setServe(this.getServe());
        recipe.setIngredients(this.getIngredients());
        recipe.setInstructions(this.getInstructions());
        return recipe;
    }

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "recipeid=" + recipeid +
                ", recipename='" + recipename + '\'' +
                ", recipetype='" + recipetype + '\'' +
                ", serve=" + serve +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}


