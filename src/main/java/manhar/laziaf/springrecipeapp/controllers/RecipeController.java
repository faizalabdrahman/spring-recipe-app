package manhar.laziaf.springrecipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import manhar.laziaf.springrecipeapp.commands.RecipeCommand;
import manhar.laziaf.springrecipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class RecipeController
{
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService)
    {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{recipeId}/show")
    public String getRecipeById(@PathVariable String recipeId, Model model)
    {
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(recipeId)));

        return "recipe/show";
    }

    @GetMapping("recipe/new")
    public String newRecipeForm(Model model)
    {
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @GetMapping("recipe/{recipeId}/update")
    public String updateRecipe(@PathVariable String recipeId, Model model)
    {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/recipeform";
    }

    @PostMapping("recipe")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand recipeCommand)
    {
        RecipeCommand savedRecipeCommand = recipeService.savedRecipeCommand(recipeCommand);

        return "redirect:/recipe/" + savedRecipeCommand.getId() + "/show";
    }

    @GetMapping("recipe/{recipeId}/delete")
    public String deleteRecipe(@PathVariable String recipeId)
    {
        recipeService.deleteById(Long.valueOf(recipeId));

        return "redirect:/";
    }

}
