package manhar.laziaf.springrecipeapp.services;

import lombok.extern.slf4j.Slf4j;
import manhar.laziaf.springrecipeapp.domain.Recipe;
import manhar.laziaf.springrecipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService
{
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository)
    {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipeSet()
    {
        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    @Override
    public Recipe findById(Long recipeId)
    {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(recipeOptional.isEmpty())
        {
            throw new RuntimeException("Recipe not found");
        }

        return recipeOptional.get();

    }
}
