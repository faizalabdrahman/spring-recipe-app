package manhar.laziaf.springrecipeapp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService
{
    private final RecipeService recipeService;

    public ImageServiceImpl(RecipeService recipeService)
    {
        this.recipeService = recipeService;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile imageFile)
    {
        log.debug("Received a file");

    }
}
