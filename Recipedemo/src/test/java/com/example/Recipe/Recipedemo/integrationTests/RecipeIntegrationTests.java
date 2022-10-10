package com.example.Recipe.Recipedemo.integrationTests;
import com.example.Recipe.Recipedemo.RecipedemoApplication;
import com.example.Recipe.Recipedemo.dto.RecipeDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RecipedemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class RecipeIntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }
    @Test
    public void contextLoads() {

    }

    @Test
    public void testGetAllRecipes() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/recipe",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetRecipeById() {
        RecipeDTO recipeDTO = restTemplate.getForObject(getRootUrl() + "/recipe/21", RecipeDTO.class);
        System.out.println(recipeDTO.getRecipename());
        assertNotNull(recipeDTO);
    }


    @Test
    public void testUpdateRecipe() {
        int recipeid = 2;
        RecipeDTO recipeDTO = restTemplate.getForObject(getRootUrl() + "/recipe/" + recipeid, RecipeDTO.class);
        recipeDTO.setRecipename("Suji Halwa");
        recipeDTO.setServe(6);
        restTemplate.put(getRootUrl() +  "/recipe/" + recipeid, recipeDTO);
        RecipeDTO updatedRecipe = restTemplate.getForObject(getRootUrl() + "/recipe/" + recipeid, RecipeDTO.class);
        assertNotNull(updatedRecipe);
    }

    @Test
    public void testDeleteRecipe() {
        int recipeid = 14;
        RecipeDTO recipeDTO = restTemplate.getForObject(getRootUrl() + "/recipe/" + recipeid, RecipeDTO.class);
        assertNotNull(recipeDTO);
        restTemplate.delete(getRootUrl() + "/recipe/" + recipeid);
        try {
            recipeDTO = restTemplate.getForObject(getRootUrl() + "/recipe/" + recipeid, RecipeDTO.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
    }
