package com.example.Recipe.Recipedemo.Repository;
import com.example.Recipe.Recipedemo.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> getByRecipetype(String recipetype);
    List<Recipe> getByServe(Integer serve);
}

