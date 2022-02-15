package manhar.laziaf.springrecipeapp.converters;

import manhar.laziaf.springrecipeapp.commands.UnitOfMeasureCommand;
import manhar.laziaf.springrecipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest
{
    private final static Long ID_VALUE = 1L;
    private final static String DESCRIPTION = "description";

    UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

    @BeforeEach
    public void setUp()
    {
        unitOfMeasureCommandToUnitOfMeasure = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void nullObjectTest()
    {
        assertNull(unitOfMeasureCommandToUnitOfMeasure.convert(null));
    }

    @Test
    public void emptyObjectTest()
    {
        assertNotNull(unitOfMeasureCommandToUnitOfMeasure.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert()
    {
        // given
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(ID_VALUE);
        unitOfMeasureCommand.setDescription(DESCRIPTION);

        // when
        UnitOfMeasure unitOfMeasure = unitOfMeasureCommandToUnitOfMeasure.convert(unitOfMeasureCommand);

        // then
        assertEquals(ID_VALUE, unitOfMeasure.getId());
        assertEquals(DESCRIPTION, unitOfMeasure.getDescription());
    }
}