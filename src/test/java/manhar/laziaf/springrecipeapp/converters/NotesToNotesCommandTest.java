package manhar.laziaf.springrecipeapp.converters;

import manhar.laziaf.springrecipeapp.commands.NotesCommand;
import manhar.laziaf.springrecipeapp.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotesToNotesCommandTest
{
    private static final Long ID_VALUE = 1L;
    private static final String RECIPE_NOTES = "recipeNotes";

    NotesToNotesCommand notesToNotesCommand;

    @BeforeEach
    public void setUp()
    {
        notesToNotesCommand = new NotesToNotesCommand();
    }

    @Test
    public void nullObjectTest()
    {
        assertNull(notesToNotesCommand.convert(null));
    }

    @Test
    public void emptyObjectTest()
    {
        assertNotNull(notesToNotesCommand.convert(new Notes()));
    }

    @Test
    public void convert()
    {
        // given
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        // when
        NotesCommand notesCommand = notesToNotesCommand.convert(notes);

        // then
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
    }
}