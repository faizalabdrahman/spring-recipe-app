package manhar.laziaf.springrecipeapp.converters;

import manhar.laziaf.springrecipeapp.commands.CategoryCommand;
import manhar.laziaf.springrecipeapp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryCommandToCategoryTest
{
    private static final Long ID_VALUE = 1L;
    private static final String DESCRIPTION = "description";

    CategoryCommandToCategory categoryCommandToCategory;

    @BeforeEach
    public void setUp()
    {
        categoryCommandToCategory = new CategoryCommandToCategory();
    }

    @Test
    public void nullObjectTest()
    {
        assertNull(categoryCommandToCategory.convert(null));
    }

    @Test
    public void emptyObjectTest()
    {
        assertNotNull(categoryCommandToCategory.convert(new CategoryCommand()));
    }

    @Test
    public void convert()
    {
        // given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        // when
        Category category = categoryCommandToCategory.convert(categoryCommand);

        // then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}