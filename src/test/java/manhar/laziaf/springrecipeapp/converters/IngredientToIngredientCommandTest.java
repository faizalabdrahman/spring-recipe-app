package manhar.laziaf.springrecipeapp.converters;

import manhar.laziaf.springrecipeapp.commands.IngredientCommand;
import manhar.laziaf.springrecipeapp.domain.Ingredient;
import manhar.laziaf.springrecipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientToIngredientCommandTest
{
    private static final Long INGREDIENT_ID_VALUE = 1L;
    private static final Long UOM_ID_VALUE = 2L;
    private static final String DESCRIPTION = "description";
    private static final BigDecimal AMOUNT = new BigDecimal(1);

    IngredientToIngredientCommand ingredientToIngredientCommand;

    @BeforeEach
    public void setUp()
    {
        ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void nullObjectTest()
    {
        assertNull(ingredientToIngredientCommand.convert(null));
    }

    @Test
    public void emptyObjectTest()
    {
        assertNotNull(ingredientToIngredientCommand.convert(new Ingredient()));
    }

    @Test
    public void convertNullUnitOfMeasure()
    {
        // given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(INGREDIENT_ID_VALUE);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);

        // when
        IngredientCommand ingredientCommand = ingredientToIngredientCommand.convert(ingredient);

        // then
        assertEquals(INGREDIENT_ID_VALUE, ingredientCommand.getId());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertNull(ingredientCommand.getUnitOfMeasureCommand());
    }

    @Test
    public void convert()
    {
        // given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID_VALUE);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(INGREDIENT_ID_VALUE);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        ingredient.setUnitOfMeasure(unitOfMeasure);

        // when
        IngredientCommand ingredientCommand = ingredientToIngredientCommand.convert(ingredient);

        // then
        assertEquals(INGREDIENT_ID_VALUE, ingredientCommand.getId());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(UOM_ID_VALUE, ingredientCommand.getUnitOfMeasureCommand().getId());
    }
}