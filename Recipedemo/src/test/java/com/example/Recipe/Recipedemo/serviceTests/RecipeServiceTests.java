package com.example.Recipe.Recipedemo.serviceTests;

import com.example.Recipe.Recipedemo.dto.RecipeDTO;
import com.example.Recipe.Recipedemo.entity.Recipe;
import com.example.Recipe.Recipedemo.repository.RecipeRepository;
import com.example.Recipe.Recipedemo.service.RecipeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTests {
    @Mock
    RecipeRepository recipeRepository;
    RecipeServiceImpl recipeService;

    @BeforeEach
    void initUse() {
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void addRecipeTests() throws Exception {
        Recipe recipe1 = new Recipe();
        recipe1.setRecipeid(1);
        recipe1.setRecipename("Tandoori chicken");
        recipe1.setRecipetype("non veg");
        recipe1.setServe(4);
        recipe1.setIngredients("chicken");
        recipe1.setInstructions("cook");

        when(recipeRepository.save(any(Recipe.class))).thenReturn(recipe1);
        Recipe savedRecipe = recipeRepository.save(recipe1);
        assertThat(savedRecipe.getRecipeid()).isNotNull();
    }

    @Test
    public void listRecipeTests() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setRecipeid(1);
        recipe.setRecipename("Tandoori chicken");
        recipe.setRecipetype("non veg");
        recipe.setServe(4);
        recipe.setIngredients("chicken");
        recipe.setInstructions("cook");

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipeList);
        List<RecipeDTO> recipeDTO = recipeService.getAllRecipes();
        assertThat(recipeDTO.size()).isGreaterThan(0);
    }

    @Test
    public void updateRecipeTests() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setRecipeid(1);
        recipe.setRecipename("Tandoori chicken");
        recipe.setRecipetype("non veg");
        recipe.setServe(4);
        recipe.setIngredients("chicken");
        recipe.setInstructions("cook");

        when(recipeRepository.save(any(Recipe.class))).thenReturn(recipe);
        Recipe updateRecipe = recipeRepository.save(recipe);
        assertThat(updateRecipe.getRecipename()).isNotNull();

    }

    @Test
    public void deleteRecipeTests() throws Exception {
        Assertions.assertThrows(Exception.class, () -> {
            List<Recipe> fetchedRecipes = recipeService.deleteRecipe(3);
            assertThat(fetchedRecipes.size()).isGreaterThan(0);
        });
    }
}


