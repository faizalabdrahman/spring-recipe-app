package manhar.laziaf.springrecipeapp.services;

import manhar.laziaf.springrecipeapp.domain.Recipe;
import manhar.laziaf.springrecipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest
{
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipeSet()
    {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe());

        when(recipeService.getRecipeSet()).thenReturn(recipeSet);

        assertEquals(1, recipeService.getRecipeSet().size());
        verify(recipeRepository, times(1)).findAll();

    }

    @Test
    public void findById()
    {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull(recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());

    }
}