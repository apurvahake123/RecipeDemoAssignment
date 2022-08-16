/*package com.example.Recipe.Recipedemo;


import com.example.Recipe.Recipedemo.Controller.RecipeController;
import com.example.Recipe.Recipedemo.DTO.RecipeDTO;
import com.example.Recipe.Recipedemo.Repository.RecipeRepository;
import com.example.Recipe.Recipedemo.Service.RecipeService;
import com.example.Recipe.Recipedemo.entity.Recipe;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ListAllRecipesTest {
    @MockBean
    RecipeRepository recipeRepository;
    @InjectMocks
    RecipeService recipeService;

    public <Recipedemo> void shouldReturnAllRecipes() {
        List<RecipedemoApplication> recipesDemo = new ArrayList<>();
        recipesDemo.add(new RecipedemoApplication());
        given(recipeRepository.findAll()).willReturn(recipesDemo);
        List<RecipeDTO> expected = recipeService.getAllRecipes();
        assertEquals(expected, recipesDemo);
        verify(recipeRepository).findAll();
    }
    @InjectMocks
    private RecipeController recipeController;

}*/