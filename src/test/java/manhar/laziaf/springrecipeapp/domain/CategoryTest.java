package manhar.laziaf.springrecipeapp.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest
{
    Category category;

    @BeforeEach
    public void setUp()
    {
        category = new Category();
        category.setId(1L);
        category.setDescription("American");

    }

    @Test
    public void getId()
    {
        assertEquals(1L, category.getId());
    }

    @Test
    public void getDescription()
    {
        assertEquals("American", category.getDescription());
    }

    @Test
    public void getRecipeSet()
    {

    }
}