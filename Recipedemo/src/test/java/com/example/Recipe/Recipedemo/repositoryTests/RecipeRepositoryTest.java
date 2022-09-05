package com.example.Recipe.Recipedemo.repositoryTests;

import com.example.Recipe.Recipedemo.entity.Recipe;
import com.example.Recipe.Recipedemo.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RecipeRepositoryTest {

    @Autowired
    RecipeRepository recipeRepository;

    @Test
    public void testAddRecipe() {
        Recipe savedRecipe = recipeRepository.save(new Recipe(1,"chicken tandoori","non veg",4,"chicken","cook"));

        assertThat(savedRecipe.getRecipeid()).isGreaterThan(0);
    }

    @Test
    public void testListRecipes() {
        List<Recipe> recipeList = (List<Recipe>) recipeRepository.findAll();
        assertThat(recipeList).size().isGreaterThan(0);
    }

    @Test
    public void testUpdateRecipe() {
        Optional<Recipe> recipe = recipeRepository.findById(1);
        Recipe recipe1 = new Recipe();
        recipe1.setServe(4);
        Optional<Recipe> updatedRecipe = recipeRepository.findById(1);
        assertThat(updatedRecipe.equals(recipe1));
    }

    @Test
    public void testDeleteRecipe() {
        Optional<Recipe> recipe = recipeRepository.findById(1);
        Recipe recipe1 = new Recipe();
        recipe1.setServe(4);
        Optional<Recipe> deletedRecipe = recipeRepository.findById(1);
        assertThat(deletedRecipe.equals(recipe1));
    }
}
