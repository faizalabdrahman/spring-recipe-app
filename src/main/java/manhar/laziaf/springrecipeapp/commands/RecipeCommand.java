package manhar.laziaf.springrecipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import manhar.laziaf.springrecipeapp.domain.Difficulty;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand
{
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredientCommandSet = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NotesCommand notesCommand;
    private Set<CategoryCommand> categoryCommandSet = new HashSet<>();
}
