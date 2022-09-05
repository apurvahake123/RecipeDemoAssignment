package com.example.Recipe.Recipedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table
@Builder
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer recipeid;
    String recipename;
    String recipetype;
    Integer serve;
    String ingredients;
    String instructions;

    public Recipe() {

    }

    public Integer getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(Integer recipeid) {
        this.recipeid = recipeid;
    }

    public String getRecipename() {
        return recipename;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public String getRecipetype() {
        return recipetype;
    }

    public void setRecipetype(String recipetype) {
        this.recipetype = recipetype;
    }

    public Integer getServe() {
        return serve;
    }

    public void setServe(Integer serve) {
        this.serve = serve;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeid=" + recipeid +
                ", recipename='" + recipename + '\'' +
                ", recipetype='" + recipetype + '\'' +
                ", serve=" + serve +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
