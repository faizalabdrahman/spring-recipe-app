package manhar.laziaf.springrecipeapp.converters;

import lombok.Synchronized;
import manhar.laziaf.springrecipeapp.commands.RecipeCommand;
import manhar.laziaf.springrecipeapp.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand>
{
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final NotesToNotesCommand notesToNotesCommand;
    private final CategoryToCategoryCommand categoryToCategoryCommand;

    public RecipeToRecipeCommand(IngredientToIngredientCommand ingredientToIngredientCommand,
                                 NotesToNotesCommand notesToNotesCommand,
                                 CategoryToCategoryCommand categoryToCategoryCommand)
    {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.notesToNotesCommand = notesToNotesCommand;
        this.categoryToCategoryCommand = categoryToCategoryCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe)
    {
        if(recipe == null)
        {
            return null;
        }

        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(recipe.getId());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setUrl(recipe.getUrl());
        recipeCommand.setDirections(recipe.getDirections());

        if(recipe.getIngredientSet() != null && recipe.getIngredientSet().size() > 0)
        {
            recipe.getIngredientSet().forEach(ingredient ->
                    recipeCommand.getIngredientSet().add(ingredientToIngredientCommand.convert(ingredient)));
        }

        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setNotes(notesToNotesCommand.convert(recipe.getNotes()));

        if(recipe.getCategorySet() != null && recipe.getCategorySet().size() > 0)
        {
            recipe.getCategorySet().forEach(category ->
                    recipeCommand.getCategorySet().add(categoryToCategoryCommand.convert(category)));
        }

        return recipeCommand;
    }
}
