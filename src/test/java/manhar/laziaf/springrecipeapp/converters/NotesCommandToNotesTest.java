package manhar.laziaf.springrecipeapp.converters;

import manhar.laziaf.springrecipeapp.commands.NotesCommand;
import manhar.laziaf.springrecipeapp.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotesCommandToNotesTest
{
    private static final Long ID_VALUE = 1L;
    private static final String RECIPE_NOTES = "recipeNotes";

    NotesCommandToNotes notesCommandToNotes;

    @BeforeEach
    public void setUp()
    {
        notesCommandToNotes = new NotesCommandToNotes();
    }

    @Test
    public void nullObjectTest()
    {
        assertNull(notesCommandToNotes.convert(null));
    }

    @Test
    public void emptyObjectTest()
    {
        assertNotNull(notesCommandToNotes.convert(new NotesCommand()));
    }

    @Test
    public void convert()
    {
        // given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        // when
        Notes notes = notesCommandToNotes.convert(notesCommand);

        // then
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }
}