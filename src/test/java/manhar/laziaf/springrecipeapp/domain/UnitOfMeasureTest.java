package manhar.laziaf.springrecipeapp.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitOfMeasureTest
{
    UnitOfMeasure unitOfMeasure;

    @BeforeEach
    public void setUp()
    {
        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);
        unitOfMeasure.setDescription("Teaspoon");
    }

    @Test
    public void getId()
    {
        assertEquals(1L, unitOfMeasure.getId());
    }

    @Test
    public void getDescription()
    {
        assertEquals("Teaspoon", unitOfMeasure.getDescription());
    }
}