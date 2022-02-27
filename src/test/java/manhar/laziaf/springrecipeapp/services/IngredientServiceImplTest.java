package manhar.laziaf.springrecipeapp.services;

import manhar.laziaf.springrecipeapp.commands.IngredientCommand;
import manhar.laziaf.springrecipeapp.converters.IngredientCommandToIngredient;
import manhar.laziaf.springrecipeapp.converters.IngredientToIngredientCommand;
import manhar.laziaf.springrecipeapp.converters.UnitOfMeasureCommandToUnitOfMeasure;
import manhar.laziaf.springrecipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import manhar.laziaf.springrecipeapp.domain.Ingredient;
import manhar.laziaf.springrecipeapp.domain.Recipe;
import manhar.laziaf.springrecipeapp.repositories.RecipeRepository;
import manhar.laziaf.springrecipeapp.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest
{
    @Mock
    RecipeRepository recipeRepository;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    IngredientService ingredientService;

    public IngredientServiceImplTest()
    {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);

        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, ingredientCommandToIngredient,
                recipeRepository, unitOfMeasureRepository);
    }

    @Test
    public void findByRecipeIdAndIngredientId()
    {
        // given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        // when
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        // then
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 2L);

        assertEquals(1L, ingredientCommand.getRecipeId());
        assertEquals(2L, ingredientCommand.getId());
        verify(recipeRepository, times(1)).findById(anyLong());
    }

    @Test
    public void savedIngredientCommand()
    {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(1L);
        ingredientCommand.setRecipeId(2L);

        Optional<Recipe> optionalRecipe = Optional.of(new Recipe());

        Recipe savedRecipe = new Recipe();
        savedRecipe.addIngredient(new Ingredient());
        savedRecipe.getIngredientSet().iterator().next().setId(1L);

        // when
        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);
        when(recipeRepository.save(any())).thenReturn(savedRecipe);

        IngredientCommand savedIngredientCommand = ingredientService.saveIngredientCommand(ingredientCommand);

        // then
        assertEquals(1L, savedIngredientCommand.getId());
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }

    @Test
    public void deleteById()
    {
        // given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(2L);
        ingredient.setRecipe(recipe);

        recipe.addIngredient(ingredient);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        // when
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        ingredientService.deleteById(1L, 2L);

        // then
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }

}