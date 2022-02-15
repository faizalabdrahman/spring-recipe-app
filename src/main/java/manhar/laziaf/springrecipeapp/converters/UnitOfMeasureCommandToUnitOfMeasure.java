package manhar.laziaf.springrecipeapp.converters;

import manhar.laziaf.springrecipeapp.commands.UnitOfMeasureCommand;
import manhar.laziaf.springrecipeapp.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;

public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure>
{
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand)
    {
        if(unitOfMeasureCommand == null)
        {
            return null;
        }

        final UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(unitOfMeasureCommand.getId());
        unitOfMeasure.setDescription(unitOfMeasureCommand.getDescription());

        return unitOfMeasure;
    }
}
