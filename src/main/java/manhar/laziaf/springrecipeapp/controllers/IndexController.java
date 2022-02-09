package manhar.laziaf.springrecipeapp.controllers;

import manhar.laziaf.springrecipeapp.domain.Category;
import manhar.laziaf.springrecipeapp.domain.UnitOfMeasure;
import manhar.laziaf.springrecipeapp.repositories.CategoryRepository;
import manhar.laziaf.springrecipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class IndexController
{
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository)
    {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @GetMapping({"", "/", "/index"})
    public String getIndexPage()
    {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is: " + categoryOptional.get().getId());
        System.out.println("Unit Of Measure Id is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
