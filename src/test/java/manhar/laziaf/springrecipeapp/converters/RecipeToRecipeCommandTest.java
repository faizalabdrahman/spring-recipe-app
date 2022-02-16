package manhar.laziaf.springrecipeapp.converters;

import manhar.laziaf.springrecipeapp.commands.RecipeCommand;
import manhar.laziaf.springrecipeapp.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeToRecipeCommandTest
{
    private static final Long RECIPE_ID_VALUE = 1L;
    private static final String DESCRIPTION = "description";
    private static final Integer PREPTIME = 10;
    private static final Integer COOKTIME = 20;
    private static final Integer SERVINGS = 5;
    private static final String SOURCE = "source";
    private static final String URL = "url";
    private static final String DIRECTIONS = "directions";
    private static final Difficulty DIFFICULTY = Difficulty.EASY;
    private static final Long INGREDIENT_ID_VALUE_1 = 1L;
    private static final Long INGREDIENT_ID_VALUE_2 = 2L;
    private static final Long NOTES_ID_VALUE = 1L;
    private static final Long CATEGORY_ID_VALUE_1 = 1L;
    private static final Long CATEGORY_ID_VALUE_2 = 2L;

    RecipeToRecipeCommand recipeToRecipeCommand;

    @BeforeEach
    public void setUp()
    {
        recipeToRecipeCommand = new RecipeToRecipeCommand(
                new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
                new NotesToNotesCommand(),
                new CategoryToCategoryCommand());
    }

    @Test
    public void nullObjectTest()
    {
        assertNull(recipeToRecipeCommand.convert(null));
    }

    @Test
    public void emptyObjectTest()
    {
        assertNotNull(recipeToRecipeCommand.convert(new Recipe()));
    }

    @Test
    public void convert()
    {
        // given
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(INGREDIENT_ID_VALUE_1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(INGREDIENT_ID_VALUE_2);

        Set<Ingredient> ingredientSet = new HashSet<>();
        ingredientSet.add(ingredient1);
        ingredientSet.add(ingredient2);

        Notes notes = new Notes();
        notes.setId(NOTES_ID_VALUE);

        Category category1 = new Category();
        category1.setId(CATEGORY_ID_VALUE_1);

        Category category2 = new Category();
        category2.setId(CATEGORY_ID_VALUE_2);

        Set<Category> categorySet = new HashSet<>();
        categorySet.add(category1);
        categorySet.add(category2);

        Recipe recipe = new Recipe();
        recipe.setId(RECIPE_ID_VALUE);
        recipe.setDescription(DESCRIPTION);
        recipe.setPrepTime(PREPTIME);
        recipe.setCookTime(COOKTIME);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);
        recipe.setDirections(DIRECTIONS);
        recipe.setIngredientSet(ingredientSet);
        recipe.setDifficulty(DIFFICULTY);
        recipe.setNotes(notes);
        recipe.setCategorySet(categorySet);

        // when
        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);

        // then
        assertEquals(RECIPE_ID_VALUE, recipeCommand.getId());
        assertEquals(DESCRIPTION, recipeCommand.getDescription());
        assertEquals(PREPTIME, recipeCommand.getPrepTime());
        assertEquals(COOKTIME, recipeCommand.getCookTime());
        assertEquals(SERVINGS, recipeCommand.getServings());
        assertEquals(SOURCE, recipeCommand.getSource());
        assertEquals(URL, recipeCommand.getUrl());
        assertEquals(DIRECTIONS, recipeCommand.getDirections());
        assertEquals(2, recipeCommand.getIngredientCommandSet().size());
        assertEquals(DIFFICULTY, recipeCommand.getDifficulty());
        assertEquals(NOTES_ID_VALUE, recipeCommand.getNotesCommand().getId());
        assertEquals(2, recipeCommand.getCategoryCommandSet().size());
    }
}