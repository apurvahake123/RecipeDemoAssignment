package com.example.Recipe.Recipedemo.controller;

import com.example.Recipe.Recipedemo.dto.RecipeDTO;
import com.example.Recipe.Recipedemo.repository.RecipeRepository;
import com.example.Recipe.Recipedemo.entity.Recipe;
import com.example.Recipe.Recipedemo.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class RecipeController {

    //   Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    Environment environment;


    @Operation(summary = "Get Recipes", description = "Get list of recipes", tags = "Get")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Recipe",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RecipeDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Recipes not found", content = @Content)
    })

    //All recipe details will display here

    @GetMapping(value = "/recipe")
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() throws Exception {
        List<RecipeDTO> recipeList = recipeService.getAllRecipes();
        log.info("Get all recipes");
        return new ResponseEntity<>(recipeList, HttpStatus.OK);
    }


    @Operation(summary = "Get Recipe details by id", description = "Get recipe by id", tags = "Get")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Recipe by id",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RecipeDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Recipes not found", content = @Content)
    })

    // here we will get recipe by recipeid
    @GetMapping(value = "/recipe/{recipeid}")
    public ResponseEntity<RecipeDTO> getRecipe(@PathVariable Integer recipeid) throws Exception {
        RecipeDTO recipe = recipeService.getRecipe(recipeid);
        log.info("Get recipe by id");
        log.error("recipe not found");
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }


    @Operation(summary = "Add Recipes", description = "Add recipes", tags = "Post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipe added",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RecipeDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Recipes not added", content = @Content)
    })


    //here we will add  all the recipes
    @PostMapping(value = "/recipe")
    public ResponseEntity<String> addRecipe(@RequestBody RecipeDTO recipe) throws Exception {
        Integer recipeid = recipeService.addRecipe(recipe);
        String successMessage = environment.getProperty("API.INSERT_SUCCESS");
        log.info("Add all recipes");
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }


    @Operation(summary = "Delete Recipes", description = "Delete recipes", tags = "Delete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipe deleted",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RecipeDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Recipes not deleted", content = @Content)
    })

    //recipes will delete by recipeid
    @DeleteMapping(value = "/recipe/{recipeid}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Integer recipeid) throws Exception {
        recipeService.deleteRecipe(recipeid);
        String successMessage = environment.getProperty("API.DELETE_SUCCESS");
        log.info("Delete recipe by id");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }


    @Operation(summary = "Update Recipes", description = "Update recipes", tags = "Put")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipe updated",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RecipeDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Recipes not updated", content = @Content)
    })

    //recipes will update by recipeid
    @PutMapping(value = "/recipe/{recipeid}")
    public ResponseEntity<String> updateRecipe(@PathVariable Integer recipeid, @RequestBody RecipeDTO recipe)
            throws Exception {
        RecipeDTO recipe1 = recipeService.getRecipe(recipeid);
        recipe1 = recipe;
        final Recipe updatedRecipe = recipeService.updateRecipe(recipe1);
        String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
        log.info("update recipe by id");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }


    @Operation(summary = "Get recipes", description = "get recipe by recipetype", tags = "Get")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipe found by recipetype",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RecipeDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Recipes not found ", content = @Content)
    })

    //will get recipes by recipetype
    @GetMapping(value = "/recipes/{recipetype}")
    public ResponseEntity<List<RecipeDTO>> getByRecipetype(@PathVariable String recipetype) throws Exception {
        List<RecipeDTO> recipeDTOList = recipeService.getByRecipetype(recipetype);
        log.info("recipe found by recipetype");
        return new ResponseEntity<>(recipeDTOList, HttpStatus.OK);
    }


    @Operation(summary = "Get recipes", description = "get recipe by serve", tags = "Get")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipe found by serve",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RecipeDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Recipes not found", content = @Content)
    })

    //get recipe by capacity of serve
    @GetMapping(value = "/recipesServe/{serve}")
    public ResponseEntity<List<RecipeDTO>> getByServe(@PathVariable Integer serve) throws Exception {
        List<RecipeDTO> recipeDTOList = recipeService.getByServe(serve);
        log.info("recipe found by recipeServe");
        log.error("recipe not found");
        return new ResponseEntity<>(recipeDTOList, HttpStatus.OK);
    }
}









