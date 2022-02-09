package manhar.laziaf.springrecipeapp.repositories;

import manhar.laziaf.springrecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long>
{
}
