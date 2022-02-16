package manhar.laziaf.springrecipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import manhar.laziaf.springrecipeapp.commands.RecipeCommand;
import manhar.laziaf.springrecipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class RecipeController
{
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService)
    {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/show/{recipeId}")
    public String getRecipeById(@PathVariable String recipeId, Model model)
    {
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(recipeId)));

        return "recipe/show";
    }

    @GetMapping("recipe/new")
    public String initNewOrUpdateRecipeForm(Model model)
    {
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

}
