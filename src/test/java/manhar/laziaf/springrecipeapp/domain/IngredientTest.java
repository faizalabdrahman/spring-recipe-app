package manhar.laziaf.springrecipeapp.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IngredientTest
{
    Ingredient ingredient;

    @BeforeEach
    public void setUp()
    {
        ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setDescription("lemons");
        ingredient.setAmount(new BigDecimal(2));
        ingredient.setUnitOfMeasure(new UnitOfMeasure());
        ingredient.setRecipe(new Recipe());
    }

    @Test
    public void getId()
    {
        assertEquals(1L, ingredient.getId());
    }

    @Test
    public void getDescription()
    {
        assertEquals("lemons", ingredient.getDescription());
    }

    @Test
    public void getAmount()
    {
        assertEquals(new BigDecimal(2), ingredient.getAmount());
    }

    @Test
    public void getUnitOfMeasure()
    {
        assertNotNull(ingredient.getUnitOfMeasure());
    }

    @Test
    public void getRecipe()
    {
        assertNotNull(ingredient.getRecipe());
    }
}