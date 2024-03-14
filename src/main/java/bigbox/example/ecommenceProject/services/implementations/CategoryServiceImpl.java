package bigbox.example.ecommenceProject.services.implementations;

import bigbox.example.ecommenceProject.services.contracts.CategoryService;
import bigbox.example.ecommenceProject.utils.results.DataResult;
import bigbox.example.ecommenceProject.utils.results.SuccessDataResult;
import bigbox.example.ecommenceProject.repositories.CategoryRepository;
import bigbox.example.ecommenceProject.entities.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public DataResult<List<Category>> getAllCategories() {
        return new SuccessDataResult<>(categoryRepository.findAll());
    }
}
