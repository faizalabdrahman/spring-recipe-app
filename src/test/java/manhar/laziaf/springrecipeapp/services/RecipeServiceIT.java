package manhar.laziaf.springrecipeapp.services;


import manhar.laziaf.springrecipeapp.commands.RecipeCommand;
import manhar.laziaf.springrecipeapp.converters.RecipeCommandToRecipe;
import manhar.laziaf.springrecipeapp.converters.RecipeToRecipeCommand;
import manhar.laziaf.springrecipeapp.domain.Recipe;
import manhar.laziaf.springrecipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecipeServiceIT
{
    private static final String DESCRIPTION = "description";

    @Autowired
    RecipeServiceImpl recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Test
    @Transactional
    public void savedRecipeCommand()
    {
        // given
        Iterable<Recipe> recipeIterable = recipeRepository.findAll();
        Recipe recipe = recipeIterable.iterator().next();
        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);

        // when
        recipeCommand.setDescription(DESCRIPTION);
        RecipeCommand savedRecipeCommand = recipeService.savedRecipeCommand(recipeCommand);

        // then
        assertEquals(DESCRIPTION, savedRecipeCommand.getDescription());
        assertEquals(recipe.getId(), savedRecipeCommand.getId());
        assertEquals(recipe.getIngredientSet().size(), recipeCommand.getIngredientSet().size());
        assertEquals(recipe.getCategorySet().size(), recipeCommand.getCategorySet().size());
    }
}
