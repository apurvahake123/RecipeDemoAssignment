package com.example.Recipe.Recipedemo.service;

import com.example.Recipe.Recipedemo.dto.RecipeDTO;
import com.example.Recipe.Recipedemo.dto.SearchDTO;
import com.example.Recipe.Recipedemo.entity.Recipe;
import com.example.Recipe.Recipedemo.exception.RecipedemoException;

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
    public List<RecipeDTO> searchRecipe(SearchDTO searchDTO) throws RecipedemoException;

 //   public List<Recipe> findRecipe(String ingredients, String instructions) throws RecipedemoException;

}
