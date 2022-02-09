package manhar.laziaf.springrecipeapp.repositories;

import manhar.laziaf.springrecipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>
{
}
