package com.example.Recipe.Recipedemo.service;

import com.example.Recipe.Recipedemo.dto.RecipeDTO;
import com.example.Recipe.Recipedemo.entity.Recipe;

import java.util.List;

/**
 * Recipe Service Interface
 */
public interface RecipeService {
    public List<RecipeDTO> getAllRecipes() throws Exception;
    public RecipeDTO getRecipe(Integer recipeid) throws Exception;
    public Integer addRecipe(RecipeDTO recipe) throws Exception;
    public List<Recipe> deleteRecipe(Integer recipeid) throws Exception;
    public Recipe updateRecipe(RecipeDTO recipeDTO) throws Exception;
    public List<RecipeDTO> getByRecipetype(String recipetype);
    public List<RecipeDTO> getByServe(Integer serve);
    public List<Recipe> searchRecipe(String query);

}
