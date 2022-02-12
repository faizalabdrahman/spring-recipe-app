package manhar.laziaf.springrecipeapp.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest
{
    Recipe recipe;

    @BeforeEach
    public void setUp()
    {
        recipe = new Recipe();
        recipe.setId(1L);
        recipe.setDescription("Oatmeal Bread");
        recipe.setPrepTime(10);
        recipe.setCookTime(20);
        recipe.setServings(5);
        recipe.setSource("This is source");
        recipe.setUrl("This is url");
        recipe.setDirections("This are directions");
        recipe.getIngredientSet().add(new Ingredient());
    }

    @Test
    public void getId()
    {
        assertEquals(1L, recipe.getId());
    }

    @Test
    public void getDescription()
    {
        assertEquals("Oatmeal Bread", recipe.getDescription());
    }

    @Test
    public void getPrepTime()
    {
        assertEquals(10, recipe.getPrepTime());
    }

    @Test
    public void getCookTime()
    {
        assertEquals(20, recipe.getCookTime());
    }

    @Test
    public void getServings()
    {
        assertEquals(5, recipe.getServings());
    }

    @Test
    public void getSource()
    {
        assertEquals("This is source", recipe.getSource());
    }

    @Test
    public void getUrl()
    {
        assertEquals("This is url", recipe.getUrl());
    }

    @Test
    public void getDirections()
    {
        assertEquals("This are directions", recipe.getDirections());
    }

    @Test
    public void getIngredientSet()
    {
        assertEquals(1, recipe.getIngredientSet().size());
    }
}