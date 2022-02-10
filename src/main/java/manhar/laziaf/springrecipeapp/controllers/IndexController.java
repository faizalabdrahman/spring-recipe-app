package manhar.laziaf.springrecipeapp.controllers;

import manhar.laziaf.springrecipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController
{
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService)
    {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/", "/index"})
    public String getIndexPage(Model model)
    {
        model.addAttribute("recipes", recipeService.getRecipeSet());

        return "index";
    }
}
