package com.example.Recipe.Recipedemo.service;

import com.example.Recipe.Recipedemo.dto.RecipeDTO;
import com.example.Recipe.Recipedemo.entity.Recipe;
import com.example.Recipe.Recipedemo.exception.RecipedemoException;
import com.example.Recipe.Recipedemo.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service

/**
 * Implementation of Recipe Service
 */
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    /**
     * will get all recipes
     *
     * @return list of RecipeDTO
     * @throws Exception
     */
    public List<RecipeDTO> getAllRecipes() throws Exception {
        List<Recipe> recipes = recipeRepository.findAll();
        List<RecipeDTO> recipeDTOs = new ArrayList<RecipeDTO>();
        for (Recipe recipe : recipes) {
            RecipeDTO recipeDTO = RecipeDTO.valueOf(recipe);
            recipeDTOs.add(recipeDTO);
        }
        return recipeDTOs;
    }

    /**
     * will get RecipeDTO by Recipe ID
     *
     * @param recipeid
     * @return Recipe
     * @throws Exception
     */
    public RecipeDTO getRecipe(Integer recipeid) throws Exception {
        Optional<Recipe> optional = recipeRepository.findById(recipeid);
        Recipe recipe = optional.orElseThrow(() -> new Exception("service.Recipe_NOT_FOUND"));
        RecipeDTO recipe2 = new RecipeDTO();
        recipe2 = RecipeDTO.valueOf(recipe);
        return recipe2;
    }

    /**
     * will add new Recipe
     *
     * @param recipe
     * @throws Exception
     */
    public Integer addRecipe(RecipeDTO recipe) throws Exception {
        Recipe recipeEntity = recipe.createEntity();
        Recipe recipeEntity2 = recipeRepository.save(recipeEntity);
        return recipeEntity2.getRecipeid();
    }


    /**
     * will Delete Recipe
     *
     * @param recipeid
     * @return null value
     * @throws Exception
     */
    public List<Recipe> deleteRecipe(Integer recipeid) throws Exception {
        Optional<Recipe> recipe = recipeRepository.findById(recipeid);
        recipe.orElseThrow(() -> new Exception("service.Recipe_NOT_FOUND"));
        recipeRepository.deleteById(recipeid);
        return null;
    }

    /**
     * will Update Recipe Information
     *
     * @param recipeDTO
     * @return Recipe
     * @throws Exception
     */
    public Recipe updateRecipe(RecipeDTO recipeDTO) throws Exception {
        Recipe recipe = recipeDTO.createEntity();
        recipe = recipeRepository.save(recipe);
        return recipe;
    }

    /**
     * will get Recipe By Recipe Type i.e; veg or non-veg
     *
     * @param recipetype
     * @return list of RecipeDTO
     */
    public List<RecipeDTO> getByRecipetype(String recipetype) {

        List<Recipe> recipes = recipeRepository.getByRecipetype(recipetype);
        List<RecipeDTO> recipeDTOs = new ArrayList<RecipeDTO>();
        for (Recipe recipe : recipes) {
            RecipeDTO recipeDTO = RecipeDTO.valueOf(recipe);
            recipeDTOs.add(recipeDTO);
        }
        return recipeDTOs;
    }

    /**
     * will get Recipe By number of servings
     *
     * @param serve
     * @return list of RecipeDTO
     */
    public List<RecipeDTO> getByServe(Integer serve) {

        List<Recipe> recipes = recipeRepository.getByServe(serve);
        List<RecipeDTO> recipeDTOs = new ArrayList<RecipeDTO>();
        for (Recipe recipe : recipes) {
            RecipeDTO recipeDTO = RecipeDTO.valueOf(recipe);
            recipeDTOs.add(recipeDTO);
        }
        return recipeDTOs;
    }

    /**
     * will search recipe by ingredients and number of servings
     *
     * @param ingredients
     * @param serve
     * @return List of Recipe
     * @throws RecipedemoException
     */
    public List<Recipe> searchRecipe(String ingredients, Integer serve) throws RecipedemoException {
        List<Recipe> searchRecipe = recipeRepository.findAll();
        List<Recipe> recipes = new ArrayList<>();
        if (!searchRecipe.isEmpty()) {
            for (int i = 0; i < searchRecipe.size(); i++) {
                Recipe recipe = searchRecipe.get(i);
                if (recipe.getIngredients() != null) {
                    if (recipe.getIngredients().contains(ingredients) && recipe.getServe() == serve) {
                        recipes.add(recipe);
                    }
                    System.out.println("outside ifloop" + recipes);
                }
            }
            return recipes;
        } else {
            throw new RecipedemoException("Recipe not found");
        }
    }


    public List<Recipe> findRecipe(String ingredients, String instructions) throws RecipedemoException {
        List<Recipe> searchRecipe = recipeRepository.findAll();
        List<Recipe> recipes = new ArrayList<>();
        if (!searchRecipe.isEmpty()) {
            for (int i = 0; i < searchRecipe.size(); i++) {
                Recipe recipe = searchRecipe.get(i);
                if (recipe.getIngredients() != null) {
                    if (recipe.getIngredients().contains(ingredients) || recipe.getInstructions().contains(instructions)) {
                        recipes.add(recipe);
                    }
                    else if
                        (!recipe.getIngredients().contains(ingredients) || !recipe.getInstructions().contains(instructions))

                    System.out.println("outside ifloop" + recipes);
                }
            }
            return recipes;
        } else {
            throw new RecipedemoException("Recipe not found");
        }
    }
}







