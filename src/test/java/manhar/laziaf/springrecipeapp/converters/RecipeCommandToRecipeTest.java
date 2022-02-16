package manhar.laziaf.springrecipeapp.converters;

import manhar.laziaf.springrecipeapp.commands.CategoryCommand;
import manhar.laziaf.springrecipeapp.commands.IngredientCommand;
import manhar.laziaf.springrecipeapp.commands.NotesCommand;
import manhar.laziaf.springrecipeapp.commands.RecipeCommand;
import manhar.laziaf.springrecipeapp.domain.Difficulty;
import manhar.laziaf.springrecipeapp.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeCommandToRecipeTest
{
    private static final Long RECIPE_CMD_ID_VALUE = 1L;
    private static final String DESCRIPTION = "description";
    private static final Integer PREPTIME = 10;
    private static final Integer COOKTIME = 20;
    private static final Integer SERVINGS = 5;
    private static final String SOURCE = "source";
    private static final String URL = "url";
    private static final String DIRECTIONS = "directions";
    private static final Difficulty DIFFICULTY = Difficulty.EASY;
    private static final Long INGREDIENT_CMD_ID_VALUE_1 = 1L;
    private static final Long INGREDIENT_CMD_ID_VALUE_2 = 2L;
    private static final Long NOTES_CMD_ID_VALUE = 1L;
    private static final Long CATEGORY_CMD_ID_VALUE_1 = 1L;
    private static final Long CATEGORY_CMD_ID_VALUE_2 = 2L;

    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    public void setUp()
    {
        recipeCommandToRecipe = new RecipeCommandToRecipe(
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes(),
                new CategoryCommandToCategory());
    }

    @Test
    public void nullObjectTest()
    {
        assertNull(recipeCommandToRecipe.convert(null));
    }

    @Test
    public void emptyObjectTest()
    {
        assertNotNull(recipeCommandToRecipe.convert(new RecipeCommand()));
    }

    @Test
    public void convert()
    {
        // given
        IngredientCommand ingredientCommand1 = new IngredientCommand();
        ingredientCommand1.setId(INGREDIENT_CMD_ID_VALUE_1);

        IngredientCommand ingredientCommand2 = new IngredientCommand();
        ingredientCommand2.setId(INGREDIENT_CMD_ID_VALUE_2);

        Set<IngredientCommand> ingredientSet = new HashSet<>();
        ingredientSet.add(ingredientCommand1);
        ingredientSet.add(ingredientCommand2);

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(NOTES_CMD_ID_VALUE);

        CategoryCommand categoryCommand1 = new CategoryCommand();
        categoryCommand1.setId(CATEGORY_CMD_ID_VALUE_1);

        CategoryCommand categoryCommand2 = new CategoryCommand();
        categoryCommand2.setId(CATEGORY_CMD_ID_VALUE_2);

        Set<CategoryCommand> categorySet = new HashSet<>();
        categorySet.add(categoryCommand1);
        categorySet.add(categoryCommand2);

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(RECIPE_CMD_ID_VALUE);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setPrepTime(PREPTIME);
        recipeCommand.setCookTime(COOKTIME);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setIngredientSet(ingredientSet);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setNotes(notesCommand);
        recipeCommand.setCategorySet(categorySet);

        // when
        Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);

        // then
        assertEquals(RECIPE_CMD_ID_VALUE, recipe.getId());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(PREPTIME, recipe.getPrepTime());
        assertEquals(COOKTIME, recipe.getCookTime());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(2, recipe.getIngredientSet().size());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(NOTES_CMD_ID_VALUE, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategorySet().size());
    }
}