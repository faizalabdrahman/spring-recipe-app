package manhar.laziaf.springrecipeapp.converters;

import manhar.laziaf.springrecipeapp.commands.CategoryCommand;
import manhar.laziaf.springrecipeapp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryToCategoryCommandTest
{
    private static final Long ID_VALUE = 1L;
    private static final String DESCRIPTION = "description";

    CategoryToCategoryCommand categoryToCategoryCommand;

    @BeforeEach
    public void setUp()
    {
        categoryToCategoryCommand = new CategoryToCategoryCommand();
    }

    @Test
    public void nullObjectTest()
    {
        assertNull(categoryToCategoryCommand.convert(null));
    }

    @Test
    public void emptyObjectTest()
    {
        assertNotNull(categoryToCategoryCommand.convert(new Category()));
    }

    @Test
    public void convert()
    {
        // given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        // when
        CategoryCommand categoryCommand = categoryToCategoryCommand.convert(category);

        // then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());
    }
}