package manhar.laziaf.springrecipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import manhar.laziaf.springrecipeapp.commands.IngredientCommand;
import manhar.laziaf.springrecipeapp.commands.UnitOfMeasureCommand;
import manhar.laziaf.springrecipeapp.services.IngredientService;
import manhar.laziaf.springrecipeapp.services.RecipeService;
import manhar.laziaf.springrecipeapp.services.UnitOfMeasureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IngredientController
{
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService)
    {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model)
    {
        log.debug("Getting ingredient list for recipe id: " + recipeId);

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/list";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}/show")
    public String showRecipeIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model)
    {
        model.addAttribute("ingredient",
                ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(ingredientId)));

        return "recipe/ingredient/show";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/new")
    public String newRecipeIngredient(@PathVariable String recipeId, Model model)
    {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(Long.valueOf(recipeId));
        ingredientCommand.setUnitOfMeasure(new UnitOfMeasureCommand());
        model.addAttribute("ingredient", ingredientCommand);

        model.addAttribute("unitOfMeasureList", unitOfMeasureService.listAllUnitOfMeasure());

        return "recipe/ingredient/ingredientform";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model)
    {
        model.addAttribute("ingredient",
                ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(ingredientId)));
        model.addAttribute("unitOfMeasureList", unitOfMeasureService.listAllUnitOfMeasure());

        return "recipe/ingredient/ingredientform";
    }

    @PostMapping("/recipe/{recipeId}/ingredient")
    public String saveOrUpdateIngredient(@ModelAttribute IngredientCommand ingredientCommand)
    {
        IngredientCommand savedIngredientCommand = ingredientService.saveIngredientCommand(ingredientCommand);

        log.debug("saved recipe id: " + savedIngredientCommand.getRecipeId());
        log.debug("saved ingredient id: " + savedIngredientCommand.getId());

        return "redirect:/recipe/" + savedIngredientCommand.getRecipeId() + "/ingredient/"
                + savedIngredientCommand.getId() + "/show";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}/delete")
    public String deleteIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model)
    {
        ingredientService.deleteById(Long.valueOf(recipeId), Long.valueOf(ingredientId));

        return "redirect:/recipe/" + recipeId +"/ingredients";
    }
}
