package manhar.laziaf.springrecipeapp.bootstrap;

import lombok.extern.slf4j.Slf4j;
import manhar.laziaf.springrecipeapp.domain.*;
import manhar.laziaf.springrecipeapp.repositories.CategoryRepository;
import manhar.laziaf.springrecipeapp.repositories.RecipeRepository;
import manhar.laziaf.springrecipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository)
    {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        recipeRepository.saveAll(getRecipeList());
        log.debug("Loading bootstrap data");
    }

    private List<Recipe> getRecipeList()
    {
        List<Recipe> recipeList = new ArrayList<>();

        // get all unit of measures
        Optional<UnitOfMeasure> eachUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Each");

        if(eachUnitOfMeasureOptional.isEmpty())
        {
            throw new RuntimeException("Expected 'Each' unit of measure not found");
        }

        Optional<UnitOfMeasure> tablespoonUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(tablespoonUnitOfMeasureOptional.isEmpty())
        {
            throw new RuntimeException("Expected 'Tablespoon' unit of measure not found");
        }

        Optional<UnitOfMeasure> teaspoonUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(teaspoonUnitOfMeasureOptional.isEmpty())
        {
            throw new RuntimeException("Expected 'Teaspoon' unit of measure not found");
        }

        Optional<UnitOfMeasure> dashUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(dashUnitOfMeasureOptional.isEmpty())
        {
            throw new RuntimeException("Expected 'Dash' unit of measure not found");
        }

        Optional<UnitOfMeasure> pintUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Pint");

        if(pintUnitOfMeasureOptional.isEmpty())
        {
            throw new RuntimeException("Expected 'Pint' unit of measure not found");
        }

        Optional<UnitOfMeasure> cupUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(cupUnitOfMeasureOptional.isEmpty())
        {
            throw new RuntimeException("Expected 'Cup' unit of measure not found");
        }

        // get optionals
        UnitOfMeasure eachUnitOfMeasure = eachUnitOfMeasureOptional.get();
        UnitOfMeasure tablespoonUnitOfMeasure = tablespoonUnitOfMeasureOptional.get();
        UnitOfMeasure teaspoonUnitOfMeasure = teaspoonUnitOfMeasureOptional.get();
        UnitOfMeasure dashUnitOfMeasure = dashUnitOfMeasureOptional.get();
        UnitOfMeasure pintUnitOfMeasure = pintUnitOfMeasureOptional.get();
        UnitOfMeasure cupUnitOfMeasure = cupUnitOfMeasureOptional.get();

        // get catagories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(americanCategoryOptional.isEmpty())
        {
            throw new RuntimeException("Expected 'American' category not found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(mexicanCategoryOptional.isEmpty())
        {
            throw new RuntimeException("Expected 'Mexican' category not found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        // oatmeal bread
        Recipe oatmealBreadRecipe = new Recipe();
        oatmealBreadRecipe.setDescription("Oatmeal Bread");
        oatmealBreadRecipe.setPrepTime(45);
        oatmealBreadRecipe.setCookTime(35);
        oatmealBreadRecipe.setDifficulty(Difficulty.EASY);
        oatmealBreadRecipe.setDirections("1. Make the oatmeal:\n" +
                "In the bowl of a stand mixer, or a large mixing bowl, combine the oats, whole wheat flour, " +
                "and boiling water with a wooden spoon. Allow the mixture to cool until just barely warm, 20 to 25 minutes." +
                "\n\n2. Make the dough:\n" +
                "Add the milk, yeast, salt, honey, vegetable oil, and bread flour into the bowl with the oatmeal.\n" +
                "Mix on low speed with the dough hook attachment, or by hand with a wooden spoon, until all the ingredients " +
                "are incorporated and it forms a shaggy dough. There shouldn’t be any dry spots of flour, but the surface " +
                "will still be rough." +
                "\n\n3. Knead the dough:\n" +
                "Continue to mix on low speed for 5 minutes, kneading the dough.\n" +
                "If mixing by hand, turn the dough out onto a floured work surface and knead by hand for 10 minutes. " +
                "Use the palm of your hand to push the dough down and away from you, stretching the dough. Then, fold " +
                "the dough in half towards you, rotate it 90 degrees, and press and extend the dough again. Continue " +
                "pressing, stretching, and rotating to knead the dough.\n" +
                "It will be very sticky at the beginning but try not to add more flour, as it will make the loaf dry. " +
                "After kneading, the dough should be elastic and somewhat smooth, but still very soft." +
                "\n\n4. Let the dough rise:\n" +
                "Form the dough into a ball and place it in a clean, lightly oiled bowl. Cover with plastic wrap or a " +
                "clean tea towel and let it rise in a warm spot until roughly doubled in size, about 1 1/2 hours." +
                "\n\n5. Prepare the pans:\n" +
                "Lightly grease two standard loaf pans (8 1/2 x 4 1/2-inch) with butter or vegetable oil." +
                "\n\n6. Shape the loaves:\n" +
                "Tip the dough out onto a floured work surface and divide the dough into two equal pieces with a bench " +
                "scraper or a long knife.\n" +
                "To shape the dough into a loaf, use your hands to gently stretch one of the pieces of dough into a puffy " +
                "rectangle with the short edge slightly narrower than the length of the pan, about 6 by 8 inches.\n" +
                "Roll the dough up into a log starting at the short edge and pinch the seam closed. Place the loaf seam-side " +
                "down in one of the greased pans. Repeat with the second piece of dough." +
                "\n\n7. Let the dough rise again:\n" +
                "Tent the pans with lightly greased plastic wrap or a clean tea towel. Let them rise in a warm spot for " +
                "1 to 1 1/2 hours, or until the bread rises to about 1 inch above the rim of the pan." +
                "\n\n8. Preheat the oven:\n" +
                "When the bread has nearly finished rising, preheat the oven to 375°F." +
                "\n\n9. Make the egg wash:\n" +
                "In a small bowl, beat the egg with a tablespoon of water until thoroughly combined." +
                "\n\n10. Add topping to loaves:\n" +
                "To add the topping, uncover the risen loaves. Brush the egg wash with a pastry brush over the top crust " +
                "of the loaves (you won't use all of the egg wash). Sprinkle each loaf with a couple of tablespoons of oats." +
                "\n\n11. Bake the loaves:\n" +
                "Bake the bread for 35 to 40 minutes, or until they’re golden brown and sound hollow when the bottoms are " +
                "tapped. If you have a digital thermometer, the internal temperature of the bread should register 190°F." +
                "\n\n12. Cool the loaves and slice:\n" +
                "Turn the loaves out onto a wire rack to cool. Let the loaves cool completely before slicing. You should " +
                "get 12 to 16 slices per loaf, depending on how thick you slice it.");

        Notes oatmealBreadNotes = new Notes();
        oatmealBreadNotes.setRecipeNotes("To improve the bread's taste, do overnight rest in the refrigerator after a final shape. " +
                "The slow fermentation in the fridge further improves the bread’s flavor as well.");

        oatmealBreadRecipe.setNotes(oatmealBreadNotes);

        oatmealBreadRecipe.addIngredient(new Ingredient("old-fashioned oats", new BigDecimal(2), cupUnitOfMeasure));
        oatmealBreadRecipe.addIngredient(new Ingredient("whole wheat flour", new BigDecimal(1), cupUnitOfMeasure));
        oatmealBreadRecipe.addIngredient(new Ingredient("boiling water", new BigDecimal(2), cupUnitOfMeasure));
        oatmealBreadRecipe.addIngredient(new Ingredient("whole milk", new BigDecimal(2), cupUnitOfMeasure));
        oatmealBreadRecipe.addIngredient(new Ingredient("instant yeast", new BigDecimal(4), teaspoonUnitOfMeasure));
        oatmealBreadRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(1), tablespoonUnitOfMeasure));
        oatmealBreadRecipe.addIngredient(new Ingredient("honey", new BigDecimal(6), tablespoonUnitOfMeasure));
        oatmealBreadRecipe.addIngredient(new Ingredient("vegetable oil, plus more for greasing the pans", new BigDecimal(6), tablespoonUnitOfMeasure));
        oatmealBreadRecipe.addIngredient(new Ingredient("bread flour, plus more for dusting", new BigDecimal(5), cupUnitOfMeasure));

        oatmealBreadRecipe.getCategorySet().add(americanCategory);
        oatmealBreadRecipe.getCategorySet().add(mexicanCategory);

        recipeList.add(oatmealBreadRecipe);

        // charred citrus dressing
        Recipe charredCitrusDressingRecipe = new Recipe();
        charredCitrusDressingRecipe.setDescription("Charred Citrus Dressing");
        charredCitrusDressingRecipe.setPrepTime(10);
        charredCitrusDressingRecipe.setCookTime(5);
        charredCitrusDressingRecipe.setDifficulty(Difficulty.EASY);
        charredCitrusDressingRecipe.setDirections("1. Char the lemons:\n" +
                "Thinly slice 1 lemon and 1 lime, about 1/4 inch thick. Remove and discard the seeds. In a large cast iron" +
                " or non-stick skillet set over medium-high heat, add the olive oil. When the oil starts rippling but not " +
                "smoking, add the lemon and lime slices in an even layer. They can be closely next to each other but should" +
                " not overlap.\n" +
                "Cook them for 3 minutes, until browned all over and charred in some spots. Use a pair or tongs or a fork " +
                "to flip them over. Cook the other side for 1 to 2 minutes, then turn off the heat." +
                "\n\n2. Make the dressing:\n" +
                "Transfer the charred citrus into a blender. Juice the remaining lime and lemon. Add 2 tablespoons of lemon" +
                " and 2 tablespoons of lime juice to the blender. Save any remaining juice for another day.\n" +
                "Add the garlic, salt, and black pepper to the blender. Place the lid on and blend on medium speed until " +
                "the citrus is broken down, about 15 seconds.\n" +
                "Lower the speed to low and remove the center cap off the lid. Slowly, drizzle in the oil. This should take" +
                " about 30 seconds. If the dressing splatters out the top, you can use a clean dish towel or your hands to" +
                " partially cover the opening as you drizzle the oil in.\n" +
                "Increase the speed to medium speed and blend until the dressing is smooth and emulsified, about 15 seconds." +
                "\n\nServe:\n" +
                "The dressing will be warm. Serve it immediately or transfer it into a lidded container, like a mason jar, " +
                "cool, and refrigerate it until ready to use.");

        Notes charredCitrusDressingNotes = new Notes();
        charredCitrusDressingNotes.setRecipeNotes("This dressing keeps well in the fridge for up to one week. Since it contains" +
                " a clove of raw garlic, its flavor may intensify over time. If this is of concern to you, try half of a clove" +
                " or omit it. I don’t find the garlic overwhelming since the flavor of charred citrus is most prevalent.\n" +
                "Store the dressing in a tightly sealed container like a mason jar. It may separate as it sits, but the " +
                "blended lemons and limes act as an emulsifier—it should not break the way many dressings do. Shake it " +
                "to re-incorporate the dressing.");

        charredCitrusDressingRecipe.setNotes(charredCitrusDressingNotes);

        charredCitrusDressingRecipe.addIngredient(new Ingredient("olive oil", new BigDecimal(1), tablespoonUnitOfMeasure));
        charredCitrusDressingRecipe.addIngredient(new Ingredient("lemons", new BigDecimal(2), cupUnitOfMeasure));
        charredCitrusDressingRecipe.addIngredient(new Ingredient("limes", new BigDecimal(2), cupUnitOfMeasure));
        charredCitrusDressingRecipe.addIngredient(new Ingredient("garlic", new BigDecimal(1), dashUnitOfMeasure));
        charredCitrusDressingRecipe.addIngredient(new Ingredient("sea salt", new BigDecimal(1), teaspoonUnitOfMeasure));
        charredCitrusDressingRecipe.addIngredient(new Ingredient("ground black pepper", new BigDecimal(1), teaspoonUnitOfMeasure));
        charredCitrusDressingRecipe.addIngredient(new Ingredient("neutral oil, such as grapeseed, avocado, or vegetable", new BigDecimal(1), cupUnitOfMeasure));

        charredCitrusDressingRecipe.getCategorySet().add(americanCategory);
        charredCitrusDressingRecipe.getCategorySet().add(mexicanCategory);

        recipeList.add(charredCitrusDressingRecipe);

        return recipeList;

    }
}
