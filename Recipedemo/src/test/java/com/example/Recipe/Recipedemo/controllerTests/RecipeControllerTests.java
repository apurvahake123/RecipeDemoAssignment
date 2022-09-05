/*com.example.Recipe.Recipedemo.controllerTests;

import com.example.Recipe.Recipedemo.controller.RecipeController;
import com.example.Recipe.Recipedemo.dto.RecipeDTO;
import com.example.Recipe.Recipedemo.entity.Recipe;
import com.example.Recipe.Recipedemo.repository.RecipeRepository;
import com.example.Recipe.Recipedemo.service.RecipeService;
import com.example.Recipe.Recipedemo.service.RecipeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.BDDAssumptions;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(RecipeController.class)
public class RecipeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    RecipeController recipeController;

    @InjectMocks
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Autowired
    RecipeDTO recipeDTO;

    private Recipe recipe;

    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        recipeDTO = new RecipeDTO(4, "chicken", "cook", 1, "chicken tandoori", "non veg");
    }


  @Test
    public void testGetRecipe() throws Exception {
        List<Recipe> recipes = new ArrayList<Recipe>();
        Recipe recipe = new Recipe();
        recipe.setRecipeid(1);
        recipe.setRecipename("Tandoori chicken");
        recipe.setRecipetype("non veg");
        recipe.setServe(4);
        recipe.setIngredients("chicken");
        recipe.setInstructions("cook");
        Mockito.when(recipeService.getRecipe(1)).thenReturn((RecipeDTO) recipes);
        mockMvc.perform(get("/getMapping")).andExpect(status().isOk()).andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].name", Matchers.equalTo("Tandoori Chicken")));
    }



      @Test
    public void testPostRecipe() throws Exception {
       Recipe recipe = new Recipe();
        recipe.setRecipeid(1);
        recipe.setRecipename("Tandoori Chicken");
        recipe.setRecipetype("non veg");
        recipe.setServe(4);
        recipe.setIngredients("chicken");
        recipe.setInstructions("cook");
       // BDDAssumptions.given(recipeService.addRecipe(any(RecipeDTO.class))).willAnswer((invocation)->invocation.getArgument(0));
        Mockito.when(recipeService.addRecipe(recipeDTO)).thenReturn(recipeDTO.getRecipeid());
        String json = mapper.writeValueAsString(recipeDTO);

        mockMvc.perform((RequestBuilder) post("/recipe").contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .contentType(MediaType.valueOf(json)).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    public void testPutRecipe() throws Exception {
        Recipe recipe = new Recipe();
       recipe.setRecipeid(1);
        recipe.setRecipename("Tandoori Chicken");
        Mockito.when(recipeService.updateRecipe(any())).thenReturn(recipe);
        String json = mapper.writeValueAsString(recipe);
        mockMvc.perform(put("/putMapping").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                        .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(2)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("John")));
    }

    @Test
    public void testDeleteRecipe() throws Exception {
        Mockito.when(recipeService.deleteRecipe(Integer.valueOf(ArgumentMatchers.anyString()))).thenReturn("Recipe is deleted");
        MvcResult requestResult = mockMvc.perform(delete("/deleteMapping").param("recipeid", "1"))
                .andExpect(status().isOk()).andExpect(status().isOk()).andReturn();
        String result = requestResult.getResponse().getContentAsString();
        assertEquals(result, "Recipe is deleted");
    }

  @Test
    public void getAllRecipeTests() throws Exception {
      List<Recipe> recipes = new ArrayList<Recipe>();
      Recipe recipe = new Recipe();
      recipe.setRecipeid(1);
      recipe.setRecipename("Tandoori chicken");
      recipe.setRecipetype("non veg");
      recipe.setServe(4);
      recipe.setIngredients("chicken");
      recipe.setInstructions("cook");
      Mockito.when(recipeService.getAllRecipes().addAll());
      mockMvc.perform(get("/getMapping")).andExpect(status().isOk().match());

}
  }

*/










