package com.example.Recipe.Recipedemo.service;

import com.example.Recipe.Recipedemo.dto.RecipeDTO;
import com.example.Recipe.Recipedemo.dto.SearchDTO;
import com.example.Recipe.Recipedemo.entity.Recipe;
import com.example.Recipe.Recipedemo.exception.RecipedemoException;
import com.example.Recipe.Recipedemo.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
     * Text Search
     *
     * @param searchDTO
     * @return recipes
     * @throws RecipedemoException
     */
    public List<RecipeDTO> searchRecipe(SearchDTO searchDTO) throws RecipedemoException {
        List<Recipe> searchRecipe = recipeRepository.findAll();
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        for (Recipe recipeDTO : searchRecipe) {
            if (searchDTO.getIngredients() != null && searchDTO.getIncludeinstruction() !=null &&
                    recipeDTO.getServe().equals(searchDTO.getServe()) &&
                    recipeDTO.getRecipetype().equals(searchDTO.getRecipetype())) {

                if (searchDTO.getIncludeingredients().equals(true) &&
                        searchDTO.getIncludeinstruction().equals(true)) {
                        if (recipeDTO.getIngredients().contains(searchDTO.getIngredients())
                              && recipeDTO.getInstructions().contains(searchDTO.getInstructions())) {
                            recipeDTOList.add(RecipeDTO.valueOf(recipeDTO));
                        }

                } else if (searchDTO.getIncludeingredients().equals(false) &&
                        searchDTO.getIncludeinstruction().equals(true)) {
                    if (!recipeDTO.getIngredients().contains(searchDTO.getIngredients())
                           && recipeDTO.getInstructions().contains(searchDTO.getInstructions())) {
                        recipeDTOList.add(RecipeDTO.valueOf(recipeDTO));
                    }
                }
                else if (searchDTO.getIncludeingredients().equals(true) &&
                        searchDTO.getIncludeinstruction().equals(false)) {
                    if (!recipeDTO.getInstructions().contains(searchDTO.getInstructions())
                            && recipeDTO.getIngredients().contains(searchDTO.getIngredients())) {
                        recipeDTOList.add(RecipeDTO.valueOf(recipeDTO));
                    }
                }
                else if (searchDTO.getIncludeingredients().equals(false) &&
                        searchDTO.getIncludeinstruction().equals(false)) {
                    if (!recipeDTO.getInstructions().contains(searchDTO.getInstructions())
                           && !recipeDTO.getIngredients().contains(searchDTO.getIngredients())) {
                        recipeDTOList.add(RecipeDTO.valueOf(recipeDTO));
                    }
                }
                else {
                    throw new RecipedemoException("Recipe not found");
                }
            }
        }
        return recipeDTOList;
    }
}

