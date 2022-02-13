package manhar.laziaf.springrecipeapp.services;

import manhar.laziaf.springrecipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService
{
    Set<Recipe> getRecipeSet();

    Recipe findById(Long recipeId);
}
