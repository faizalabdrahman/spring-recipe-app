package manhar.laziaf.springrecipeapp.repositories;

import manhar.laziaf.springrecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long>
{
    Optional<Recipe> findByDescription(String description);
}
