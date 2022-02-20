package manhar.laziaf.springrecipeapp.services;

import manhar.laziaf.springrecipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService
{
    Set<UnitOfMeasureCommand> listAllUnitOfMeasure();
}
