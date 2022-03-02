package manhar.laziaf.springrecipeapp.bootstrap;

import lombok.extern.slf4j.Slf4j;
import manhar.laziaf.springrecipeapp.domain.Category;
import manhar.laziaf.springrecipeapp.domain.UnitOfMeasure;
import manhar.laziaf.springrecipeapp.repositories.CategoryRepository;
import manhar.laziaf.springrecipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootStrapMySQL implements ApplicationListener<ContextRefreshedEvent>
{
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootStrapMySQL(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository)
    {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        if (categoryRepository.count() == 0L)
        {
            log.debug("Loading Categories");
            loadCategories();
        }

        if (unitOfMeasureRepository.count() == 0L)
        {
            log.debug("Loading UOMs");
            loadUnitOfMeasure();
        }
    }

    private void loadCategories()
    {
        Category cat1 = new Category();
        cat1.setDescription("American");
        categoryRepository.save(cat1);

        Category cat2 = new Category();
        cat2.setDescription("Italian");
        categoryRepository.save(cat2);

        Category cat3 = new Category();
        cat3.setDescription("Mexican");
        categoryRepository.save(cat3);

        Category cat4 = new Category();
        cat4.setDescription("Fast Food");
        categoryRepository.save(cat4);
    }

    private void loadUnitOfMeasure()
    {
        UnitOfMeasure unitOfMeasure1 = new UnitOfMeasure();
        unitOfMeasure1.setDescription("Teaspoon");
        unitOfMeasureRepository.save(unitOfMeasure1);

        UnitOfMeasure unitOfMeasure2 = new UnitOfMeasure();
        unitOfMeasure2.setDescription("Tablespoon");
        unitOfMeasureRepository.save(unitOfMeasure2);

        UnitOfMeasure unitOfMeasure3 = new UnitOfMeasure();
        unitOfMeasure3.setDescription("Cup");
        unitOfMeasureRepository.save(unitOfMeasure3);

        UnitOfMeasure unitOfMeasure4 = new UnitOfMeasure();
        unitOfMeasure4.setDescription("Pinch");
        unitOfMeasureRepository.save(unitOfMeasure4);

        UnitOfMeasure unitOfMeasure5 = new UnitOfMeasure();
        unitOfMeasure5.setDescription("Ounce");
        unitOfMeasureRepository.save(unitOfMeasure5);

        UnitOfMeasure unitOfMeasure6 = new UnitOfMeasure();
        unitOfMeasure6.setDescription("Each");
        unitOfMeasureRepository.save(unitOfMeasure6);

        UnitOfMeasure unitOfMeasure7 = new UnitOfMeasure();
        unitOfMeasure7.setDescription("Pint");
        unitOfMeasureRepository.save(unitOfMeasure7);

        UnitOfMeasure unitOfMeasure8 = new UnitOfMeasure();
        unitOfMeasure8.setDescription("Dash");
        unitOfMeasureRepository.save(unitOfMeasure8);
    }
}

