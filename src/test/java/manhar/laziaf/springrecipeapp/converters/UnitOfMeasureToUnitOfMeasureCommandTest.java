package manhar.laziaf.springrecipeapp.converters;

import manhar.laziaf.springrecipeapp.commands.UnitOfMeasureCommand;
import manhar.laziaf.springrecipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest
{
    private final static Long ID_VALUE = 1L;
    private final static String DESCRIPTION = "description";

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @BeforeEach
    public void setUp()
    {
        unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void nullObjectTest()
    {
        assertNull(unitOfMeasureToUnitOfMeasureCommand.convert(null));
    }

    @Test
    public void emptyObjectTest()
    {
        assertNotNull(unitOfMeasureToUnitOfMeasureCommand.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert()
    {
        // given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID_VALUE);
        unitOfMeasure.setDescription(DESCRIPTION);

        // when
        UnitOfMeasureCommand unitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand.convert(unitOfMeasure);

        // then
        assertEquals(ID_VALUE, unitOfMeasureCommand.getId());
        assertEquals(DESCRIPTION, unitOfMeasureCommand.getDescription());
    }
}