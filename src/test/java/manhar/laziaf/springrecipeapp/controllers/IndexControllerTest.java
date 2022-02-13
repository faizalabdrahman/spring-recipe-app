package manhar.laziaf.springrecipeapp.controllers;

import manhar.laziaf.springrecipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IndexControllerTest
{
    @Mock
    RecipeService recipeService;

    IndexController indexController;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);

        indexController = new IndexController(recipeService);

        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

    }

    @Test
    public void getIndexPage() throws Exception
    {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("recipes"))
                .andExpect(view().name("index"));


    }
}