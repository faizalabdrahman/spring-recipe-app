package manhar.laziaf.springrecipeapp.converters;

import manhar.laziaf.springrecipeapp.commands.IngredientCommand;
import manhar.laziaf.springrecipeapp.commands.UnitOfMeasureCommand;
import manhar.laziaf.springrecipeapp.domain.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientCommandToIngredientTest
{
    private static final Long INGREDIENT_CMD_ID_VALUE = 1L;
    private static final Long UOM_CMD_ID_VALUE = 2L;
    private static final String DESCRIPTION = "description";
    private static final BigDecimal AMOUNT = new BigDecimal(1);

    IngredientCommandToIngredient ingredientCommandToIngredient;

    @BeforeEach
    public void setUp()
    {
        ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void nullObjectTest()
    {
        assertNull(ingredientCommandToIngredient.convert(null));
    }

    @Test
    public void emptyObjectTest()
    {
        assertNotNull(ingredientCommandToIngredient.convert(new IngredientCommand()));
    }

    @Test
    public void convertNullUnitOfMeasureCommand()
    {
        // given
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(INGREDIENT_CMD_ID_VALUE);
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setAmount(AMOUNT);

        // when
        Ingredient ingredient = ingredientCommandToIngredient.convert(ingredientCommand);

        // then
        assertEquals(INGREDIENT_CMD_ID_VALUE, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertNull(ingredient.getUnitOfMeasure());
    }

    @Test
    public void convert()
    {
        // given
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_CMD_ID_VALUE);

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(INGREDIENT_CMD_ID_VALUE);
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setAmount(AMOUNT);
        ingredientCommand.setUnitOfMeasure(unitOfMeasureCommand);

        // when
        Ingredient ingredient = ingredientCommandToIngredient.convert(ingredientCommand);

        // then
        assertEquals(INGREDIENT_CMD_ID_VALUE, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(UOM_CMD_ID_VALUE, ingredient.getUnitOfMeasure().getId());
    }
}