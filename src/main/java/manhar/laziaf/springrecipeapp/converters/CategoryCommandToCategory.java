package manhar.laziaf.springrecipeapp.converters;

import lombok.Synchronized;
import manhar.laziaf.springrecipeapp.commands.CategoryCommand;
import manhar.laziaf.springrecipeapp.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>
{
    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand categoryCommand)
    {
        if(categoryCommand == null)
        {
            return null;
        }

        final Category category = new Category();
        category.setId(categoryCommand.getId());
        category.setDescription(categoryCommand.getDescription());

        return category;
    }
}
