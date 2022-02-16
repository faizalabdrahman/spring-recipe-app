package manhar.laziaf.springrecipeapp.converters;

import lombok.Synchronized;
import manhar.laziaf.springrecipeapp.commands.RecipeCommand;
import manhar.laziaf.springrecipeapp.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe>
{
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final NotesCommandToNotes notesCommandToNotes;
    private final CategoryCommandToCategory categoryCommandToCategory;

    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientCommandToIngredient,
                                 NotesCommandToNotes notesCommandToNotes,
                                 CategoryCommandToCategory categoryCommandToCategory)
    {
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.notesCommandToNotes = notesCommandToNotes;
        this.categoryCommandToCategory = categoryCommandToCategory;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand)
    {
        if(recipeCommand == null)
        {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setServings(recipeCommand.getServings());
        recipe.setSource(recipeCommand.getSource());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setDirections(recipeCommand.getDirections());

        if(recipeCommand.getIngredientCommandSet() != null && recipeCommand.getIngredientCommandSet().size() > 0)
        {
            recipeCommand.getIngredientCommandSet().forEach(ingredientCommand ->
                    recipe.getIngredientSet().add(ingredientCommandToIngredient.convert(ingredientCommand)));
        }

        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setNotes(notesCommandToNotes.convert(recipeCommand.getNotesCommand()));

        if(recipeCommand.getCategoryCommandSet() != null && recipeCommand.getCategoryCommandSet().size() > 0)
        {
            recipeCommand.getCategoryCommandSet().forEach(categoryCommand ->
                    recipe.getCategorySet().add(categoryCommandToCategory.convert(categoryCommand)));
        }

        return recipe;
    }
}
