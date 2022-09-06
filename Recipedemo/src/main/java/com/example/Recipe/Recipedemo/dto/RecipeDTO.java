package com.example.Recipe.Recipedemo.dto;

import com.example.Recipe.Recipedemo.entity.Recipe;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RecipeDTO {
    Integer recipeid;
    String recipename;
    String recipetype;
    Integer serve;
    String ingredients;
    String instructions;

    /**
     * Coverted Entity into DTO
     * @param recipe
     * @return Recipe DTO
     */
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
}


