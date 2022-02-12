package manhar.laziaf.springrecipeapp.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NotesTest
{
    Notes notes;

    @BeforeEach
    public void setUp()
    {
        notes = new Notes();
        notes.setId(1L);
        notes.setRecipeNotes("This is a description");
        notes.setRecipe(new Recipe());
    }

    @Test
    public void getId()
    {
        assertEquals(1L, notes.getId());
    }

    @Test
    public void getRecipeNotes()
    {
        assertEquals("This is a description", notes.getRecipeNotes());
    }

    @Test
    public void getRecipe()
    {
        assertNotNull(notes.getRecipeNotes());
    }
}