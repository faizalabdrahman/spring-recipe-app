package manhar.laziaf.springrecipeapp.services;

import manhar.laziaf.springrecipeapp.commands.IngredientCommand;

public interface IngredientService
{
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);

    void deleteById(Long recipeId, Long ingredientId);
}
