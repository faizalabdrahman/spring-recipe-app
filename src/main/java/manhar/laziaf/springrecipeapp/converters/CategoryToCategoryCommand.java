package manhar.laziaf.springrecipeapp.converters;

import lombok.Synchronized;
import manhar.laziaf.springrecipeapp.commands.CategoryCommand;
import manhar.laziaf.springrecipeapp.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand>
{
    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category category)
    {
        if(category == null)
        {
            return null;
        }

        final CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(category.getId());
        categoryCommand.setDescription(category.getDescription());

        return categoryCommand;
    }
}
