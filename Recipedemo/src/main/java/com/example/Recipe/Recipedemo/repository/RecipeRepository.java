package com.example.Recipe.Recipedemo.repository;
import com.example.Recipe.Recipedemo.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    /**
     * @param recipetype
     * @return list of recipes according to type i.e; veg or non-veg
     */
    List<Recipe> getByRecipetype(String recipetype);

    /**
     * @param serve
     * @return list of recipes according to number of servings
     */
    List<Recipe> getByServe(Integer serve);
}
